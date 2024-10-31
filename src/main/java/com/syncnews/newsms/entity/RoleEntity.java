package com.syncnews.newsms.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity(name = "Role")
@Table(name = "role")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    private Long id;

    @Column(unique = true, updatable = false, columnDefinition = "CHAR(36)", length = 36, nullable = false)
    private String publicId;

    private String name;

    public enum Values {


    }

    @PrePersist
    protected void onCreateEntity() {
        this.publicId = UUID.randomUUID().toString();
    }
}
