package com.example.TrainTicketMangement.Service;

import com.example.TrainTicketMangement.Response.TicketRequest;
import com.example.TrainTicketMangement.Response.TicketResponse;

import java.util.List;

public interface TicketsService {
    TicketResponse bookTicket(TicketRequest ticketRequest);
    TicketResponse cancelTicket(Long ticketId, Long userId);
    TicketResponse getTicketById(Long ticketId, Long userId);
    List<TicketResponse> getUserTickets(Long userId);
}
