package com.senderz.config;

import com.senderz.service.ReminderService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

    @Autowired
    private ReminderService reminderService;

    @Bean
    public JobDetail reminderJobDetail() {
        return JobBuilder.newJob(ReminderJob.class)
                .withIdentity("reminderJob")
                .storeDurably()
                .build();
    }

    @Bean
    public Trigger reminderJobTrigger() {
        SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInMinutes(1)
                .repeatForever();

        return TriggerBuilder.newTrigger()
                .forJob(reminderJobDetail())
                .withIdentity("reminderTrigger")
                .withSchedule(scheduleBuilder)
                .build();
    }

    @Autowired
    public void configureJobs(Scheduler scheduler) throws SchedulerException {
        scheduler.scheduleJob(reminderJobDetail(), reminderJobTrigger());
    }

    public static class ReminderJob implements Job {

        @Autowired
        private ReminderService reminderService;

        @Override
        public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {

        }

        }
    }
