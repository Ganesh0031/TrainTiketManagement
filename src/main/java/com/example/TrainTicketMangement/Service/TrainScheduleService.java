package com.example.TrainTicketMangement.Service;

import com.example.TrainTicketMangement.Entity.TrainSchedule;
import com.example.TrainTicketMangement.Response.TrainScheduleRequest;
import com.example.TrainTicketMangement.Response.TrainScheduleResponse;

import java.util.List;

public interface TrainScheduleService {
    TrainScheduleResponse addTrainSchedule(TrainScheduleRequest trainScheduleRequest);
    List<TrainScheduleResponse> getTrainSchedule();
    TrainScheduleResponse updateTrainSchedule(Long id,TrainScheduleRequest trainScheduleRequest);
    TrainScheduleResponse getTrainScheduleById(Long id);
    void deleteTrainSchedule(Long id);
}
