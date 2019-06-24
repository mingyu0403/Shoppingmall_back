package kr.hs.dgsw.shoppingmall_back.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 제조사
    @Column(nullable = false)
    private String manufacturer;
    // 제품 이름
    @Column(nullable = false)
    private String name;
    // 제품 설명
    @Column(nullable = false)
    private String info;
    // 시중 가격
    @Column(nullable = false)
    private String realPrice;
    // 판매 가격
    @Column(nullable = false)
    private String salePrice;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

}
