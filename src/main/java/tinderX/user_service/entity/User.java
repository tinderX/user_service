package tinderX.user_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 64, nullable = false, unique = true)
    private String username;

    @Column(name = "email", length = 64, nullable = false)
    private String email;

    @Column(name = "password", length = 128, nullable = false)
    private String password;

    private String profilePictureUrl;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "bio", length = 4096)
    private String bio;

    @Column(name = "active", nullable = false)
    private boolean active;

    public enum Gender{
        MALE,
        FEMALE,
        NON_BINARY,
        OTHER
    }
}
