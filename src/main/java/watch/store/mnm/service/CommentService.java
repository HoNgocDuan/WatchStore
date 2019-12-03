package watch.store.mnm.service;

import watch.store.mnm.dto.CommentDTO;

import java.util.List;

public interface CommentService {
    List<CommentDTO> getAll();

    CommentDTO findById(int id);

    int deleteCommentById(int id);
}
