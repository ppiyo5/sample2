package com.sample.aladin.academy.repository;

import com.sample.aladin.academy.domain.Academy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcademyRepository extends JpaRepository<Academy, Long>, AcademyRepositoryCustom {
}
