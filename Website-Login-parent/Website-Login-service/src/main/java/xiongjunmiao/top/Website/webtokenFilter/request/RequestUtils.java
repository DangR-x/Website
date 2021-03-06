package xiongjunmiao.top.Website.webtokenFilter.request;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/11 0:15
 * @Version v1.0
 */
public class RequestUtils {

    public static HttpServletRequest getRequest(){
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if(requestAttributes != null){
            return ((ServletRequestAttributes)requestAttributes).getRequest();
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取访问的路由url
     * @return
     * @throws
     * @Author DangR-X
     * @Date 2020/5/11 0:15
     */
    public static String getRequestUri(){
        HttpServletRequest request = getRequest();
        if(request != null)
            return request.getRequestURI();
        return null;
    }

    /**
     * @Title:
     * @Description:   获取访问的完整url
     * @return
     * @throws
     * @Author DangR-X
     * @Date 2020/5/11 0:15
     */
    public static String getRequestUrl(){
        HttpServletRequest request = getRequest();
        if(request != null)
            return request.getRequestURL().toString();
        return null;
    }

}
