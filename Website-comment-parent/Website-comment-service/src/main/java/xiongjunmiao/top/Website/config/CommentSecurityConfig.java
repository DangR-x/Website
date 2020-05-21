package xiongjunmiao.top.Website.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import xiongjunmiao.top.Website.component.DynamicSecurityService;
import xiongjunmiao.top.Website.securityconfig.SecurityConfig;
import xiongjunmiao.top.Website.service.IAdminService;
import xiongjunmiao.top.Website.service.IUserService;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * security模块
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class CommentSecurityConfig extends SecurityConfig {

        @Autowired
        private IUserService adminService;
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
//                    map.put(resource.getUrl(), new org.springframework.security.access.SecurityConfig(resource.getId() + ":" + resource.getName()));
//                }
                    return map;
                }
            };
        }
}


