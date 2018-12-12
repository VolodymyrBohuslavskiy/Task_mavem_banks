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
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String name, surname;
    int age;
    int tell;

    public Client(String name, String surname, int age, int tell) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.tell = tell;
    }
}
