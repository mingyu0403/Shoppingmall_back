package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;
import kr.hs.dgsw.shoppingmall_back.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    CommentRepository commentRepository;

    @Override
    public Comment add(Comment comment) {
        return this.commentRepository.save(comment);
    }
}
