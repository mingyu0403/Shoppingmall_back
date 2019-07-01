package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import kr.hs.dgsw.shoppingmall_back.Domain.ShoppingCart;
import kr.hs.dgsw.shoppingmall_back.Service.ProductService;
import kr.hs.dgsw.shoppingmall_back.Service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;

    @GetMapping("/shoppingCart/getAll/{userId}")
    public List<ShoppingCart> getShoppingCartByUserId(@PathVariable Long userId){
        return this.shoppingCartService.findAllByUserId(userId);
    }

    @PostMapping("/shoppingCart/add")
    public ShoppingCart addProduct(@RequestBody ShoppingCart shoppingCart){
        return this.shoppingCartService.add(shoppingCart);
    }

    @DeleteMapping("/shoppingCart/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return this.shoppingCartService.deleteById(id);
    }

}
