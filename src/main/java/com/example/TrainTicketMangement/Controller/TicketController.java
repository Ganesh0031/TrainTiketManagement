package com.example.TrainTicketMangement.Controller;

import com.example.TrainTicketMangement.Response.TicketRequest;
import com.example.TrainTicketMangement.Response.TicketResponse;
import com.example.TrainTicketMangement.Service.TicketsService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tickets")
public class TicketController {
    private final TicketsService ticketsService;

    public TicketController(TicketsService ticketsService) {
        this.ticketsService = ticketsService;
    }
    @PostMapping("/book")
   public ResponseEntity<TicketResponse> bookTicket(@RequestBody @Valid TicketRequest ticketRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(ticketsService.bookTicket(ticketRequest));
   }
   @PutMapping("/cancelTicket/{ticketId}/{userId}")
   public ResponseEntity<TicketResponse>cancelTicket(@PathVariable Long ticketId, @PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.cancelTicket(ticketId,userId));
   }
   @GetMapping("/getTicketById/{ticketId}/{userId}")
    public ResponseEntity<TicketResponse> getTicketById(@PathVariable Long ticketId,@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getTicketById(ticketId,userId));
    }
    @GetMapping("/getTicketByUserId/{userId}")
    public ResponseEntity<List<TicketResponse>> getUserTickets(@PathVariable  Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(ticketsService.getUserTickets(userId));
    }
}
