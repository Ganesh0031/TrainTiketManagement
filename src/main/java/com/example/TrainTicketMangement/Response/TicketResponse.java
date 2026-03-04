package com.example.TrainTicketMangement.Response;

import com.example.TrainTicketMangement.Entity.Status;
import com.example.TrainTicketMangement.Entity.TrainSchedule;
import com.example.TrainTicketMangement.Entity.Users;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class TicketResponse {
    private Long id;
    private Long ticketNumber;
    private String seatNumber;
    private int noOfTickets;
    private LocalDateTime bookDate;
    private String status;

    private Long userId;
    private Long trainScheduleId;

    public TicketResponse(Long id, Long ticketNumber, String seatNumber, int noOfTickets, LocalDateTime bookDate, String status, Long userId, Long trainScheduleId) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.seatNumber = seatNumber;
        this.noOfTickets = noOfTickets;
        this.bookDate = bookDate;
        this.status = status;
        this.userId = userId;
        this.trainScheduleId = trainScheduleId;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public TicketResponse() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getTrainScheduleId() {
        return trainScheduleId;
    }

    public void setTrainScheduleId(Long trainScheduleId) {
        this.trainScheduleId = trainScheduleId;
    }
}
