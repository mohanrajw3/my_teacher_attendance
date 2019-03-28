package app.datamapper;

import app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    User findByEmail(String email);

    User findUserByPhone(String phoneNo);

    User findUserById(int id);



}
