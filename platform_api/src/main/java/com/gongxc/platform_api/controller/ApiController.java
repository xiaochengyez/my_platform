package com.gongxc.platform_api.controller;

import com.gongxc.platform_api.common.ResponseResult;
import com.gongxc.platform_api.entity.ApiObjectModel;
import com.gongxc.platform_api.entity.Cases;
import com.gongxc.platform_api.service.ApiService;
import com.gongxc.platform_api.service.CaseService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * 控制层
 * </p>
 *
 * @author gongxc
 * @date 2020/5/25
 */
@RestController
@RequestMapping(value = "/interface",produces = "application/json")
@Api(value="interface",tags = {"接口"}, description = "接口")
public class ApiController {
    @Autowired
    private ApiService apiService;

    @GetMapping("/findById/{id}")
    @ApiOperation(value = "使用id查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "long",paramType = "path",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<ApiObjectModel>> findApiById(@PathVariable("id") Long id){

        Optional<ApiObjectModel> api= apiService.findApiById(id);
        return ResponseResult.successWithData(api);
    }


    @GetMapping("/getCount")
    @ApiOperation(value = "查询数量")
    public ResponseResult getCount(){
        Long count = apiService.getCount();
        return ResponseResult.successWithData(count);
    }

    @GetMapping("/delete")
    @ApiOperation(value = "删除接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<ApiObjectModel>> deleteById(Long id){
        Optional<ApiObjectModel> apiObjectModel =apiService.findApiById(id);
        if (apiObjectModel.isPresent()){
            apiService.deleteById(id);
            List<ApiObjectModel> api = apiService.findAll();
            return ResponseResult.successWithData(api);
        }else {
            return ResponseResult.failWithCodeAndMsg(1000,"接口不存在");
        }

    }

//    @PostMapping("/create")
//    @ApiOperation(value = "创建接口")
//    @ApiResponses({
//            @ApiResponse(code = 401,message = "未授权"),
//            @ApiResponse(code = 404,message = "请求路径不存在"),
//            @ApiResponse(code = 500, message = "服务器内部错误")
//    })
//    public ResponseResult<ApiObjectModel> createApi(@Validated @RequestBody ApiObjectModel apiObjectModel){
//
//        System.out.println(apiObjectModel.getHeaders());
//        return ResponseResult.failWithCodeAndMsg(200,"创建失败");
//    }

    @PostMapping("/findAll")
    @ApiOperation(value = "查询所有接口")
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<List<ApiObjectModel>> findAll(){
        List<ApiObjectModel> api = apiService.findAll();
        return ResponseResult.successWithData(api);
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新接口")
    @ApiImplicitParams({
            @ApiImplicitParam(value = "ID",name = "id",dataType = "int",required = true,defaultValue = "1"),
            @ApiImplicitParam(value = "NAME",name = "name",dataType = "String",required = true,defaultValue = "登录")
    })
    @ApiResponses({
            @ApiResponse(code = 401,message = "未授权"),
            @ApiResponse(code = 404,message = "请求路径不存在"),
            @ApiResponse(code = 500, message = "服务器内部错误")
    })
    public ResponseResult<Optional<ApiObjectModel>> updateApi(Long id,String name){
        apiService.update(id,name);
        Optional<ApiObjectModel> api = apiService.findApiById(id);
        return ResponseResult.successWithData(api);
    }
}
