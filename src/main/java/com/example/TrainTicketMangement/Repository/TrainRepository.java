package com.example.TrainTicketMangement.Repository;

import com.example.TrainTicketMangement.Entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train ,Long> {
}
