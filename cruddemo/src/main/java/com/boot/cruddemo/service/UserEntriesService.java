package com.boot.cruddemo.service;

import com.boot.cruddemo.dao.UserEntriesRepository;
import com.boot.cruddemo.entity.UserEntries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEntriesService {

    @Autowired
    private UserEntriesRepository userEntriesRepository;

    //save userentries
    public UserEntries saveUserEntries(String content){
        UserEntries userEntries = new UserEntries();
        userEntries.setContent(content);
        return userEntriesRepository.save(userEntries);
    }
    //find text by id
    public Optional<UserEntries> getUserEntries(Long id){
        return userEntriesRepository.findById(id);
    }
    //update text by id
    public UserEntries updateText(Long id, String content) {
        Optional<UserEntries> optionalUserEntries = userEntriesRepository.findById(id);
        if (optionalUserEntries.isPresent()) {
            UserEntries userEntries = optionalUserEntries.get();
            userEntries.setContent(content);
            return userEntriesRepository.save(userEntries);
        }
        return null;  // Handle not found case
    }
    // Delete text by ID
    public void deleteUserEntries(Long id) {
        userEntriesRepository.deleteById(id);
    }
}
