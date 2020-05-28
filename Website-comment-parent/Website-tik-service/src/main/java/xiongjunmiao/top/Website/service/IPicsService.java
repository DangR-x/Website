package xiongjunmiao.top.Website.service;

import xiongjunmiao.top.Website.domain.Pics;

import java.util.List;

/**
 *
 */
public interface IPicsService extends BaseService<Pics> {

    List<Pics> getPicsByGoodsId(Long goodsId);


}
