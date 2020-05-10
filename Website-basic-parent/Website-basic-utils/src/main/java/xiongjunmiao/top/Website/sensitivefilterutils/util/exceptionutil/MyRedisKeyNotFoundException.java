package xiongjunmiao.top.Website.sensitivefilterutils.util.exceptionutil;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 21:57
 * @Version v1.0
 */
public class MyRedisKeyNotFoundException extends MyRuntimeException {

    private String redisKey;

    public MyRedisKeyNotFoundException(String msg) {
        super(msg);
    }

    public MyRedisKeyNotFoundException(String msg, String rediskey) {
        super(msg);
        this.redisKey = redisKey;
    }

    public String getRedisKey() {
        return redisKey;
    }
}