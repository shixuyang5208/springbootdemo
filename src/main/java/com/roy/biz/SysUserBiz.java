package com.roy.biz;


import com.roy.beans.pojo.SysUser;
import com.roy.beans.vo.DataGridVO;

public interface SysUserBiz {
    /***
     * 分页查询业务
     * @param user 参数实体
     * @return VO实体
     */
    public DataGridVO<SysUser> findByPage(SysUser user);
}
