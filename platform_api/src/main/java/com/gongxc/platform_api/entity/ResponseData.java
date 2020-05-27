package com.gongxc.platform_api.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;

/**
 * <p>
 * 响应结果
 * </p>
 *
 * @author gongxc
 * @date 2020/5/26
 */

@Data
@Entity(name = "ResponseData")
@Table(name = "results")
@ApiModel(description = "响应结果")
public class ResponseData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Null(message = "id必须为空")
    @Column(name = "id")
    @ApiModelProperty(value = "响应id", name = "id")
    private Long id;


    private String name;

    private String result;

}
