package com.howtodoinjava;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HowtodoinjavaSpringBatchExampleApplication {
	
	@Autowired
	private JobLauncher jobLauncher;
	
	@Autowired
	private Job job;
	

	public static void main(String[] args) {
		SpringApplication.run(HowtodoinjavaSpringBatchExampleApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		JobParameters jobParams = new JobParametersBuilder().addString("JOBID", String.valueOf(System.currentTimeMillis())).toJobParameters();
		jobLauncher.run(job, jobParams);
	}

}
