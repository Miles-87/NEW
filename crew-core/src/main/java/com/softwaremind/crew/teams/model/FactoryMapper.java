package com.softwaremind.crew.teams.model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FactoryMapper {
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
