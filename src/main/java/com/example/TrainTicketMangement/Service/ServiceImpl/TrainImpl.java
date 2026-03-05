package com.example.TrainTicketMangement.Service.ServiceImpl;

import com.example.TrainTicketMangement.Entity.Train;
import com.example.TrainTicketMangement.Repository.TrainRepository;
import com.example.TrainTicketMangement.Response.TrainRequest;
import com.example.TrainTicketMangement.Response.TrainResponse;
import com.example.TrainTicketMangement.Service.TrainService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainImpl implements TrainService {
    private TrainRepository trainRepository;
    private ModelMapper modelMapper;

    public TrainImpl(TrainRepository trainRepository,ModelMapper modelMapper) {
        this.trainRepository = trainRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public TrainResponse addTrains(TrainRequest trainRequest) {
        Train  train=modelMapper.map(trainRequest,Train.class);
        Train saved=trainRepository.save(train);
        return modelMapper.map(saved,TrainResponse.class);
    }
    @Transactional
    @Override
    public TrainResponse updateTrains(Long id, TrainRequest trainRequest) {
       Train train=trainRepository.findById(id).orElseThrow(()->new RuntimeException("The Train not found"));
       if(trainRequest.getTrainName()!=null){
           train.setTrainName(trainRequest.getTrainName());
       }
       if(trainRequest.getTrainNumber()!=null){
           train.setTrainNumber(trainRequest.getTrainNumber());
       }
       if(trainRequest.getArrivingTime()!=null){
           train.setArrivingTime(trainRequest.getArrivingTime());
       }
        if(trainRequest.getSource()!=null){
            train.setSource(trainRequest.getSource());
        }
        if(trainRequest.getDestination()!=null){
            train.setDestination(trainRequest.getDestination());
        }
        if(trainRequest.getTotalSeats()!=null){
            train.setTotalSeats(trainRequest.getTotalSeats());
        }
        if(trainRequest.getDepartureTime()!=null){
            train.setDepartureTime(trainRequest.getDepartureTime());
        }
        Train savedTrain=trainRepository.save(train);
        return modelMapper.map(savedTrain,TrainResponse.class);
    }

    @Override
    public void deleteTrains(Long id) {
        Train train=trainRepository.findById(id).orElseThrow(()->new RuntimeException("The Train is not exists"));
        trainRepository.deleteById(id);
    }

    @Override
    public List<TrainResponse> getAllTrain() {
        List<Train> trains=trainRepository.findAll();
        return trains.stream().map(
                train->modelMapper.map(train,TrainResponse.class)
        ).collect(Collectors.toList());
    }

    @Override
    public TrainResponse trainGetByTrain(Long id) {
        Train train=trainRepository.findById(id).orElseThrow(()->new RuntimeException("The train not found"));
        return modelMapper.map(train,TrainResponse.class);
    }
}
