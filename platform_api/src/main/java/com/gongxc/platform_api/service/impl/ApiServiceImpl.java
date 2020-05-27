package com.gongxc.platform_api.service.impl;

import com.gongxc.platform_api.dao.ApiRepository;
import com.gongxc.platform_api.entity.ApiObjectModel;
import com.gongxc.platform_api.service.ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 接口实现
 * </p>
 *
 * @author gongxc
 * @date 2020/5/25
 */
@Service
public class ApiServiceImpl implements ApiService {


    @Autowired
    private ApiRepository apiRepository;
    @Override
    public long getCount() {
        return apiRepository.count();
    }

    @Override
    public List<ApiObjectModel> findAll() {
        return apiRepository.findAll();
    }

    @Override
    public Optional<ApiObjectModel> findApiById(Long id) {
        return apiRepository.findById(id);
    }

    @Override
    public ApiObjectModel save(ApiObjectModel apiObjectModel) {
        return null;
    }

    @Override
    public void update(Long id, String name) {
//        apiRepository.change(name,id);
        ;
    }

    @Override
    public void deleteById(Long id) {
        apiRepository.deleteById(id);

    }
}
