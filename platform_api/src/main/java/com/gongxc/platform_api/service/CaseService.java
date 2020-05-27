package com.gongxc.platform_api.service;

import com.gongxc.platform_api.entity.Cases;

import java.util.List;
import java.util.Optional;

public interface CaseService {
    long getCount();

    List<Cases> findAll();

    Optional<Cases> findCaseById(Long id);

    Cases save(Cases user);

    void update(Long id, String name);

    void deleteById(Long id);

    void run(Long id);
}
