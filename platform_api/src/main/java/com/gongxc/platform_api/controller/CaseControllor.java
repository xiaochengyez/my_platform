package com.gongxc.platform_api.controller;

import com.gongxc.platform_api.common.ResponseResult;
import com.gongxc.platform_api.entity.Cases;
import com.gongxc.platform_api.service.CaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/case",produces = "application/json")
@Api(value="Cases",tags = {"测试平台"}, description = "接口测试平台")
public class CaseControllor {

    @Autowired
    private CaseService caseService;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "使用id查询用例")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",paramType = "path",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<Cases>> findcaseById(@PathVariable("id") Long id){

        Optional<Cases> cases= caseService.findUserById(id);
        return ResponseResult.successWithData(cases);
    }


    @GetMapping("/getCount")
    @ApiOperation(value = "查询用例数量")
    public ResponseResult getCount(){
        Long count = caseService.getCount();
        return ResponseResult.successWithData(count);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除用例")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<Cases>> deleteById(Long id){
        caseService.deleteById(id);
        List<Cases> casess = caseService.findAll();
        return ResponseResult.successWithData(casess);
    }

    @PostMapping("/create")
    @ApiOperation(value = "创建用例")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Cases> createcases(@Validated @RequestBody Cases cases){
        Cases dbcases = caseService.save(cases);
        return ResponseResult.successWithData(dbcases);
    }

    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有用例")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<Cases>> findAll(){
        List<Cases> casess = caseService.findAll();
        return ResponseResult.successWithData(casess);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新用例名称")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1"),
            @ApiImplicitParam(value = "NAME",name = "name",dataType = "String",required = true,defaultValue = "登录")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<Cases>> updatecases(Long id,String name){
        caseService.update(id,name);
        Optional<Cases> cases1 = caseService.findUserById(id);
        return ResponseResult.successWithData(cases1);
    }

}
