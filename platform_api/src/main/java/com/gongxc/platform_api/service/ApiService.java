package com.gongxc.platform_api.service;

import com.gongxc.platform_api.entity.ApiObjectModel;
import com.gongxc.platform_api.entity.Cases;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 接口服务层
 * </p>
 *
 * @author gongxc
 * @date 2020/5/25
 */

public interface ApiService {

    long getCount();

    List<ApiObjectModel> findAll();

    Optional<ApiObjectModel> findApiById(Long id);

    ApiObjectModel save(ApiObjectModel apiObjectModel);

    void update(Long id, String name);

    void deleteById(Long id);
}
