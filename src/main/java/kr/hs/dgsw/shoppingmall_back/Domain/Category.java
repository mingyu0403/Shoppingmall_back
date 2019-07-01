package kr.hs.dgsw.shoppingmall_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 카테고리 이름
    @Column(nullable = false)
    private String name;

    // 이미지
    private Long attachmentId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "categoryId")
    private List<Product> productList;


    public Category(String name, long attachmentId){
        this.attachmentId = attachmentId;
        this.name = name;
    }
}
