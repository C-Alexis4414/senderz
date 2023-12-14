package com.senderz.controller;

import com.senderz.model.Reminder;
import com.senderz.service.ReminderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reminders")
public class ReminderController {

    @Autowired
    private ReminderService reminderService;

    @GetMapping
    public List<Reminder> getAllReminders() {
        return reminderService.getAllReminders();
    }
    @GetMapping("/{id}")
    public Reminder getReminderById(@PathVariable Long id) {
        return reminderService.getReminderById(id);
    }
    @PostMapping
    public Reminder createReminder(@RequestBody Reminder reminder) {
        return reminderService.createReminder(reminder);
    }
    @DeleteMapping("/{id}")
    public void deleteReminder(@PathVariable Long id) {
        reminderService.deleteReminder(id);
    }
}
