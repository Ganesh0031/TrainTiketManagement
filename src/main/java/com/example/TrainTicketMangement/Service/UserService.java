package com.example.TrainTicketMangement.Service;

import com.example.TrainTicketMangement.Entity.Users;
import com.example.TrainTicketMangement.Response.UserRequest;
import com.example.TrainTicketMangement.Response.UserResponse;
import org.apache.catalina.User;

public interface UserService {
     UserResponse registerUser(UserRequest user);
     UserResponse loginUser(String email,String password);
}
