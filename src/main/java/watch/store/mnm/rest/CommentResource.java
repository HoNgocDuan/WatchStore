package watch.store.mnm.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import watch.store.mnm.dto.CatalogDTO;
import watch.store.mnm.dto.CommentDTO;
import watch.store.mnm.service.CommentService;

import java.util.List;

@RestController
public class CommentResource {

    @Autowired
    private CommentService commentService;

    @GetMapping(value = "/comment")
    public ResponseEntity<List<CommentDTO>> findAll() {

        return ResponseEntity.ok().body(commentService.getAll());
    }

    @GetMapping(value = "/comment/{id}")
    public @ResponseBody CommentDTO findById(@PathVariable("id") int id) {
        return commentService.findById(id);
    }

    @DeleteMapping(value = "comment/delete/{id}")
    public @ResponseBody int deleteById(@PathVariable int id) {
        return commentService.deleteCommentById(id);
    }
}
