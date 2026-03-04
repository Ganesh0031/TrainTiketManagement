package com.example.TrainTicketMangement.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import org.hibernate.validator.internal.IgnoreForbiddenApisErrors;

import java.lang.reflect.Type;
import java.time.LocalDateTime;

@Entity
public class Tickets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    @SequenceGenerator(
            name = "ticket_seq",
            sequenceName = "ticket_sequence",
            allocationSize = 1
    )
    private Long ticketNumber;
    private String seatNumber;
    private LocalDateTime  bookDate;
    private int noOfTickets;
    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonBackReference
    private Users users;
    @ManyToOne
    @JoinColumn(name = "schedule_id")
    private TrainSchedule trainSchedule;

    public Tickets(Long id, Long ticketNumber, String seatNumber, LocalDateTime bookDate, int noOfTickets, Status status, Users users, TrainSchedule trainSchedule) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.bookDate = bookDate;
        this.noOfTickets = noOfTickets;
        this.status = status;
        this.users = users;
        this.trainSchedule = trainSchedule;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public Tickets() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(Long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public TrainSchedule getTrainSchedule() {
        return trainSchedule;
    }

    public void setTrainSchedule(TrainSchedule trainSchedule) {
        this.trainSchedule = trainSchedule;
    }
}
