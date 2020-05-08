package xiongjunmiao.top.Website.redisService;

/**
 * @author qiaomengnan
 * @ClassName: RedisService
 * @Description:
 * @date 2018/2/25
 */
public interface RedisService {

    /**
     * @Title:
     * @Description:   保存值进入redis
     * @param key
     * @param value
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:39:03
     */
    void save(Object key, Object value);


    /**
     * @Title:
     * @Description:   值存入redis同时限制时间
     * @param key
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:52:24
     */
    void save(Object key, Object value, int time);

    /**
     * @Title:
     * @Description:   通过key获取redis值
     * @param key
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/02/25 02:54:05
     */
    Object get(Object key);

    /**
     * @Title:
     * @Description: 删除某个值
     * @param key
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2019/01/14 03:41:13
     */
    void delete(Object key);

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
