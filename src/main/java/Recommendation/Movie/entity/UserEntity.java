package Recommendation.Movie.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Getter
@Setter
@Table(name = "user_details")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    @NotEmpty(message = "Username cannot be empty")
    private String userName;
    private String email;
    @NotEmpty
    private String password;

}
