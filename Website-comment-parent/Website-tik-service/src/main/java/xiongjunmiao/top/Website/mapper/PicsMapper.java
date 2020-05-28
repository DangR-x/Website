package xiongjunmiao.top.Website.mapper;

import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.domain.Pics;

import java.util.List;

/**
 *
 */
@Component
public interface PicsMapper extends BaseMapper<Pics> {

    List<Pics> getPicsByGoodsId(Long goodsId);

}
