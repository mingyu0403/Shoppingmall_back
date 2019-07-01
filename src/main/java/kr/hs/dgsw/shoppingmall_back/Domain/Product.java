package kr.hs.dgsw.shoppingmall_back.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 제품 이름
    @Column(nullable = false)
    private String name;
    // 제품 설명
    @Column(nullable = false)
    private String info;
    // 제품 상세 설명
    private String detailInfo;
    // 구매 정보
    private String purchaseInfo;
    // 제조사
    @Column(nullable = false)
    private String manufacturer;

    // 카테고리
    @Column(nullable = false)
    private Long categoryId;

    // 시중 가격
    @Column(nullable = false)
    private Long fullPrice;
    // 판매 가격
    @Column(nullable = false)
    private Long salePrice;

    // 이미지
    @Column(nullable = false)
    private Long attachmentId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JoinColumn(name = "productId")
    private List<Comment> commentList;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

    public Product (String name, String info, String detailInfo, String purchaseInfo,
                    String manufacturer, long fullPrice,
                    long salePrice, long categoryId, long attachmentId){
        this.name = name;
        this.info = info;
        this.detailInfo = detailInfo;
        this.purchaseInfo = purchaseInfo;
        this.manufacturer = manufacturer;
        this.fullPrice = fullPrice;
        this.salePrice = salePrice;
        this.categoryId = categoryId;
        this.attachmentId = attachmentId;
    }

}
