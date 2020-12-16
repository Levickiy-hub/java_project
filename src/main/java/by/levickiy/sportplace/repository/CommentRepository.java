package by.levickiy.sportplace.repository;

import by.levickiy.sportplace.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Optional<Collection<Comment>> getCommentByEventId(Long eventId);
    Optional<Collection<Comment>> getCommentsByEventId(Long eventId);
    void deleteCommentsByEventId(Long eventId);
}
