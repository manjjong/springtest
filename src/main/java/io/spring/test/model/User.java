package io.spring.test.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;

    @NotEmpty(message = "The password must not be null")
    private String password;

    @NotEmpty(message = "The name must not be null")
    private String name;

    @NotEmpty(message = "The email must not be null")
    private String email;
}
