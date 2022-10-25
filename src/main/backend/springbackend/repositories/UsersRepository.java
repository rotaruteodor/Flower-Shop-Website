package springbackend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import springbackend.entities.User;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<User, Long> {
//    @Query(value = "SELECT u FROM users u WHERE u.emailAddress=?1")
    Optional<User> findByEmailAddress(String email);
//    @Query(value = "SELECT u FROM users u WHERE u.emailAddress =:email AND u.password =:password")
    Optional<User> findByEmailAddressAndPassword(String email, String password);

}
