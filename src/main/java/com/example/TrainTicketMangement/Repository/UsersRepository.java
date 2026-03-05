package com.example.TrainTicketMangement.Repository;

import com.example.TrainTicketMangement.Entity.Users;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository  extends JpaRepository<Users,Long> {
    boolean existsByEmail(String email);
    Optional<Users> findByEmail(String email);
//    @Query(value = "select password from users where email= :email",nativeQuery = true)
//    String  getPasswordByUserName (@Param("email") String password);
}
