package com.example.TrainTicketMangement.Config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigBeans {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
