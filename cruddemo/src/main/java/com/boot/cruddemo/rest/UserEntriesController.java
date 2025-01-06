package com.boot.cruddemo.rest;


import com.boot.cruddemo.entity.UserEntries;
import com.boot.cruddemo.service.UserEntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/userEntries")
public class UserEntriesController {
    @Autowired
    private UserEntriesService userEntriesService;

    //endpoint to get text
    @PostMapping
    public ResponseEntity<UserEntries> saveText(@RequestBody String content) {
        UserEntries userEntries = userEntriesService.saveUserEntries(content);
        return ResponseEntity.ok(userEntries);
    }
    // Endpoint to get text by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserEntries> getText(@PathVariable Long id) {
        return userEntriesService.getUserEntries(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    // Endpoint to update text by ID
    @PutMapping("/{id}")
    public ResponseEntity<UserEntries> updateText(@PathVariable Long id, @RequestBody String content) {
        UserEntries updatedUserEntries = userEntriesService.updateText(id, content);
        return updatedUserEntries != null ? ResponseEntity.ok(updatedUserEntries) : ResponseEntity.notFound().build();
    }
    // Endpoint to delete text by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserEntries(@PathVariable Long id) {
        userEntriesService.deleteUserEntries(id);
        return ResponseEntity.noContent().build();
    }

}
