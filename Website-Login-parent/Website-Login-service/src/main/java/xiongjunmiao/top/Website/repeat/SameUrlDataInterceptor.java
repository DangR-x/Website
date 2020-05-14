package xiongjunmiao.top.Website.repeat;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 *  实现对那些请求的拦截逻辑
 *  判断请求url和数据是否和上一次相同，
 *  如果和上次相同，则是重复提交表单。 有效时间为10秒内。
 */
@Component
public class SameUrlDataInterceptor extends RepeatSubmitInterceptor {

    private final String  REPEAT_PARAMS  = "repeatParams";
    private final String  REPEAT_TIME = "repeatTime";
    private final String  SESSION_REPEAT_KEY = "repeatData";
    /**
     * 间隔时间，单位:秒 默认10秒
     *
     * 两次相同参数的请求，如果间隔时间大于该参数，系统不会认定为重复提交的数据
     */
    private int intervalTime = 10;

    public void setIntervalTime(int intervalTime){this.intervalTime=intervalTime;}

    //@SuppressWarnings("unchecked")忽略警告
    @SuppressWarnings("unchecked")
    @Override
    public boolean isRepeatSubmit(HttpServletRequest request) throws Exception {
        // 本次参数及系统时间
        Map<String, String[]> nowParams = request.getParameterMap();
        Map<String, Object> nowDataMap = new HashMap<>();
        nowDataMap.put(REPEAT_PARAMS,nowParams);
        nowDataMap.put(REPEAT_TIME,System.currentTimeMillis());

        // 请求地址（作为存放session的key值）
        String url = request.getRequestURI();
        HttpSession session = request.getSession();
        Object sessionObj = session.getAttribute(SESSION_REPEAT_KEY);
        if(sessionObj!=null){
            Map<String, Object> sessionMap = (Map<String, Object>) sessionObj;
            if(sessionMap.containsKey(url)){
                Map<String, Object> preDataMap = (Map<String, Object>) sessionMap.get(url);
                if(compareParams(nowDataMap,preDataMap)&&compareTime(nowDataMap,preDataMap)){

                    return true;
                }
            }
        }

        Map<String, Object> sessionMap = new HashMap<String, Object>();
        sessionMap.put(url, nowDataMap);
        session.setAttribute(SESSION_REPEAT_KEY, sessionMap);
        return false;
    }
    /**
     * 判断参数是否相同
     */
    private boolean compareParams(Map<String,Object> newMap,Map<String,Object> preMap){
        Object o = newMap.get(REPEAT_PARAMS);
        Object o1 = preMap.get(REPEAT_PARAMS);
        return o.equals(o1);
    }
    /**
     * 判断两次间隔时间
     */
    private boolean compareTime(Map<String,Object> newMap,Map<String,Object> preMap){
        Long newTime = (Long) newMap.get(REPEAT_TIME);
        Long preTime = (Long) preMap.get(REPEAT_TIME);
        if((newTime-preTime)<(this.intervalTime * 1000)){
            return true;
        }
        return false;
    }
}
