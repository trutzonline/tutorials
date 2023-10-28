package trutzio.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user_account")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(length = 500)
    private String name;

    @Lob
    private String cv;

}
