package kr.hs.dgsw.shoppingmall_back.Service;

import kr.hs.dgsw.shoppingmall_back.Domain.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    ShoppingCart findById(Long id);
    List<ShoppingCart> findAllByUserId(Long userId);
    ShoppingCart add(ShoppingCart shoppingCart);
    boolean deleteById(Long id);
}
