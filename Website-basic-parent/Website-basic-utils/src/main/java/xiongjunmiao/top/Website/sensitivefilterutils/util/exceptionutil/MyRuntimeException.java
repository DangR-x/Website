package xiongjunmiao.top.Website.sensitivefilterutils.util.exceptionutil;

/**
 * Created by J on 2020/5/7 15:57
 */
public class MyRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 5439915454935047937L;

    public MyRuntimeException(String msg){
        super(msg);
    }

    public MyRuntimeException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
