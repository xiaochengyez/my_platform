package com.gongxc.platform_api.service.impl;

import com.gongxc.platform_api.dao.ResultRepository;
import com.gongxc.platform_api.entity.ResponseData;
import com.gongxc.platform_api.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * <p>
 * 实现
 * </p>
 *
 * @author gongxc
 * @date 2020/5/26
 */
@Service
public class ResultServiceImpl implements ResultService {

    @Autowired
    private ResultRepository resultRepository;

    @Override
    public ResponseData save(ResponseData data) {
        return resultRepository.save(data);
    }

    @Override
    public Optional<ResponseData> findResultById(Long id) {
        return resultRepository.findById(id);
    }
}
