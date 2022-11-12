package main.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.id.IncrementGenerator;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String text;

    private LocalDateTime creationDate;

    private LocalDateTime taskDate;

    public void setTaskDate(String taskDate) {
        this.taskDate = LocalDateTime.parse(taskDate, DateTimeFormatter.ISO_DATE_TIME);
    }
}
