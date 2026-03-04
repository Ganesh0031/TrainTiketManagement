package com.example.TrainTicketMangement.Response;

import java.time.LocalDate;

public class TrainScheduleResponse {
    private Long id;
    private LocalDate journeyDate;
    private String status;
    private Long availableSeats;

    private Long trainId;
    private String trainName;
    private String trainNumber;

    public TrainScheduleResponse() {
    }

    public TrainScheduleResponse(Long id, LocalDate journeyDate, String status, Long availableSeats, Long trainId, String trainName, String trainNumber) {
        this.id = id;
        this.journeyDate = journeyDate;
        this.status = status;
        this.availableSeats = availableSeats;
        this.trainId = trainId;
        this.trainName = trainName;
        this.trainNumber = trainNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Long availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Long getTrainId() {
        return trainId;
    }

    public void setTrainId(Long trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }
}
