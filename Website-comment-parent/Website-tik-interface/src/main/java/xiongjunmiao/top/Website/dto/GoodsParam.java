package xiongjunmiao.top.Website.dto;

import lombok.Data;
import xiongjunmiao.top.Website.domain.Category;
import xiongjunmiao.top.Website.domain.Pics;

import java.util.List;

/**
 *
 */
@Data
public class GoodsParam {

    private List<Pics> pics;
    private Category category;

}
