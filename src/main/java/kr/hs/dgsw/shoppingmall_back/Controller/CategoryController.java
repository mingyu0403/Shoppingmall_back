package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.Category;
import kr.hs.dgsw.shoppingmall_back.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @PostConstruct
    private void init(){
        this.categoryRepository.save(new Category("상의(남)", 1));
        this.categoryRepository.save(new Category("하의(남)", 2));
        this.categoryRepository.save(new Category("상의(여)", 3));
        this.categoryRepository.save(new Category("하의(여)", 4));
        this.categoryRepository.save(new Category("구두", 5));
        this.categoryRepository.save(new Category("가방", 6));
        this.categoryRepository.save(new Category("소품", 7));
    }

    @GetMapping("/category/getAll")
    public List getAllCategories(){
        return this.categoryRepository.findAll();
    }

    @GetMapping("/category/get/{id}")
    public Category getCategory(@PathVariable Long id){
        return this.categoryRepository.findById(id).orElse(null);
    }
}
