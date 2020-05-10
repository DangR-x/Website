package xiongjunmiao.top.Website.requestBodyAdvice;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
import xiongjunmiao.top.Website.domain.AppUser;

/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/5/10 18:50
 * @Version v1.0
 */
@Component
@RestControllerAdvice(annotations = RestController.class,basePackageClasses=RestExceptionHandler.class)
public class AsResponseBodyAdvice implements ResponseBodyAdvice<AppUser> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public AppUser beforeBodyWrite(AppUser appUser, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        return null;
    }
}
