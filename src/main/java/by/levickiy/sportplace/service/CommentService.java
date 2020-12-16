package by.levickiy.sportplace.service;

import by.levickiy.sportplace.dto.CommentDto;
import by.levickiy.sportplace.entity.Comment;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Optional;

public interface CommentService {
    Collection<Comment> getAllComments();
    Optional<Collection<Comment>> getAllCommentsByEventId(Long id);
    void addComment(CommentDto commentDto,
                    Collection<MultipartFile> files,
                    HttpServletRequest req) throws Exception;

    void deleteCommentsByEventId(Long eventId);
}
