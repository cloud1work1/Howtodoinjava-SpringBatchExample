package com.howtodoinjava.config;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.howtodoinjava.model.Task1;
import com.howtodoinjava.model.Task2;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	private StepBuilderFactory stepBuilderFactory;
	
	@Bean
	public Step StepOne() {
		return stepBuilderFactory.get("Step One").tasklet(new Task1()).build();
	}
	
	@Bean
	public Step StepTwo() {
		return stepBuilderFactory.get("Step Two").tasklet(new Task2()).build();
	}
	
	@Bean
	public Job JobOne() {
		return jobBuilderFactory.get("Job One").incrementer(new RunIdIncrementer()).start(StepOne()).next(StepTwo()).build();
	}
}
