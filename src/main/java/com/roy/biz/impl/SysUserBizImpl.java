package com.roy.biz.impl;

import com.github.pagehelper.PageHelper;
import com.roy.biz.SysUserBiz;
import com.roy.dao.SysUserDao;
import com.roy.beans.pojo.SysUser;
import com.roy.beans.vo.DataGridVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

@Service("sysUserBiz")
public class SysUserBizImpl implements SysUserBiz {
    @Autowired
    private SysUserDao sysUserDao;

    @Override
    public DataGridVO<SysUser> findByPage(SysUser user) {
        DataGridVO<SysUser> data=null;

        Map<String,Object> params=new HashMap<String,Object>();

        //使用第三方插件分页
        PageHelper.startPage(user.getPage(), user.getRows());

        List<SysUser> list=sysUserDao.findByPage(null);

        if(list !=null && list.size()>0) {
            data=new DataGridVO<SysUser>();
            data.setRows(list);
            data.setTotal(sysUserDao.findCount(null));
        }

        return data;
    }
}
