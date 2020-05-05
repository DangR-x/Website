package xiongjunmiao.top.Website.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import xiongjunmiao.top.Website.domain.Comment;
import xiongjunmiao.top.Website.service.impl.CommentServiceImpl;

import javax.validation.Valid;


/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 16:42
 * @Version v1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentServiceImpl commentService;

    @GetMapping("/{id}")
    public Comment getOne(BindingResult commentbindingresult, @PathVariable("id")Long id){
        Comment comment = commentService.getById(id);
        return comment;
    }



    @GetMapping("/index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("/employee");
        return mav;
    }


}
