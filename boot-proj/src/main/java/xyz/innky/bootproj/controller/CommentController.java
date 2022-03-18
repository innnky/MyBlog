package xyz.innky.bootproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import xyz.innky.bootproj.dto.CommentDto;
import xyz.innky.bootproj.pojo.Comment;
import xyz.innky.bootproj.service.CommentService;

import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin()
public class CommentController {

    @Autowired
    CommentService commentService;

    @GetMapping("/article/{aid}")
    public List<CommentDto> getCommentsByArticle(@PathVariable("aid") String aid){
        return commentService.getCommentsByArticle(aid);
    }

    @PostMapping("/")
    public Integer insertComment(Integer parentId, Integer articleId,String content, String  email ){
        return commentService.insertComment(parentId, articleId, content, email);
    }
}
