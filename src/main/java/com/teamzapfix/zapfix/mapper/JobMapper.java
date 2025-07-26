package com.teamzapfix.zapfix.mapper;

import com.teamzapfix.zapfix.dto.request.JobRequestDto;
import com.teamzapfix.zapfix.dto.response.JobResponseDto;
import org.mapstruct.Mapper;
import com.teamzapfix.zapfix.model.entity.Job;

@Mapper(componentModel = "spring")
public interface JobMapper {
    Job toEntity(JobRequestDto dto);
    JobResponseDto toResponse(Job job);
}
