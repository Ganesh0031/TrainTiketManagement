package com.example.TrainTicketMangement.Repository;

import com.example.TrainTicketMangement.Entity.Tickets;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketsRepository extends JpaRepository<Tickets,Long> {
    @Query(value = "Select * from tickets where  user_id = :userId" ,nativeQuery = true)
    List<Tickets>getByUserId(@Param("userId") Long userId);


    boolean existsById(Long id);
}
