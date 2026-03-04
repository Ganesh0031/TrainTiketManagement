package com.example.TrainTicketMangement.Service.ServiceImpl;

import com.example.TrainTicketMangement.Entity.Status;
import com.example.TrainTicketMangement.Entity.Tickets;
import com.example.TrainTicketMangement.Entity.TrainSchedule;
import com.example.TrainTicketMangement.Repository.TicketsRepository;
import com.example.TrainTicketMangement.Repository.TrainRepository;
import com.example.TrainTicketMangement.Repository.TrainScheduleRepository;
import com.example.TrainTicketMangement.Repository.UsersRepository;
import com.example.TrainTicketMangement.Response.TicketRequest;
import com.example.TrainTicketMangement.Response.TicketResponse;
import com.example.TrainTicketMangement.Service.TicketsService;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketsImpl implements TicketsService {

    private TicketsRepository ticketsRepository;
    private  ModelMapper modelMapper;
    private TrainRepository trainRepository;
    private TrainScheduleRepository trainScheduleRepository;
    private UsersRepository usersRepository;

    public TicketsImpl(TicketsRepository ticketsRepository, TrainRepository trainRepository, ModelMapper modelMapper, TrainScheduleRepository trainScheduleRepository,UsersRepository usersRepository) {
        this.ticketsRepository = ticketsRepository;
        this.modelMapper=modelMapper;
        this.trainRepository=trainRepository;
        this.trainScheduleRepository=trainScheduleRepository;
        this.usersRepository=usersRepository;
    }

    @Transactional
    @Override
    public TicketResponse bookTicket(TicketRequest ticketRequest) {

        TrainSchedule trainSchedule = trainScheduleRepository
                .findById(ticketRequest.getTrainScheduleId())
                .orElseThrow(() -> new RuntimeException("Schedule not found"));

        if (trainSchedule.getAvailableSeats() < ticketRequest.getNoOfTickets()) {
            throw new RuntimeException("Seats not available");
        }

        trainSchedule.setAvailableSeats(
                trainSchedule.getAvailableSeats() - ticketRequest.getNoOfTickets()
        );

        trainScheduleRepository.save(trainSchedule);

        Tickets ticket = new Tickets();
        ticket.setTrainSchedule(trainSchedule);
        ticket.setNoOfTickets(ticketRequest.getNoOfTickets());
        ticket.setBookDate(LocalDateTime.now());
        ticket.setStatus(Status.BOOKED);

        Tickets savedTicket = ticketsRepository.save(ticket);

        return modelMapper.map(savedTicket, TicketResponse.class);
    }
      @Transactional
    @Override
    public TicketResponse cancelTicket(Long ticketId, Long userId) {
         Tickets tickets=ticketsRepository.findById(ticketId).orElseThrow(
                 ()->new RuntimeException("The ticket is not found")
         );
          if (!tickets.getUsers().getId().equals(userId)) {
              throw new RuntimeException("You are not authorized to cancel this ticket");
          }

          if (tickets.getStatus() == Status.CANCELLED) {
              throw new RuntimeException("Ticket already cancelled");
          }

          TrainSchedule trainSchedule =   tickets.getTrainSchedule();
        trainSchedule.setAvailableSeats(trainSchedule.getAvailableSeats()+tickets.getNoOfTickets());
        trainScheduleRepository.save(trainSchedule);
        tickets.setStatus(Status.CANCELLED);
        Tickets savedTicked=ticketsRepository.save(tickets);
        return modelMapper.map(savedTicked,TicketResponse.class);


    }

    @Override
    public TicketResponse getTicketById(Long ticketId, Long userId) {
        Tickets tickets=ticketsRepository.findById(ticketId).orElseThrow(
                ()->new RuntimeException("The ticket is not found")
        );
        if (!tickets.getUsers().getId().equals(userId)) {
            throw new RuntimeException("You are not authorized to cancel this ticket");
        }
        return modelMapper.map(tickets,TicketResponse.class);
    }

    @Override
    public List<TicketResponse> getUserTickets(Long userId) {
       if(!usersRepository.existsById(userId)){
           throw new RuntimeException("The User Not exists");
       }
       List<Tickets>tickets=ticketsRepository.getByUserId(userId);
       return tickets.stream().map(
              tickets1 ->
                        modelMapper.map(tickets,TicketResponse.class)
       ).collect(Collectors.toList());
    }
}
