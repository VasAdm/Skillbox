import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Course implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int duration;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "enum")
    private CourseType type;
    private String description;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Teacher teacher;

    @Column(name = "students_count")
    private Integer studentsCount;
    private int price;

    @Column(name = "price_per_hour")
    private float pricePerHour;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "Subscriptions", joinColumns = {@JoinColumn(name = "course_id", referencedColumnName = "id")}, inverseJoinColumns = {@JoinColumn(name = "student_id", referencedColumnName = "id")})
    private List<Student> students = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private List<Subscription> subscriptions = new ArrayList<>();
}