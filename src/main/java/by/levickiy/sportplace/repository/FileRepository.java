package by.levickiy.sportplace.repository;

import by.levickiy.sportplace.entity.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
    void deleteFilesByCommentId(Long id);
}
