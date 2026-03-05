package com.example.TrainTicketMangement.Service.ServiceImpl;

import com.example.TrainTicketMangement.Entity.Train;
import com.example.TrainTicketMangement.Entity.TrainSchedule;
import com.example.TrainTicketMangement.Entity.TrainStatus;
import com.example.TrainTicketMangement.Repository.TrainRepository;
import com.example.TrainTicketMangement.Repository.TrainScheduleRepository;
import com.example.TrainTicketMangement.Response.TrainScheduleRequest;
import com.example.TrainTicketMangement.Response.TrainScheduleResponse;
import com.example.TrainTicketMangement.Service.TrainScheduleService;
import com.example.TrainTicketMangement.Service.TrainService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainScheduleImpl implements TrainScheduleService {
     private final TrainScheduleRepository trainScheduleRepository;
     private final ModelMapper modelMapper;
     private final TrainRepository trainRepository;

    public TrainScheduleImpl(TrainScheduleRepository trainScheduleRepository, ModelMapper modelMapper, TrainRepository trainRepository) {
        this.trainScheduleRepository = trainScheduleRepository;
        this.modelMapper = modelMapper;
        this.trainRepository = trainRepository;
    }

    @Override
    public TrainScheduleResponse addTrainSchedule(TrainScheduleRequest trainScheduleRequest) {
       Train train=trainRepository.findById(trainScheduleRequest.getTrainId()).orElseThrow(()->
               new RuntimeException("The Train Not found"));
        TrainSchedule schedule = new TrainSchedule();
        schedule.setJourneyDate(trainScheduleRequest.getJourneyDate());
        schedule.setStatus(TrainStatus.valueOf(trainScheduleRequest.getStatus().toUpperCase()));
        schedule.setAvailableSeats(trainScheduleRequest.getTotalSeats());
        schedule.setTrain(train);
        TrainSchedule saved = trainScheduleRepository.save(schedule);
        return modelMapper.map(saved,TrainScheduleResponse.class);
    }

    @Override
    public List<TrainScheduleResponse> getTrainSchedule() {
        List<TrainSchedule>trainScheduleList=trainScheduleRepository.findAll();
        return trainScheduleList.stream().map(
                trainSchedule -> modelMapper.map(trainSchedule,TrainScheduleResponse.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TrainScheduleResponse updateTrainSchedule(Long id, TrainScheduleRequest trainScheduleRequest) {
        TrainSchedule trainSchedule=trainScheduleRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Schedule Not Found"));
        Train train=trainRepository.findById(trainScheduleRequest.getTrainId()).orElseThrow(
                ()->new RuntimeException("The Train not found")
        );

        trainSchedule.setJourneyDate(trainScheduleRequest.getJourneyDate());
        trainSchedule.setStatus(TrainStatus.valueOf(trainScheduleRequest.getStatus().toUpperCase()));
        trainSchedule.setAvailableSeats(trainScheduleRequest.getTotalSeats());
        trainSchedule.setTrain(train);

        TrainSchedule updated = trainScheduleRepository.save(trainSchedule);
        return modelMapper.map(updated,TrainScheduleResponse.class);
    }

    @Override
    public TrainScheduleResponse getTrainScheduleById(Long id) {
        TrainSchedule schedule = trainScheduleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Schedule not found"));
        return modelMapper.map(schedule,TrainScheduleResponse.class);
    }

    @Override
    public void deleteTrainSchedule(Long id) {
        if (!trainScheduleRepository.existsById(id)) {
            throw new RuntimeException("Schedule not found");
        }

        trainScheduleRepository.deleteById(id);
    }
}
