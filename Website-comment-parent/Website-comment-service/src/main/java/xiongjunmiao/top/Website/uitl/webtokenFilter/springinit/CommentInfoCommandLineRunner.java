package xiongjunmiao.top.Website.uitl.webtokenFilter.springinit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import xiongjunmiao.top.Website.service.impl.CommentServiceImpl;
import xiongjunmiao.top.Website.uitl.webtokenFilter.request.UserInfoUtils;
import xiongjunmiao.top.Website.uitl.webtokenFilter.service.UserService;

/**
 * Order  spring在初始化时此类的顺序
 */
@Order(103)
@Component
public class CommentInfoCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserInfoUtils userInfoUtils;

    @Autowired
    private UserService userService;

    /**
     *
     * @param strings
     * @throws Exception
     * 初始化时将需要的service注入进去
     */
    @Override
    public void run(String... strings) throws Exception {
        //在此注入共通类是因为要保证日志的正常输出
        UserInfoUtils.setUserInfoUtils(userInfoUtils);
        UserInfoUtils.setUserService(userService);
    }
}
