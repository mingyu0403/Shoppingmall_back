package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> findAll();
    Product findById(Long productId);
    Product addProduct(Product product);
    Product editProduct(Product product);
    boolean deleteById(Long productId);

}
