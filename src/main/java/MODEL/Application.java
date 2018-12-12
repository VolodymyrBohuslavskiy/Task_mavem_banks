package MODEL;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Application {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 int id;
String summ,statuse;

    public Application(String summ, String statuse) {
        this.summ = summ;
        this.statuse = statuse;
    }
}
