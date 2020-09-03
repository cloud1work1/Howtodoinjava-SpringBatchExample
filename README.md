# Howtodoinjava-SpringBatchExample
## Config ##
- @Configuration
- @EnableBatchProcessing
- Autowired JobBuilderFactory
  - JobBuilderFactory.get("job name").incrementer(new RunIdIncrementer()).start(StepN()).next(StepM()).build() => returns job
- Autowired StepBuilderFactory
  - StepBuilderFactory.get("StepN").tasklet(new TaskN()).build() => returns step
## Tasklet Implementation ##
- class TaskN implements Tasklet
  - @override execute => return RepeatStatus
    - return RepeatStatus.FINISHED
## Main Configuration ##
- Autowired JobLauncher
- Autowired Job
- override run(String... args)
  - JobParameters jp = new JobParametersBuilder().addString("JOBID", String.valueOf(System.currentTimeMillis()).toJobParameters();
  - JobLauncher.run(Job, jp);
