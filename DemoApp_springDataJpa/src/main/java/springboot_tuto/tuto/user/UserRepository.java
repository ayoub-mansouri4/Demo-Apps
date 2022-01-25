package springboot_tuto.tuto.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //this interface is for data access layer it allow us to use (CRUD) methodes
}
