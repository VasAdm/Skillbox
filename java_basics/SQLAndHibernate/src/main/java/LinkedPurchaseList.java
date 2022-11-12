import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "LinkedPurchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private LinkedPurchaseListKey id;

    @Column(name = "student_id", insertable = false, updatable = false)
    private int studentId;

    @Column(name = "course_id", insertable = false, updatable = false)
    private int courseId;

    @Data
    @Embeddable
    public static class LinkedPurchaseListKey implements Serializable {
        public LinkedPurchaseListKey() {
        }

        public LinkedPurchaseListKey(int studentId, int courseId) {
            this.studentId = studentId;
            this.courseId = courseId;
        }

        @Column(name = "student_id")
        private int studentId;

        @Column(name = "course_id")
        private int courseId;
    }
}