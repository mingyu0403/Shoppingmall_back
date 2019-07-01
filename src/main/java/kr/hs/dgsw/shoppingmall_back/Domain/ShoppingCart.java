package kr.hs.dgsw.shoppingmall_back.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    private Long userId;

    private Long productId;

    private int count;

}
