package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xiongjunmiao.top.Website.service.IFileService;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * Created by J on 2020/5/19 15:08
 */
@RestController
@RequestMapping("/file")
public class FileUpload {

    @Autowired
    private IFileService fileService;

    private String path="E:/xiong/imagex/";

    @RequestMapping(value = "/pic",method = RequestMethod.POST)
    public void fileUpload(@RequestBody MultipartFile file, HttpServletRequest request, HttpServletResponse response){
        String name = file.getOriginalFilename();
        File filepath = new File( path + name);
        if(!filepath.exists()){
            filepath.mkdir();
        }
        try {
           file.transferTo(filepath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String Test(HttpServletRequest request){
        return "";
    }


}
