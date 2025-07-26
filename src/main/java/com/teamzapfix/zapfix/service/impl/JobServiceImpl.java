package com.teamzapfix.zapfix.service.impl;

import com.teamzapfix.zapfix.dto.request.JobRequestDto;
import com.teamzapfix.zapfix.dto.response.JobResponseDto;
import com.teamzapfix.zapfix.exception.JobNotFoundException;
import com.teamzapfix.zapfix.mapper.JobMapper;
import com.teamzapfix.zapfix.model.entity.Job;
import com.teamzapfix.zapfix.model.enums.JobStatus;
import com.teamzapfix.zapfix.repository.JobRepository;
import com.teamzapfix.zapfix.service.JobService;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class JobServiceImpl implements JobService {
    private JobRepository jobRepository;
    private JobMapper jobMapper;

    public JobServiceImpl(JobRepository jobRepository, JobMapper jobMapper){
        this.jobRepository = jobRepository;
        this.jobMapper = jobMapper;
    }

    @Override
    public JobResponseDto createJob(JobRequestDto dto) {
        Job job = jobMapper.toEntity(dto);
        Job saveJob = jobRepository.save(job);
        return jobMapper.toResponse(saveJob);
    }

    @Override
    public JobResponseDto getJobById(Long id) throws JobNotFoundException {
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
        return jobMapper.toResponse(job);
    }

    @Override
    public List<JobResponseDto> getAllJobs() {
        List<Job> jobs = jobRepository.findAll();
        return jobs.stream()
                .map(job -> jobMapper.toResponse(job))
                .collect(Collectors.toList());
    }

    @Override
    public List<JobResponseDto> getFilteredJobs(JobStatus state, Long clientId, LocalDate from, LocalDate to,Boolean isActive) {
        Specification<Job> spec = (root, query, cb) -> cb.conjunction(); //Instancia una especificacion neutra/vacia, despues se puede ir agregando "and.()"

        if (state != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("state"), state));
        }
        if (clientId != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("client").get("id"), clientId));
        }
        if (from != null) {
            spec = spec.and((root, query, cb) -> cb.greaterThanOrEqualTo(root.get("date"), from));
        }
        if (to != null) {
            spec = spec.and((root, query, cb) -> cb.lessThanOrEqualTo(root.get("date"), to));
        }
        if (isActive != null) {
            spec = spec.and((root, query, cb) -> cb.equal(root.get("isActive"), isActive));
        }

        List<Job> jobs = jobRepository.findAll(spec); //Lista de trabajos que concuerdan con filtro specificado
        return jobs.stream()
                .map(job -> jobMapper.toResponse(job))
                .collect(Collectors.toList());
    }

    @Override
    public JobResponseDto updateJobById(Long id, JobRequestDto dto) throws JobNotFoundException{
        Job job = jobRepository.findById(id)
                .orElseThrow(() -> new JobNotFoundException(id));
        job.setDescription(dto.getDescription());
        job.setCost(dto.getCost());
        job.setDeposit(dto.getDeposit());
        job.setState(dto.getState());

        Job updateJob = jobRepository.save(job);
        return jobMapper.toResponse(updateJob);
    }

    @Override
    public void deleteJobById(Long id) {

    }
}
