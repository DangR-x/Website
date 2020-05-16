package xiongjunmiao.top.Website.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import xiongjunmiao.top.Website.domain.Comment;
import xiongjunmiao.top.Website.service.impl.CommentServiceImpl;

import javax.validation.Valid;
import java.util.List;


/**
 * @Description TODO
 * @Author DangR-X
 * @Date 2020/4/15 16:42
 * @Version v1.0
 */
@RestController
@RequestMapping("/comment")
public class CommentController {
    private static final Logger LOG = LoggerFactory.getLogger(CommentController.class);
    @Autowired
    private CommentServiceImpl commentService;
    /**
     *
     * @param bindingresult 对参数验证
     * @param comment
     * @return
     */
    @RequestMapping(value = "/find",method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Comment> getOne(@Valid @RequestBody Comment comment,BindingResult bindingresult){
        LOG.info("test start");
        if(bindingresult.hasErrors()){
            List<FieldError> fieldErrors = bindingresult.getFieldErrors();
            fieldErrors.forEach(fieldError -> {
                //日志打印不符合校验的字段名和错误提示
                LOG.error("error field is : {} ,message is : {}", fieldError.getField(), fieldError.getDefaultMessage());
            });
            for(int i=0;i<fieldErrors.size();i++){
                //控制台打印不符合校验的字段名和错误提示
                System.out.println("error field is :"+fieldErrors.get(i).getField()+",message is :"+fieldErrors.get(i).getDefaultMessage());
            }
            // pesponsibles.setError_msg(fieldErrors);
            return new ResponseEntity<>(comment, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(comment, HttpStatus.OK);
    }



    @GetMapping("/index")
    public ModelAndView index(ModelAndView mav){
        mav.setViewName("/employee");
        return mav;
    }

}
