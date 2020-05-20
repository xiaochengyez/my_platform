package com.gongxc.platform_api.entity;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Map;

@Data
@Entity(name = "apiObjectModel")
@Table(name = "interface")
@ApiModel(description = "接口模型")
public class ApiObjectModel {
    private Map<String, Object> headerParams;
    private Map<String, Object> bodyParams;
    private Map<String, Object> params;
    private Map<String, Object> header;
    private Map<String, Object> query;
    private Map<String, Object> postBody;
    private String postBodyRaw;
    private String method = "get";
    private String baseUrl = "";
    private String url =  "";

}

