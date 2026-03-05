package com.example.TrainTicketMangement.Service;

import com.example.TrainTicketMangement.Entity.Status;
import com.example.TrainTicketMangement.Response.TrainRequest;
import com.example.TrainTicketMangement.Response.TrainResponse;

import java.util.List;

public interface TrainService {
    TrainResponse addTrains(TrainRequest trainRequest);
    TrainResponse updateTrains(Long id,TrainRequest trainRequest);
    void deleteTrains(Long id);
    List< TrainResponse> getAllTrain();
    TrainResponse trainGetByTrain(Long id);
}
