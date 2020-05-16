package com.gongxc.common.controller;

import com.gongxc.common.dao.MockDao;
import com.gongxc.common.entity.User;
import com.gongxc.common.service.MockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * mock controller
 * </p>
 *
 * @author gongxc
 * @date 2020/5/16
 */
@RestController
public class MockController {
    @Resource
    private MockService service;

    @GetMapping("user")
    public User getUserDO() {
        return service.getUser();
    }

    @GetMapping("get")
    public String access() {
        return service.get();
    }
}
