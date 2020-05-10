package xiongjunmiao.top.Website.webtokenFilter.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import xiongjunmiao.top.Website.webtokenFilter.annotation.AuthUserInfo;
import xiongjunmiao.top.Website.webtokenFilter.request.UserInfoUtils;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/11 0:15
 * @Version v1.0
 */
public class MyLoginUserArgumentResolver implements HandlerMethodArgumentResolver {

    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.hasParameterAnnotation(AuthUserInfo.class);
    }

    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer, NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        return UserInfoUtils.getUser(methodParameter.getParameterType());
    }

}
