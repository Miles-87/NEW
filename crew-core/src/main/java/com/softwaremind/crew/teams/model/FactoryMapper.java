package com.softwaremind.crew.teams.model;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class FactoryMapper {
	
	@Bean
	@Scope("singleton")
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
