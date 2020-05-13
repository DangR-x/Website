package xiongjunmiao.top.Website.repeat;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import xiongjunmiao.top.Website.repeat.util.Convert;
import xiongjunmiao.top.Website.repeat.util.JSON;
import xiongjunmiao.top.Website.repeat.util.ServletUtils;
import xiongjunmiao.top.Website.sensitivefilterutils.util.AjaxResult;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

/**
 *  防止重复提交拦截器
 */
//@Component
public abstract class RepeatSubmitInterceptor extends  HandlerInterceptorAdapter {

    //preHandle在业务处理器处理请求之前被调用。预处理，可以进行编码、安全控制等处理；
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            Method method = handlerMethod.getMethod();
            RepeatSubmit annotation = method.getAnnotation(RepeatSubmit.class);
            if(annotation!=null){
                if(this.isRepeatSubmit(request)){
                    AjaxResult ajaxResult = AjaxResult.me().setSuccess(false).setMessage("不能重复提交!");
                    ServletUtils.renderString(response, JSON.marshal(ajaxResult));
                    return false;
                }
            }
            return true;
        }else {
            return super.preHandle(request, response, handler);
        }
    }

    /**
     * 验证是否重复提交由子类实现具体的防重复提交的规则
     *
     * @param request
     * @return
     * @throws Exception
     */
    public abstract boolean isRepeatSubmit(HttpServletRequest request) throws Exception;

    //postHandle在业务处理器处理请求执行完成后，生成视图之前执行。后处理（调用了Service并返回ModelAndView，但未进行页面渲染），有机会修改ModelAndView;
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    //afterCompletion在DispatcherServlet完全处理完请求后被调用，可用于清理资源等。返回处理（已经渲染了页面），可以根据ex是否为null判断是否发生了异常，进行日志记录；
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }


}
