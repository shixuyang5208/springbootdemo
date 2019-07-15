package com.roy.controller;

import com.alibaba.fastjson.JSON;
import com.roy.beans.vo.ResultVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@RequestMapping(value="api/file",produces = "text/html;charset=utf-8")
public class FileController {
    @RequestMapping("upload")
    @ResponseBody
    public String upload(int id,String name,@RequestParam("file") MultipartFile file){
        ResultVO resVO =new ResultVO();
        resVO.setMsg("上传失败");

        if(!file.isEmpty()){
            //得到新的文件名防止重名
            String fileName = createFileName(file.getOriginalFilename());
            String filePath = "D://royup//";
            File dest = new File(filePath + fileName);

            if(!dest.getParentFile().exists()){
                dest.getParentFile().mkdirs();
            }
            try{
                file.transferTo(dest);
                resVO.setSuccess(true);
                resVO.setMsg("上传成功");
            }catch (Exception e){

            }
        }

        System.out.println("---------->id:"+id);
        System.out.println("---------->name:"+name);

        return JSON.toJSONString(resVO);
    }

    /**
     * 生成新的文件名
     * @param fileName 客户端选定的文件名
     * @return 新的文件名 f_时间戳.原文件后缀名
     */
    public String createFileName(String fileName){
        //取后缀名
        String p_n=fileName.substring(fileName.indexOf("."));

        //构建新文件名 =pic_当前时间毫秒值.后缀
        String newName="f_"+System.currentTimeMillis()+p_n;

        //缺点文件名太长
        //String newName=UUID.randomUUID().toString().replace("-", "")+p_n;

        return newName;
    }

}
