import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;

@Getter
@Setter
@Entity
@Table(name = "Voters")
public class Voter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private LocalDate birthDay;

    public Voter() {

    }

    public Voter(String name, String birthDay) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd");
        LocalDate date = new Date(format.parse(birthDay).getTime()).toLocalDate();

        this.name = name;
        this.birthDay = date;
    }
}