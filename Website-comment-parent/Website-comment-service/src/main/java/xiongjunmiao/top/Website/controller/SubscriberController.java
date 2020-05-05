package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xiongjunmiao.top.Website.service.impl.SubscriberServiceImpl;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 21:13
 * @Version v1.0
 */
@RestController
@RequestMapping("/subscriber")
public class SubscriberController {

    @Autowired
    private SubscriberServiceImpl subscriberService;



}
