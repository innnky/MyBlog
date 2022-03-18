package xyz.innky.bootproj.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.innky.bootproj.pojo.Comment;

import java.util.List;

@Mapper
public interface CommentMapper {

    List<Comment> getCommentsByArticle(String aid);

    int insertComment(Comment comment);
}
