package xiongjunmiao.top.Website.mapper;

import org.apache.ibatis.annotations.Param;
import xiongjunmiao.top.Website.domain.EsProduct;
import xiongjunmiao.top.Website.domain.Product;

import java.util.List;

/**
 * Created by J on 2020/5/12 14:53
 */
public interface EsProductMapper {
    List<EsProduct> getAllEsProductList(@Param("id") Long id);
}
