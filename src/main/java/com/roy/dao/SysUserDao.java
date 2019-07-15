package com.roy.dao;

import com.roy.beans.pojo.SysUser;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("sysUserDao")
public interface SysUserDao {
    /***
     * 分页查询
     * @param params 参数
     * @return 集合
     */
    public List<SysUser> findByPage(Map<String,Object> params);

    /***
     * 查询总数
     * @param params 参数
     * @return 数量
     */
    public long findCount(Map<String,Object> params);
}
