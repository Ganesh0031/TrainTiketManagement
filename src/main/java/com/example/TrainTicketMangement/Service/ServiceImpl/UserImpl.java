package com.example.TrainTicketMangement.Service.ServiceImpl;

import com.example.TrainTicketMangement.Entity.Role;
import com.example.TrainTicketMangement.Entity.Users;
import com.example.TrainTicketMangement.Repository.UsersRepository;
import com.example.TrainTicketMangement.Response.UserRequest;
import com.example.TrainTicketMangement.Response.UserResponse;
import com.example.TrainTicketMangement.Service.UserService;
import org.apache.catalina.User;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class UserImpl implements UserService {
    private final UsersRepository usersRepository;
    private final ModelMapper modelMapper;

    public UserImpl(UsersRepository usersRepository, ModelMapper modelMapper) {
        this.usersRepository = usersRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public UserResponse registerUser(UserRequest user) {
        if(usersRepository.existsByEmail(user.getEmail())){
            throw  new RuntimeException("The email id is already exists");
        }
        if(!user.getConfirmPassword().equals(user.getPassword())){
            throw  new RuntimeException("The password is not match");
        }
        Users users1=modelMapper.map(user,Users.class);
        users1.setRole(Role.User);
        Users savedUser = usersRepository.save(users1);
        return modelMapper.map(savedUser,UserResponse.class);

    }

    @Override
    public UserResponse loginUser(String email, String password) {
        Users user = usersRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }
        return modelMapper.map(user,UserResponse.class);

    }

}
