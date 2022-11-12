import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@Entity
@Table(name = "Subscriptions")
public class Subscription {
    @EmbeddedId
    private SubscriptionKey key;

    @Column(name = "subscription_date")
    private Timestamp subscriptionDate;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "course_id", insertable = false, updatable = false)
    private Course course;

    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "student_id", insertable = false, updatable = false)
    private Student student;

    @Embeddable
    @Data
    public static class SubscriptionKey implements Serializable {

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;
    }
}