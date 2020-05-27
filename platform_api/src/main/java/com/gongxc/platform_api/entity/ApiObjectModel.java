package com.gongxc.platform_api.entity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

@Data
@Entity(name = "apiObjectModel")
@Table(name = "interfaces")
@ApiModel(description = "接口模型")
public class ApiObjectModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "接口ID", name = "id")
    private Long id;


    @Column(name = "name")
    @NotBlank(message = "接口名不能为空")
    @ApiModelProperty(value = "接口名称", name = "name", required = true, example = "百度查询接口")
    private String name;


    @Column(name = "address")
    @ApiModelProperty(value = "接口地址", name = "address", required = true, example = "http://www.baidu.com")
    private String address;

    @Column(name = "author")
    @ApiModelProperty(value = "开发者", name = "author", required = true, example = "龚晓成")
    private String author;

    @Column(name = "description")
    @ApiModelProperty(value = "用例描述", name = "description", required = true, example = "查询接口")
    private String description;

    @Column(name = "headers")
    @ApiModelProperty(value = "请求头信息",name = "headers",required = true,example = "{\"Content-type\":\"application/json;charset=UTF-8\"}")
    private String headers;

    @Column(name = "query")
    @ApiModelProperty(value = "请求参数",name = "query",required = true,example = "{\"wd\":\"gongxc\"}")
    private String query;

    @Column(name = "json")
    @ApiModelProperty(value = "json",name = "headers",required = true,example = "{\"city\":\"010\",\"couponActivityType\":\"1\"}")
    private String json;

    @Column(name = "remark")
    @ApiModelProperty(value = "标记",name = "remark",required = true)
    private String remark ;

    @Column(name = "method")
    @ApiModelProperty(value = "方法",name = "method",required = true,example = "get")
    private String method ;

    @Column(name = "controller_name")
    @ApiModelProperty(value = "控制类",name = "controller_name",required = true,example = "CaseController")
    private String controller_name;

    @Column(name = "create_time")
    private Long createTime;


}

