package com.example.TrainTicketMangement.Response;

import java.time.LocalTime;

public class TrainRequest {
   // private Long id;
    private String trainName;
    private String trainNumber;
    private String source;
    private  String destination;
    private Long totalSeats;
    private LocalTime departureTime;
    private  LocalTime arrivingTime;

 public TrainRequest() {
 }

 public TrainRequest(String trainName, String trainNumber, String source, String destination, Long totalSeats, LocalTime departureTime, LocalTime arrivingTime) {
  this.trainName = trainName;
  this.trainNumber = trainNumber;
  this.source = source;
  this.destination = destination;
  this.totalSeats = totalSeats;
  this.departureTime = departureTime;
  this.arrivingTime = arrivingTime;
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

 public String getSource() {
  return source;
 }

 public void setSource(String source) {
  this.source = source;
 }

 public String getDestination() {
  return destination;
 }

 public void setDestination(String destination) {
  this.destination = destination;
 }

 public Long getTotalSeats() {
  return totalSeats;
 }

 public void setTotalSeats(Long totalSeats) {
  this.totalSeats = totalSeats;
 }

 public LocalTime getDepartureTime() {
  return departureTime;
 }

 public void setDepartureTime(LocalTime departureTime) {
  this.departureTime = departureTime;
 }

 public LocalTime getArrivingTime() {
  return arrivingTime;
 }

 public void setArrivingTime(LocalTime arrivingTime) {
  this.arrivingTime = arrivingTime;
 }
}
