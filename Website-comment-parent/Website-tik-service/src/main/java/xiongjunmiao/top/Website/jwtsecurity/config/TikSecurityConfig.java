package xiongjunmiao.top.Website.jwtsecurity.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.userdetails.UserDetailsService;
import xiongjunmiao.top.Website.jwtsecurity.component.DynamicSecurityService;
import xiongjunmiao.top.Website.service.IAdminService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * mall-security模块相关配置
 *
 */
//@Configuration
//@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class TikSecurityConfig extends SecurityConfig {

    @Autowired
    private IAdminService adminService;
//    @Autowired
//    private UmsResourceService resourceService;

    @Bean
    public UserDetailsService userDetailsService() {
        //获取登录用户信息
        return username -> adminService.loadUserByUsername(username);

    }

    @Bean
    public DynamicSecurityService dynamicSecurityService() {
        return new DynamicSecurityService() {
            @Override
            public Map<String, ConfigAttribute> loadDataSource() {
                //将所有需要验证的路径注入进容器内
                Map<String, ConfigAttribute> map = new ConcurrentHashMap<>();
//                List<UmsResource> resourceList = resourceService.listAll();
//                for (UmsResource resource : resourceList) {
//                    //将需要验证的所有资源,以路径为键,id和名称为值存入map中在注入进security容器中
//                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
//                }
                return map;
            }
        };
    }
}
