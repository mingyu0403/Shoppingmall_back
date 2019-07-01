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
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long _id;

    // 아이디
    @Column(nullable = false)
    private String account;
    // 비밀번호
    @Column(nullable = false)
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 성명
    @Column(nullable = false)
    private String name;
    // 전화번호
    private String homeNumber;
    // 핸드폰
    private String phoneNumber;

    // 우편번호
    private String postCode;
    // 주소
    private String address;
    // 이메일 주소
    private String email;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

}
