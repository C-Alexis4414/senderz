package com.senderz.service;

import com.senderz.model.Reminder;
import com.senderz.repository.ReminderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReminderService {

    @Autowired
    private ReminderRepository reminderRepository;
    public List<Reminder> getAllReminders() {
        return reminderRepository.findAll();
    }
    public Reminder getReminderById(Long id) {
        return reminderRepository.findById(id).orElse(null);
    }
    public Reminder createReminder(Reminder reminder) {
        return reminderRepository.save(reminder);
    }
    public void deleteReminder(Long id) {
        reminderRepository.deleteById(id);
    }

}
