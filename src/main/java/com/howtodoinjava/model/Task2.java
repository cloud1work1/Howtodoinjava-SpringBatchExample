package com.howtodoinjava.model;

import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

public class Task2 implements Tasklet {

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		System.out.println("Task2 started");
		System.out.println(".. .. .. ");
		System.out.println("task2 completed");
		return RepeatStatus.FINISHED;
	}

}
