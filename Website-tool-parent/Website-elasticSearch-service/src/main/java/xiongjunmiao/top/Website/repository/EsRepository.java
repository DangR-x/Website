package xiongjunmiao.top.Website.repository;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;
import xiongjunmiao.top.Website.domain.EsProduct;

/**
 * ElasticSearch集成Repository出现错误,未解决
 * extends ElasticsearchRepository<EsProduct, Long>
 */
public interface EsRepository  {
}
