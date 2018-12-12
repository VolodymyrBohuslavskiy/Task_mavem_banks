package MODEL;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table
@Data
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    String  name,
            surname,
            phone="+380" + new Random().nextInt() * 99999,
            email,
            login,
            password;

    public User(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password=shfrInt(this.name,1);
        this.login=name + surname + phone.substring(11);
    }


    public static String shfrInt(String s, int kay) {
        byte[] c = s.getBytes();
        byte[] cnew = new byte[c.length];
        for (int i = 0; i < c.length; i++) {
            byte b = c[i];
            int i1 = kay + b;
            cnew[i] = (byte) i1;
        }
        String s1 = new String(cnew);
        return s1;
    }

}
