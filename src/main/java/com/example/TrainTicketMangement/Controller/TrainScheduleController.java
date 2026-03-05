package com.example.TrainTicketMangement.Controller;

import com.example.TrainTicketMangement.Response.TrainScheduleRequest;
import com.example.TrainTicketMangement.Response.TrainScheduleResponse;
import com.example.TrainTicketMangement.Service.TrainScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/TicketSchedule")
@RestController
public class TrainScheduleController {
    private final TrainScheduleService trainScheduleService;

    public TrainScheduleController( TrainScheduleService trainScheduleService) {
        this.trainScheduleService = trainScheduleService;
    }
    @PostMapping("/addSchedule")
    public ResponseEntity<TrainScheduleResponse> addTrainSchedule(@RequestBody TrainScheduleRequest trainScheduleRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(trainScheduleService.addTrainSchedule(trainScheduleRequest));
    }
    @GetMapping("/getSchedule")
    public ResponseEntity<List<TrainScheduleResponse>>getTrainSchedule(){
        return ResponseEntity.status(HttpStatus.OK).body(trainScheduleService.getTrainSchedule());
    }
    @PutMapping("/updateSchedule/{id}")
    public ResponseEntity<TrainScheduleResponse>updateTrainSchedule(@PathVariable Long id,@RequestBody TrainScheduleRequest trainScheduleRequest){
        return ResponseEntity.status(HttpStatus.OK).body(trainScheduleService.updateTrainSchedule(id,trainScheduleRequest));
    }
    @GetMapping("/getScheduleById/{id}")
    public ResponseEntity<TrainScheduleResponse> getTrainScheduleById(@PathVariable  Long id){
        return ResponseEntity.status(HttpStatus.OK).body(trainScheduleService.getTrainScheduleById(id));
    }
    @DeleteMapping("/deleteSchedule/{id}")
    public ResponseEntity<Void> deleteTrainSchedule(@PathVariable Long id){
        trainScheduleService.deleteTrainSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
