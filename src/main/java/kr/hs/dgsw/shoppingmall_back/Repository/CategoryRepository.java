package kr.hs.dgsw.shoppingmall_back.Repository;

import kr.hs.dgsw.shoppingmall_back.Domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
