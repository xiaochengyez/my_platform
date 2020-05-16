package com.gongxc.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * RestTemplateProvider
 * </p>
 *
 * @author gongxc
 * @date 2020/5/16
 */


@Configuration
public class RestTemplateProvider {

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}

