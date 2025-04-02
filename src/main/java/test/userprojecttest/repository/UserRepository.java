package test.userprojecttest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import test.userprojecttest.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
