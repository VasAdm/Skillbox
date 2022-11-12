import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Students")
public class Student implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "registration_date")
    private Timestamp registrationDate;
    private int age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions", joinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")})
    private List<Course> courses = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private List<Subscription> subscriptions = new ArrayList<>();
}
