package xiongjunmiao.top.Website.redisRepostory;

import org.springframework.data.redis.core.BoundValueOperations;

import java.util.List;

/**
 * Created by J on 2020/5/8 17:50
 */
public interface RedisRepostory {
    /**
     * @Title: save
     * @Description:
     * @param key
     * @param value
     * @param time
     * @return void
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:50:05
     */
    void save(Object key, Object value, int time);

    /**
     * @Title: getOperations
     * @Description:
     * @param key
     * @return org.springframework.data.redis.core.BoundValueOperations<java.lang.Object,java.lang.Object>
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:50:17
     */
    BoundValueOperations<Object, Object> getOperations(String key);

    /**
     * @Title: setIfAbsent
     * @Description:
     * @param key
     * @param value
     * @return boolean
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:50:36
     */
    boolean setIfAbsent(String key, String value);

    /**
     * @Title: save
     * @Description:
     * @param key
     * @param value
     * @return void
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:50:48
     */
    void save(Object key, Object value);

    /**
     * @Title: get
     * @Description:
     * @param key
     * @return java.lang.Object
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:51:07
     */
    Object get(Object key);

    boolean containsKey(String key);

    /**
     * @Title: delete
     * @Description:
     * @param key
     * @return void
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:51:31
     */
    void delete(Object key);

    /**
     * @Title: getAllKeys
     * @Description:
     * @param pattern
     * @return java.util.List<java.lang.String>
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:51:45
     */
    List<String> getAllKeys(String pattern);

    /**
     * @Title: deleteByPattern
     * @Description:
     * @param pattern
     * @return void
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:49:40
     */
    void deleteByPattern(String pattern);

    /**
     * @Title: getObjectList
     * @Description:
     * @param keyName
     * @return java.util.List<java.lang.Object>
     * @throws
     *
     * @author qiaohao
     * @date 2017/11/16 12:49:11
     */
    List<Object> getObjectList(String keyName);

    /**
     * @Title:
     * @Description:   设置过期时间
     * @param key time
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/02/27 03:52:42
     */
    void expire(Object key, int time);

}
