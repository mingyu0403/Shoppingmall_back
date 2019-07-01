package kr.hs.dgsw.shoppingmall_back.Repository;

import kr.hs.dgsw.shoppingmall_back.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}
