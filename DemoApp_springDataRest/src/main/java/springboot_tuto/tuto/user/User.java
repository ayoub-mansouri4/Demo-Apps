package springboot_tuto.tuto.user;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user ",updatable = false,unique = true)
    private Long id;

    @Column(name = "name",nullable = false,columnDefinition = "TEXT")
    private  String name;

    @Column(name = "city",nullable = false,columnDefinition = "TEXT")
    private  String city;

    public User(Long id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
