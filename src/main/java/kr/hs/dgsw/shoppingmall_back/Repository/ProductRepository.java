package kr.hs.dgsw.shoppingmall_back.Repository;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
