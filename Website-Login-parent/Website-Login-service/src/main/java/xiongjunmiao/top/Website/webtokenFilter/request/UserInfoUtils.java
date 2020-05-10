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
 * @author qiaomengnan
 * @ClassName: UserInfoUtil
 * @Description: 对当前登录用户进行操作
 * @date 2018/1/7
 */
@Slf4j
@Component
public class UserInfoUtils {

    private static UserInfoUtils userInfoUtils = null;

    private static IAppUserService userService = null;


    public static Object getUser(Class entityClass) {
        String userInfoStr = getUserStr();
        if (StringUtils.isTrimBlank(userInfoStr)) {
            return null;
        }
        try {
            userInfoStr = URLDecoder.decode(userInfoStr, "utf-8");
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
