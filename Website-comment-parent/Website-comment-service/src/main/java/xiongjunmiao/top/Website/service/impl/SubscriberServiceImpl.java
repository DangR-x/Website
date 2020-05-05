package xiongjunmiao.top.Website.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xiongjunmiao.top.Website.Mapper.BaseMapper;
import xiongjunmiao.top.Website.domain.Subscriber;
import xiongjunmiao.top.Website.mapper.SubscriberMapper;
import xiongjunmiao.top.Website.service.IBaseService;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 20:43
 * @Version v1.0
 */
@Service
public class SubscriberServiceImpl extends BaseServiceImpl<Subscriber> implements IBaseService<Subscriber> {

    @Autowired
    private SubscriberMapper subscriberMapper;

    @Override
    protected BaseMapper<Subscriber> getBaseMapper() {
        return subscriberMapper;
    }
}
