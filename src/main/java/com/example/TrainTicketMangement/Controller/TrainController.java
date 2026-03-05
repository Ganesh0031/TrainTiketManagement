package com.example.TrainTicketMangement.Controller;

import com.example.TrainTicketMangement.Response.TrainRequest;
import com.example.TrainTicketMangement.Response.TrainResponse;
import com.example.TrainTicketMangement.Service.TrainService;
import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/train")
public class TrainController {

    private final TrainService trainService;

    public TrainController(TrainService trainService) {
        this.trainService = trainService;
    }
    @PostMapping("/addTrain")
   public ResponseEntity< TrainResponse> addTrains(@RequestBody TrainRequest trainRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainService.addTrains(trainRequest));
   }
   @PutMapping("/updateTrain/{id}")
   public ResponseEntity<TrainResponse> updateTrains(Long id,@RequestBody TrainRequest trainRequest){
        return ResponseEntity.status(HttpStatus.OK).body(trainService.updateTrains(id,trainRequest));
   }
   @DeleteMapping("/deleteTrain/{id}")
   public  ResponseEntity<Void> deleteTrains(Long id){
       trainService.deleteTrains(id);

       return ResponseEntity.noContent().build();
   }
   @GetMapping("/GetAllTrain")
    public ResponseEntity<List< TrainResponse> >getAllTrain(){
        return  ResponseEntity.status(HttpStatus.OK).body(trainService.getAllTrain());
    }
    @GetMapping("/GetTrainById/{id}")
   public  ResponseEntity<TrainResponse >trainGetByTrain(Long id){
        return ResponseEntity.status(HttpStatus.OK).body(trainService.trainGetByTrain(id));
   }
}
