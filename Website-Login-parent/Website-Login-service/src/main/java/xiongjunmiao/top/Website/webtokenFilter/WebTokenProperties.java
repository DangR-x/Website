package xiongjunmiao.top.Website.webtokenFilter;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import xiongjunmiao.top.Website.sensitivefilterutils.util.StringUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 从配置文件获取
 */
@Data
@Component
public class WebTokenProperties {

    private static WebTokenProperties webProperties = null;

    public static final String AUTHORIZATION = "Authorization";

    public static final String BEARER = "Bearer";

    public WebTokenProperties(){
        webProperties = this;
    }

    @Value("${web.login.user.header}")
    private String loginUserHeader;

    @Value("${web.chain.header}")
    private String chainHeader;

    @Value("${server.servlet.context-path}")
    private String contentPath;

    @Value("${web.token.header}")
    private String tokenHeader;

    @Value("${web.notAuthUrl}")
    private String notAuthUrl;

    @Value("${hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds}")
    private Integer hystrixTimeOut;

    @Value("${web.notLogUrl}")
    private String notLogUrl;

    @Value("${web.notTokenTimeUrl}")
    private String notTokenTimeUrl;

    private String [] notAuthUrls;

    private String [] notLogUrls;

    private String [] notTokenTimeUrls;

    public String[] getNotAuthUrls(){
        if( (notAuthUrls == null || notAuthUrls.length == 0)
                && StringUtils.isNotTrimBlank(notAuthUrl)){
            notAuthUrls = notAuthUrl.split(",");
        }
        return notAuthUrls;
    }

    public String[] getNotLogUrls(){
        if( (notLogUrls == null || notLogUrls.length == 0)
                && StringUtils.isNotTrimBlank(notLogUrl)){
            notLogUrls = notLogUrl.split(",");
        }
        return notLogUrls;
    }

    public String[] getNotTokenTimeUrls(){
        if( (notTokenTimeUrls == null || notTokenTimeUrls.length == 0)
                && StringUtils.isNotTrimBlank(notTokenTimeUrl)){
            notTokenTimeUrls = notTokenTimeUrl.split(",");
        }
        return notTokenTimeUrls;
    }

    public static boolean isAuthorization(String requestUrl){
        if(StringUtils.isNotTrimBlank(requestUrl)) {
            String requestUrlTmp = requestUrl.split("\\?")[0];
            if (!requestUrlTmp.startsWith(requestUrlTmp)) {
                requestUrlTmp = "/" + requestUrlTmp;
            }
            return UrlMatchingUtils.matching(requestUrlTmp, webProperties.getNotAuthUrls());
        }
        return true;
    }

    public static boolean isLog(String requestUrl){
        if(StringUtils.isNotTrimBlank(requestUrl)) {
            String requestUrlTmp = requestUrl.split("\\?")[0];
            if (!requestUrlTmp.startsWith(requestUrlTmp)) {
                requestUrlTmp = "/" + requestUrlTmp;
            }
            return UrlMatchingUtils.matching(requestUrlTmp, webProperties.getNotLogUrls());
        }
        return true;
    }

    public static boolean isTokenTime(String requestUrl){
        if(StringUtils.isNotTrimBlank(requestUrl)) {
            String requestUrlTmp = requestUrl.split("\\?")[0];
            if (!requestUrlTmp.startsWith(requestUrlTmp)) {
                requestUrlTmp = "/" + requestUrlTmp;
            }
            return UrlMatchingUtils.matching(requestUrlTmp, webProperties.getNotTokenTimeUrls());
        }
        return true;
    }

    public static String getBearerValue(String value){
        return BEARER + " " + value;
    }

    public static String getLoginUserCookieValue(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        for (Cookie cookie : request.getCookies()) {
            if (webProperties.getLoginUserHeader().equals(cookie.getName())) {
                return cookie.getValue();
            }
        }
        return null;
    }

    public static String getLoginUserBearerCookieValue(){
        return getBearerValue(getLoginUserCookieValue());
    }

    public static String loginUserHeader(){
        return webProperties.getLoginUserHeader();
    }

    public static String chainHeader(){
        return webProperties.getChainHeader();
    }

}
