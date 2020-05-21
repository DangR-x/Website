package xiongjunmiao.top.Website.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


/**
 * websecurity权限认证配置类
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    //加密器
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(8);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                        //http.authorizeRequests() 方法中的自定义匹配
                .antMatchers("/","/login").permitAll()              // 指定所有用户进行访问指定的url
                //.antMatchers("/admin/**").hasRole("ADMIN")      //指定具有特定权限的用户才能访问特定目录，hasRole()方法指定用户权限，且不需前缀 “ROLE_“
                //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")
                .anyRequest().authenticated()       //任何请求没匹配的都需要进行验证
                .and()
                .headers().frameOptions().sameOrigin()//同意iframe加载同域名下页面
                .and()
                .formLogin().loginPage("/login").permitAll()      //指定自定义登录页面,允许所有用户访问登录页面
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/employee")
                .permitAll()
                .and()
                .logout()       //logouts 设置
                .logoutSuccessUrl("/login")         //指定成功注销后跳转到指定的页面
                .permitAll();
//            //request 设置
//            .authorizeRequests()   //http.authorizeRequests() 方法中的自定义匹配
//            //.antMatchers("/resources/**", "/signup", "/about").permitAll() // 指定所有用户进行访问指定的url
//            //.antMatchers("/admin/**").hasRole("ADMIN")  //指定具有特定权限的用户才能访问特定目录，hasRole()方法指定用户权限，且不需前缀 “ROLE_“
//            //.antMatchers("/db/**").access("hasRole('ADMIN') and hasRole('DBA')")//
//            .anyRequest().authenticated()  //任何请求没匹配的都需要进行验证
//            .and()        //login设置  自定义登录页面且允许所有用户登录
//            .formLogin()
//            .loginPage("/login") //The updated configuration specifies the location of the log in page  指定自定义登录页面
//            .permitAll(); // 允许所有用户访问登录页面. The formLogin().permitAll() 方法
//            .and
//            .logout()  //logouts 设置
//            .logoutUrl("/my/logout")  // 指定注销路径
//            .logoutSuccessUrl("/my/index") //指定成功注销后跳转到指定的页面
//            .logoutSuccessHandler(logoutSuccessHandler)  //指定成功注销后处理类 如果使用了logoutSuccessHandler()的话， logoutSuccessUrl()就会失效
//            .invalidateHttpSession(true)  // httpSession是否有效时间，如果使用了 SecurityContextLogoutHandler，其将被覆盖
//            .addLogoutHandler(logoutHandler)  //在最后增加默认的注销处理类LogoutHandler
//            .deleteCookies(cookieNamesToClear);//指定注销成功后remove cookies
//            //增加在FilterSecurityInterceptor前添加自定义的myFilterSecurityInterceptor
//            //http.addFilterBefore(myFilterSecurityInterceptor, FilterSecurityInterceptor.class);

    }


    protected WebSecurityConfig() {
        super();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        //忽略对这些路径的安全验证
        web.ignoring().mvcMatchers("/vendors/**", "/bs_pagination/**", "/build/**", "/Doors/**", "/production/**", "/src/js/**");
    }
}
