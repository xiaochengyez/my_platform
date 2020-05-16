package com.gongxc.common.service;

import com.gongxc.common.dao.MockDao;
import com.gongxc.common.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务
 * </p>
 *
 * @author gongxc
 * @date 2020/5/16
 */
@Service
public class MockService {
    @Resource
    private MockDao mockDao;

    public User getUser() {
        return mockDao.getUser("http://127.0.0.1:8082/hello");
    }

    public String get() {
        return mockDao.access("http://127.0.0.1:8082/hello");
    }
}
