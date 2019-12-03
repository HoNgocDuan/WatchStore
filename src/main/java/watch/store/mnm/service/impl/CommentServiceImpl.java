package watch.store.mnm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import watch.store.mnm.domain.Comment;
import watch.store.mnm.dto.CommentDTO;
import watch.store.mnm.repository.CommnetRepository;
import watch.store.mnm.service.CommentService;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommnetRepository commnetRepository;

    @Override
    public List<CommentDTO> getAll() {
        List<CommentDTO> listComment = new ArrayList<>();
        List<Comment> all = commnetRepository.findAll();
        for (Comment comment: all) {
            CommentDTO commentDTO = new CommentDTO();
            commentDTO.setId(comment.getId());
            commentDTO.setContent(comment.getContent());
            commentDTO.setCreateDate(comment.getCreateDate());
            commentDTO.setStatus(comment.getStatus());
            listComment.add(commentDTO);
        }
        return listComment;
    }

    @Override
    public CommentDTO findById(int id) {
        CommentDTO commentDTO = new CommentDTO();
        Comment comment = commnetRepository.findById(id);
        commentDTO.setId(comment.getId());
        commentDTO.setContent(comment.getContent());
        commentDTO.setCreateDate(comment.getCreateDate());
        commentDTO.setStatus(comment.getStatus());
        return commentDTO;
    }

    @Override
    public int deleteCommentById(int id) {
        try {
            commnetRepository.deleteById(id);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
