package com.example.TrainTicketMangement.Controller;

import com.example.TrainTicketMangement.Response.UserRequest;
import com.example.TrainTicketMangement.Response.UserResponse;
import com.example.TrainTicketMangement.Service.UserService;
import com.example.TrainTicketMangement.dto.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/User")
@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/register")
    public ResponseEntity<ApiResponse<UserResponse>>registerUser(@RequestBody UserRequest userRequest){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse(
                        "success",
                        true,
                        userService.registerUser(userRequest)
                ));
    }
    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserResponse>>loginUser(@RequestParam("email")String email,@RequestParam("password")String password){
        return ResponseEntity.status(HttpStatus.OK)
                .body(new ApiResponse<>(
                        "success",
                        true,
                        userService.loginUser(email, password)
                ));
    }
}
