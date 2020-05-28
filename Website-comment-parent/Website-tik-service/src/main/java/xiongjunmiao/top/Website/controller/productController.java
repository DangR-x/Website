package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xiongjunmiao.top.Website.domain.Category;
import xiongjunmiao.top.Website.domain.Pics;
import xiongjunmiao.top.Website.dto.GoodsParam;
import xiongjunmiao.top.Website.jwtsecurity.utils.CommonResult;
import xiongjunmiao.top.Website.service.IPicsService;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping("/product")
public class productController {

    @Autowired
    private IPicsService picsService;

    @RequestMapping(value = "/pics/{goodsId}",method = RequestMethod.GET)
    public CommonResult getPicsByGoodsId(@PathVariable("goodsId") Long goodsId){
        List<Pics> pics = picsService.getPicsByGoodsId(goodsId);
        GoodsParam goodsParam = new GoodsParam();
        goodsParam.setPics(pics);
        goodsParam.setCategory(new Category());
        return CommonResult.success(goodsParam);
    }

}
