package xiongjunmiao.top.Website.webtokenFilter.request;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.domain.AppUser;
import xiongjunmiao.top.Website.domain.BaseUser;
import xiongjunmiao.top.Website.sensitivefilterutils.util.StringUtils;
import xiongjunmiao.top.Website.webtokenFilter.WebTokenProperties;
import xiongjunmiao.top.Website.service.IAppUserService;

import javax.servlet.http.HttpServletRequest;
import java.net.URLDecoder;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/11 0:15
 * @Version v1.0
 * @Description: 对当前登录用户进行操作
 */
@Slf4j
@Component
public class UserInfoUtils {

    private static UserInfoUtils userInfoUtils = null;

    private static IAppUserService userService = null;


    public static Object getUser(Class entityClass) {
        String userInfoStr = getUserStr();
        //如果是空返回true
        if (StringUtils.isTrimBlank(userInfoStr)) {
            return null;
        }
        try {
            //URLDecoder.decode() 对url进行解码，注意其主要原因是% 在URL中是特殊字符，需要特殊转义一下url = url.replaceAll("%(?![0-9a-fA-F]{2})", "%");
            userInfoStr = URLDecoder.decode(userInfoStr, "utf-8");
            //将json字符串转为javabean对象 配合JSON.parseObject不会将首字母转为小写
            Object userInfo = JSON.toJavaObject(JSON.parseObject(userInfoStr), entityClass);
            return userInfo;
        } catch (Exception ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    public static String getUserStr() {
        HttpServletRequest request = RequestUtils.getRequest();
        if (request != null) {
            //WebTokenProperties.loginUserHeader()取到的是配置文件中的 web.login.user.hander:access-user
            //request.getAttribute() 取出请求里面对应的value
            //StringUtils.getValue() 将object类型转为string类型
            String loginUser = StringUtils.getValue(request.getAttribute(WebTokenProperties.loginUserHeader()));
            return loginUser;
        }
        return null;
    }

    public static String getChainHeader() {
        HttpServletRequest request = RequestUtils.getRequest();
        if (request != null) {
            String chainHeader = request.getHeader(WebTokenProperties.chainHeader());
            return chainHeader;
        }
        return null;
    }

    public static BaseUser getUser() {
        BaseUser user = (BaseUser) userInfoUtils.getUser(BaseUser.class);
        return user;
    }

    public static String getChain() {
        return userInfoUtils.getChainHeader();
    }

    /**
     * 检查token中登录的用户是否一致
     * @param token
     * @return
     */
    public static AppUser checkToken(String token) {
        return userService.checkToken(token);
    }

    public static String getUserName() {
        BaseUser user = getUser();
        if (user == null) {
            return null;
        }
        return user.getUserName();
    }

    public static String getUserId() {
        BaseUser user = getUser();
        if (user == null) {
            return null;
        }
        return user.getUserId();
    }

    public static void setUserInfoUtils(UserInfoUtils userInfoUtils) {
        UserInfoUtils.userInfoUtils = userInfoUtils;
    }

    public static void setUserService(IAppUserService userService) {
        UserInfoUtils.userService = userService;
    }

    public static UserInfoUtils getUserInfoUtils() {
        return userInfoUtils;
    }

}
