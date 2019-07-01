package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Product;
import kr.hs.dgsw.shoppingmall_back.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/product/getAll")
    public List getAllProducts(){
        return this.productService.findAll();
    }

    @GetMapping("/product/get/{id}")
    public Product getProduct(@PathVariable Long id){
        return this.productService.findById(id);
    }

    @PostMapping("/product/add")
    public Product addProduct(@RequestBody Product product){
        return this.productService.addProduct(product);
    }

    @PutMapping("/product/edit")
    public Product modifyProduct(@RequestBody Product product){
        return this.productService.editProduct(product);
    }

    @DeleteMapping("/product/delete/{id}")
    public boolean deleteProduct(@PathVariable Long id){
        return this.productService.deleteById(id);
    }

}
