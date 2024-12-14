package com.SchoolManagementSystem.kafka;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {
	
	@Scheduled(cron = "0 0 9 * * ?")
    public void sendDailyNotification() {
        System.out.println("Sending daily notification...");
    }

}
