package ojt.petshop.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "petinfo")
public class Pet {
    
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "sex")
    private String sex;
    @Column(name = "age")
    private String age;
    @Column(name = "type")
    private String type;
    @Column(name = "hobby")
    private String hobby;

    public Pet(String name, String sex, String age, String type, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.type = type;
        this.hobby = hobby;
    }

}
