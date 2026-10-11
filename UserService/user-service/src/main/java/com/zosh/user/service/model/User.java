package com.zosh.user.service.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String fullName;
    @Email(message = "Enter a valid email")
    @NotBlank(message = "email is compulsory")
    private String email;
    private String phone;
    @NotBlank(message = "role is compulsory")
    private String role;
    @CreationTimestamp
    private LocalDateTime localDateTime;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    @NotBlank(message = "password is compulsory")
    private String password;

}
