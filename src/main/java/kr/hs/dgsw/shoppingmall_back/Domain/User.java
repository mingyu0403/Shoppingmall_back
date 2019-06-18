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
    private Long id;

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
    @Column(unique = true)
    private String homeNumber;
    // 핸드폰
    @Column(unique = true)
    private String phoneNumber;

    // 우편번호
    @Column(unique = true)
    private String postCode;
    // 주소
    @Column(unique = true)
    private String address;
    // 이메일 주소
    @Column(unique = true)
    private String email;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime updated;

}
