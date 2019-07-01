package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;
import kr.hs.dgsw.shoppingmall_back.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @PostMapping("/comment/add")
    public Comment add(@RequestBody Comment comment){
        return this.commentService.add(comment);
    }
}
