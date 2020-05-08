package xiongjunmiao.top.Website.uitl.sensitivefilterutils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * Created by J on 2020/5/7 16:50
 */
public class AsRequest extends HttpServletRequestWrapper {


    public AsRequest(HttpServletRequest request) {
        super(request);
    }
}