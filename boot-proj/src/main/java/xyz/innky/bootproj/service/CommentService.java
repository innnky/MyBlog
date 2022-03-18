package xyz.innky.bootproj.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.innky.bootproj.dto.CommentDto;
import xyz.innky.bootproj.mapper.CommentMapper;
import xyz.innky.bootproj.pojo.Comment;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class CommentService {
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    CommentMapper commentMapper;

    public List<CommentDto> getCommentsByArticle(String aid) {
        List<Comment> commentsByArticle = commentMapper.getCommentsByArticle(aid);
        Map<Integer, CommentDto> map = new HashMap<>();
        List<CommentDto> res = new ArrayList<>();
        for (Comment comment : commentsByArticle) {
            CommentDto e = new CommentDto();
            e.setArticleId(comment.getArticleId());
            e.setContent(comment.getContent());
            e.setEmail(comment.getEmail());
            e.setId(comment.getId());
            e.setPublishedTime(dateFormat.format(new Date(comment.getPublishedTime())));
            map.put(e.getId(), e);
            if (comment.getParentId() == null){
                res.add(e);
            }else {
                map.get(comment.getParentId()).addChild(e);
            }
        }
        return res;
    }


    public Integer insertComment(Integer parentId, Integer articleId, String content, String email) {
        Comment comment = new Comment();
        comment.setParentId(parentId);
        comment.setContent(content);
        comment.setArticleId(articleId);
        comment.setEmail(email);
        comment.setPublishedTime(System.currentTimeMillis());
        if(commentMapper.insertComment(comment) == 1){
            return 1;
        }else {
            return -1;
        }
    }
}
