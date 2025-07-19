package com.teamzapfix.zapfix.repository;

import com.teamzapfix.zapfix.model.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> {
}
