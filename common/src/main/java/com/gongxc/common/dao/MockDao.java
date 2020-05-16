package com.gongxc.common.dao;

import com.gongxc.common.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * MockDao
 * </p>
 *
 * @author gongxc
 * @date 2020/5/16
 */

@Repository
public class MockDao {
    @Autowired
    private RestTemplate restTemplate;

    public String access(String url) {
        ResponseEntity<String> result = restTemplate.getForEntity(url, String.class);
        System.out.println(result);
        return result.getBody();
    }

    public User getUser(String url) {
        ResponseEntity<User> responseEntity = restTemplate.getForEntity(url, User.class);
        return responseEntity.getBody();
    }
}
