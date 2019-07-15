package com.roy.controller;

import com.roy.beans.pojo.SysUser;
import com.roy.beans.vo.DataGridVO;
import com.roy.biz.SysUserBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author Roy
 * @date 2019-4-28
 *
 */
//@CrossOrigin(origins = "*",maxAge = 3600)//跨域访问设置
@RestController
@RequestMapping(value = "api/user",produces = "text/html;charset=utf-8")
@Api(tags = "用户API接口")
public class SysUserController {
    @Autowired
    private SysUserBiz sysUserBiz;

    @ApiOperation(value = "查询用户分页资料")
    @ApiImplicitParam(name="user",value = "用户实体",required = true,dataType = "User",paramType = "path")
    @RequestMapping(value="findByPage")
    public DataGridVO<SysUser> findByPage(SysUser user){
        return sysUserBiz.findByPage(user);
    }

    @ApiOperation(value = "测试方法1")
    @RequestMapping(value="my_doit1",method ={RequestMethod.GET,RequestMethod.POST})
    public String doit1(){
        return "";
    }

}
