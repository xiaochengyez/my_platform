package com.gongxc.platform_api.service.impl;

import com.gongxc.platform_api.dao.CaseRepository;
import com.gongxc.platform_api.entity.Cases;
import com.gongxc.platform_api.service.CaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CaseServiceImpl implements CaseService {

    @Autowired
    private CaseRepository caseRepository;

    @Override
    public long getCount() {
        return caseRepository.count();
    }

    @Override
    public List<Cases> findAll() {
        return caseRepository.findAll();
    }

    @Override
    public Optional<Cases> findCaseById(Long id) {
        return caseRepository.findById(id);
    }

    @Override
    public Cases save(Cases cases) {
        return caseRepository.save(cases);
    }

    @Override
    public void update(Long id, String name) {
        caseRepository.change(name,id);
    }


    @Override
    public void deleteById(Long id) {
        caseRepository.deleteById(id);
    }

    @Override
    public void run(Long id) {

        caseRepository.run(id);
    }
}
