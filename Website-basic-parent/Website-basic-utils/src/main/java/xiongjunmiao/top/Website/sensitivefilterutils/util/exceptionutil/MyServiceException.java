package xiongjunmiao.top.Website.sensitivefilterutils.util.exceptionutil;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 18:57
 * @Version v1.0
 */
public class MyServiceException extends MyRuntimeException {

    private static final long serialVersionUID = 5439915454935047937L;

    public MyServiceException(String msg){
        super(msg);
    }

    public MyServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
