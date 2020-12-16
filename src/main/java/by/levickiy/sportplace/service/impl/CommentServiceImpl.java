package by.levickiy.sportplace.service.impl;

import by.levickiy.sportplace.aspect.Loggable;
import by.levickiy.sportplace.config.Mapper;
import by.levickiy.sportplace.dto.CommentDto;
import by.levickiy.sportplace.entity.Comment;
import by.levickiy.sportplace.entity.File;
import by.levickiy.sportplace.repository.CommentRepository;
import by.levickiy.sportplace.repository.FileRepository;
import by.levickiy.sportplace.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Value("${upload.path}")
    private String path;

    private final CommentRepository commentRepository;
    private final FileRepository fileRepository;
    private final UserServiceImpl userService;
    private final EventServiceImpl eventService;


    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository,
                              FileRepository fileRepository,
                              UserServiceImpl userService,
                              EventServiceImpl eventService) {
        this.commentRepository = commentRepository;
        this.fileRepository = fileRepository;
        this.userService = userService;
        this.eventService = eventService;
    }

    @Override
    @Loggable
    public Collection<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    @Loggable
    public Optional<Collection<Comment>> getAllCommentsByEventId(Long id) {
        return commentRepository
                .getCommentByEventId(id);
    }

    @Override
    @Loggable
    public void addComment(CommentDto commentDto,
                           Collection<MultipartFile> files,
                           HttpServletRequest req) throws Exception {
        commentDto.setFilename(new HashSet<>());

        for (var file : files) {
            if (file.getOriginalFilename()
                    .equals("")) continue;

            if (!file.getOriginalFilename()
                    .matches("^(?:.*\\.(?=(jpg|jpeg|png|bmp)$))?[^.]*$") && !file.
                    getOriginalFilename()
                    .equals("")) {
            }

            java.io.File fileDir = new java.io.File(path);

            if (!fileDir.exists()) {
                fileDir.mkdir();
            }

            String UUID = java.util.UUID.randomUUID().toString();
            String finalPath = UUID + "." + file.getOriginalFilename();
            file.transferTo(new java.io.File(path + "/" + finalPath));

            File commentImg = new File();

            commentImg.setComment(new Comment());
            commentImg.setFilename(finalPath);
            commentDto.getFilename().add(commentImg);
        }

        Comment comment = Mapper.map(commentDto, Comment.class);
        comment.setFile(new HashSet<>());

        for (var x : commentDto.getFilename()) {
            comment.getFile().add(x);
            x.setComment(comment);
        }

        comment.setEvent(eventService
                .getEventById(commentDto
                        .getEventId()));
        comment.setUser(userService
                .getUserByUsername("Arseni123456"));



        commentRepository.save(comment);
    }

    @Override
    public void deleteCommentsByEventId(Long eventId) {
        commentRepository.deleteCommentsByEventId(eventId);
    }
}
