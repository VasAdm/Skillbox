import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "PurchaseList")
public class PurchaseList {
    @EmbeddedId
    private PurchaseListKey id;

    @Column(name = "subscription_date")
    private Timestamp subscriptionDate;

    @Column(name = "price")
    private int price;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "course_name", referencedColumnName = "name", insertable = false, updatable = false)
    private Course course;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "student_name", referencedColumnName = "name", insertable = false, updatable = false)
    private Student student;

    @Data
    @Embeddable
    public static class PurchaseListKey implements Serializable {

        @Column(name = "course_name")
        private String courseName;

        @Column(name = "student_name")
        private String studentName;
    }
}
