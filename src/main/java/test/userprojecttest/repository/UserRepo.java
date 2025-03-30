package test.userprojecttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.userprojecttest.entoties.User;


@Repository
public interface UserRepo extends JpaRepository<User, Long> {
}
