package xiongjunmiao.top.Website.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import xiongjunmiao.top.Website.controller.CommentController;
import xiongjunmiao.top.Website.domain.Comment;
import xiongjunmiao.top.Website.domain.User;
import xiongjunmiao.top.Website.mapper.CommentMapper;
import xiongjunmiao.top.Website.service.impl.CommentServiceImpl;

import java.util.List;


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

    @Test
    public void test01(){
        Comment comment = commentMapper.selectById(1L);
        logger.trace(comment.toString());
        logger.debug(comment.toString());
        logger.info(comment.toString());
        logger.warn(comment.toString());
        logger.error(comment.toString());
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