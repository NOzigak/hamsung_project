package hamsung.hamsung_project.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@Table(name ="users")
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String email;

    private String password;

    private int imaged_num;

    private String role;

    private String badge;

    private float point;

    public static User createUser(Long id, String username, String email, String password, int imaged_num, String role, String badge, float point) {
        return User.builder().id(id).username(username).email(email).password(password)
                .imaged_num(imaged_num).role(role).badge(badge).point(point).build();
    }

    @OneToOne(mappedBy="user")
    @JsonManagedReference //순환참조 방지 (부모쪽)
    private Review review;

    @OneToMany(mappedBy = "users")
    private List<StudyMember> studyMember;

    @OneToMany(mappedBy = "user")
    private List<Comment> comments;


}
