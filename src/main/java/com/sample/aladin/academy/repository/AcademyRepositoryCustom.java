package com.sample.aladin.academy.repository;

import com.sample.aladin.academy.domain.Academy;

import java.util.List;

public interface AcademyRepositoryCustom {
    List<Academy> findByName(String name);
}
