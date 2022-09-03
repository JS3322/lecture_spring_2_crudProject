package com.example.lecture_spring_2_crudproject.service.scheduled;

import com.example.lecture_spring_2_crudproject.service.textTransfer.SeleniumExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTask {

    @Autowired
    SeleniumExample seleniumExample;

    @Scheduled(fixedDelay = 5000)
    public void scheduledTest() {
        seleniumExample.scraping();
    }
}
