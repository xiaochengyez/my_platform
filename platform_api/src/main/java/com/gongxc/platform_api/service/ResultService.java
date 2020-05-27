package com.gongxc.platform_api.service;

import com.gongxc.platform_api.entity.ResponseData;

import java.util.Optional;

/**
 * <p>
 * 服务层
 * </p>
 *
 * @author gongxc
 * @date 2020/5/26
 */

public interface ResultService {
    ResponseData save(ResponseData user);

    Optional<ResponseData> findResultById(Long id);
}
