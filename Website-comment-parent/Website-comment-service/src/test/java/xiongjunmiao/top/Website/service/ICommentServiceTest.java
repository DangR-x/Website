package xiongjunmiao.top.Website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.controller.CommentController;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.mapper.CommentMapper;
import xiongjunmiao.top.Website.service.impl.CommentServiceImpl;
import xiongjunmiao.top.Website.service.impl.FileServiceImpl;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Properties;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ICommentServiceTest {
    private final Logger logger=  LoggerFactory.getLogger(CommentController.class);

    @Autowired
    private CommentServiceImpl commentServic;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private FileServiceImpl fileService;

    @Autowired
    private HttpServletRequest request;

    @Test
    public void test01(){

        try {
            Properties properties = new Properties();
            properties.setProperty("name","haha");
            properties.setProperty("age","12");
            properties.setProperty("sex","1");
            //E:\xiong\xiongjunmiao\Website\Website-comment-parent\Website-comment-service\src\main\resources\WEB-INF\images
            //E:\xiong\xiongjunmiao\Website\Website-comment-parent\Website-comment-service\target
            String images = request.getServletContext().getRealPath("");
            System.out.println(images);
            File file = new File(images+"/test.propertie");
            OutputStream fileOutputStream = new FileOutputStream(file);
            properties.store(fileOutputStream,"xiongjunmiao");
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test02(){
        List<User> users = userService.selectAll();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void test03(){

    }


}