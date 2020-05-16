package com.gongxc.platform_api.common;


import static com.gongxc.platform_api.common.ResponseResult.ResponseParam;
import static com.gongxc.platform_api.common.ResponseResult.ResponseParam.buildParam;

/** ResponseCode
*
* @author gongxc
* @date 2020-05-14
*/
public enum ResponseCode {

   SUCCESS(buildParam(0, "成功"));
   public final  ResponseParam PARAM;
   ResponseCode(ResponseParam param){
       this.PARAM = param;
   }

}
