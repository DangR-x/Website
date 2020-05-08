package xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.exceptionutil;

/**
 * Created by J on 2020/5/7 15:57
 */
public class MyException extends RuntimeException {

    private static final long serialVersionUID = 5439915454935047937L;

    public MyException(String msg){
        super(msg);
    }

    public MyException(String msg, Throwable cause) {
        super(msg, cause);
    }

}
