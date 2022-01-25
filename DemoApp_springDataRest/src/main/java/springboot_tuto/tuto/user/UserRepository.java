package springboot_tuto.tuto.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface UserRepository extends JpaRepository<User,Long> {
    //with spring data rest ,User ==> /users in url
    //getONE & update &  delete ==> /users/{id}
    //for RestController+service ==> delete we pass id in url & update we add id into JSON
}
