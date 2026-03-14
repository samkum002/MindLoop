package com.mind.trail.MindTrail;

import java.time.LocalDate;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
// import org.springframework.mail.javamail.JavaMailSender;
// import org.springframework.scheduling.annotation.Scheduled;

@Service
public class moodServiceImpl implements moodService {
    
    @Autowired
    private moodRepo moodRepository;

    @Autowired
    private userRepo userRepository;

    // @Autowired
    // JavaMailSender mailSender;

    @Override
    public ResponseEntity<?> recordMood(moodDTO mood) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = auth.getName();
        ObjectId userId = userRepository.findByUsername(username).getId();
        moodEntity newMood = new moodEntity();
        newMood.setMood(mood.getMood());
        newMood.setUserId(userId);  
        newMood.setDate(LocalDate.now());
        moodRepository.save(newMood);
        return ResponseEntity.ok("Mood recorded successfully for user " + username);
    }

    // @Override
    // @Scheduled(cron = "0 0 0 * * ?") // 24 hrs                        
    // public ResponseEntity<?> sendMail() {
    //     moodType sad = ;
    //     return ResponseEntity.ok("Email sent successfully");
    // }
}
