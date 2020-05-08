package xiongjunmiao.top.Website.uitl.webtokenFilter;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import xiongjunmiao.top.Website.uitl.sensitivefilterutils.util.StringUtils;
import xiongjunmiao.top.Website.uitl.webtokenFilter.encryptionutils.AESCipher;
import xiongjunmiao.top.Website.uitl.webtokenFilter.request.UserInfoUtils;
import xiongjunmiao.top.Website.uitl.webtokenFilter.response.ResponseEnums;
import xiongjunmiao.top.Website.uitl.webtokenFilter.response.RestResponse;
import xiongjunmiao.top.Website.uitl.webtokenFilter.response.RestResponseGenerator;
import xiongjunmiao.top.Website.uitl.webtokenFilter.userdomain.AppUser;

import javax.crypto.Cipher;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by J on 2020/5/8 9:54
 */
@Slf4j
public class WebTokenFilter implements Filter {

    @Autowired
    private WebTokenProperties webProperties;

    private String[] prefixIgnores;

    private String contextPath;

    @Value("${web.encrypt.enabled}")
    private boolean encryptEnabled;

    public void resource(String ...params){
        prefixIgnores = params;
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //将被过滤的资源  不用鉴权
        resource(webProperties.getNotAuthUrls());
        contextPath = webProperties.getContentPath();
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        //从路径中去掉不需要的路径
        String requestUri = request.getRequestURI().replace(contextPath, "");
        // 判断requestUri与prefixIgnores相等或者与prefixIgnores开头的返回false
        boolean ignores = UrlMatchingUtils.matching(requestUri, prefixIgnores);
        try {
            if(!ignores){
                // 不需要校验,放行
                filterChain.doFilter(servletRequest, servletResponse);
                return;
            }
            // 需要校验
            String token = request.getHeader(webProperties.getTokenHeader());
            if (StringUtils.isTrimBlank(token)) {
                genFailResult(response);
                return;
            }

            // token验证成功得到用户信息
            AppUser user = UserInfoUtils.checkToken(token);
            if (user == null) {
                genFailResult(response);
                return;
            }

            // 将用户信息存储到request,放行
            request.setAttribute(webProperties.getLoginUserHeader(), JSON.toJSONString(user));
            filterChain.doFilter(servletRequest, servletResponse);

        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            genFailResult(response);
        }



    }
    /**
     *  2019-09-03 add -> fei
     *  鉴权失败返回401
     * @param response {@link HttpServletResponse}
     */
    private void genFailResult(HttpServletResponse response) {
        //鉴权失败返回401
        // response.setStatus(HttpStatus.UNAUTHORIZED.value());
        responseResult(response, RestResponseGenerator.genFailResponse(ResponseEnums.UNAUTHORIZED));
    }
    /**
     *   2019-09-03 add -> fei
     *   result json data
     * @param response {@link HttpServletResponse}
     * @param result {@link RestResponse}
     */
    private void responseResult(HttpServletResponse response, RestResponse result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        String resultJson = JSON.toJSONString(result);
        try {
            if (encryptEnabled) {
                resultJson = AESCipher.encrypt(resultJson);
            }
            response.getWriter().write(resultJson);
        } catch (IOException ex) {
            log.error("返回错误消息失败:",ex.getMessage());
        }
    }

    @Override
    public void destroy() {

    }
}
