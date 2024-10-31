package com.syncnews.newsms.entity;

import com.syncnews.newsms.controller.token.request.LoginRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Set;
import java.util.UUID;

@Entity(name = "User")
@Table(name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    @Column(unique = true, updatable = false, columnDefinition = "CHAR(36)", length = 36, nullable = false)
    private String publicId;

    @Column(nullable = false)
    private String name;

    @Column(unique = true)
    private String username;

    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEntity> roles;

    public boolean isLoginCorrect(LoginRequest loginRequest, PasswordEncoder passwordEncoder) {
        return passwordEncoder.matches(loginRequest.password(), this.password);
    }

    @PrePersist
    protected void onCreateEntity() {
        this.publicId = UUID.randomUUID().toString();
    }
}
