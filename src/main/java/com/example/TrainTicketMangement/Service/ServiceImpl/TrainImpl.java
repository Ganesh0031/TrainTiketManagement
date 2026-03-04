package com.example.TrainTicketMangement.Service.ServiceImpl;

import com.example.TrainTicketMangement.Response.TrainRequest;
import com.example.TrainTicketMangement.Response.TrainResponse;
import com.example.TrainTicketMangement.Service.TrainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrainImpl implements TrainService {
    @Override
    public TrainResponse addTrains(TrainRequest trainRequest) {
        return null;
    }

    @Override
    public TrainResponse updateTrains(Long id, TrainRequest trainRequest) {
        return null;
    }

    @Override
    public TrainResponse deleteTrains(Long id) {
        return null;
    }

    @Override
    public List<TrainResponse> getAllTrain() {
        return List.of();
    }

    @Override
    public TrainResponse trainGetByTrain(Long id) {
        return null;
    }
}
