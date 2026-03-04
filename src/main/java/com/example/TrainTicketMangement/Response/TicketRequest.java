package com.example.TrainTicketMangement.Response;

public class TicketRequest {

    private String seatNumber;
    private Long userId;
    private Long trainScheduleId;
    private int noOfTickets;

    public TicketRequest(String seatNumber, Long userId, Long trainScheduleId, int noOfTickets) {
        this.seatNumber = seatNumber;
        this.userId = userId;
        this.trainScheduleId = trainScheduleId;
        this.noOfTickets = noOfTickets;
    }

    public int getNoOfTickets() {
        return noOfTickets;
    }

    public void setNoOfTickets(int noOfTickets) {
        this.noOfTickets = noOfTickets;
    }

    public TicketRequest() {
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
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
