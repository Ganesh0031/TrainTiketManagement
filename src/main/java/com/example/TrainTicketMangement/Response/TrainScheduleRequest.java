package com.example.TrainTicketMangement.Response;

import java.time.LocalDate;

public class TrainScheduleRequest {
    private LocalDate journeyDate;
    private String status;   // SCHEDULED, CANCELLED, etc
    private Long totalSeats;
    private Long trainId;

    public TrainScheduleRequest(LocalDate journeyDate, String status, Long totalSeats, Long trainId) {
        this.journeyDate = journeyDate;
        this.status = status;
        this.totalSeats = totalSeats;
        this.trainId = trainId;
    }

    public LocalDate getJourneyDate() {
        return journeyDate;
    }

    public void setJourneyDate(LocalDate journeyDate) {
        this.journeyDate = journeyDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Long getTotalSeats() {
        return totalSeats;
    }

    public void setTotalSeats(Long totalSeats) {
        this.totalSeats = totalSeats;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }
}
