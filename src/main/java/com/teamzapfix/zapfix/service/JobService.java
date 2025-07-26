package com.teamzapfix.zapfix.service;

import com.teamzapfix.zapfix.dto.request.JobRequestDto;
import com.teamzapfix.zapfix.dto.response.JobResponseDto;
import com.teamzapfix.zapfix.model.enums.JobStatus;

import java.time.LocalDate;
import java.util.List;

public interface JobService {
    JobResponseDto createJob(JobRequestDto dto);
    JobResponseDto getJobById(Long id);
    List<JobResponseDto> getAllJobs();
    List<JobResponseDto> getFilteredJobs(JobStatus state, Long clientId, LocalDate from, LocalDate to, Boolean isActive);
    JobResponseDto updateJobById(Long id, JobRequestDto dto);
    void deleteJobById(Long id);
}
