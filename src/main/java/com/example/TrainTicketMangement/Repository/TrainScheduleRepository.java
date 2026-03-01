package com.example.TrainTicketMangement.Repository;

import com.example.TrainTicketMangement.Entity.TrainSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainScheduleRepository extends JpaRepository<TrainSchedule,Long>{

}