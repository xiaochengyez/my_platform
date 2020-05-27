package com.gongxc.platform_api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;


@Data
@Entity(name = "cases")
@Table(name = "interface_cases")
@ApiModel(description = "用例模型")
public class Cases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "用例ID", name = "id")
    private Long id;

    @Column(name = "name")
    @NotBlank(message = "用例名不能为空")
    @ApiModelProperty(value = "用例名称", name = "name", required = true, example = "登录用例")
    private String name;

    private Long interfaceId;

    @Column(name = "description")
    @ApiModelProperty(value = "用例描述", name = "description", required = true, example = "登录")
    private String description;


    @Column(name = "expect")
    @ApiModelProperty(value = "用例期望", name = "expect", required = true, example = "pass")
    private String expect;

    @Column(name = "case_type")
    private int caseType;


    @Column(name = "remark")
    @ApiModelProperty(value = "用例标记", name = "remark", required = true, example = "登录")
    private String remark;

    @Column(name = "create_time")
    private Long createTime;

    @Column(name = "update_time")
    private Long updateTime;

    @Column(name = "creator")
    @ApiModelProperty(value = "用例创建者", name = "creator", required = true, example = "gongxc")
    private String creator;

    public Cases(){

    }
}
