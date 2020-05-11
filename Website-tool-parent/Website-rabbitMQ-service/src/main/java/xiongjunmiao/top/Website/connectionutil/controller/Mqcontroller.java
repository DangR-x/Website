package xiongjunmiao.top.Website.connectionutil.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.connectionutil.producer.Mqproducer;

/**
 * Created by J on 2020/5/11 17:24
 */
@RestController
@RequestMapping("/mq")
public class Mqcontroller {

    @Autowired
    private Mqproducer mqproducer;

    @RequestMapping(value = "/{admin}",method = RequestMethod.GET)
    public void test(@PathVariable("admin")String a){
        mqproducer.setMessge(a);
    }


}
