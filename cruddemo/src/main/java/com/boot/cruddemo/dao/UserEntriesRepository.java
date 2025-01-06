package com.boot.cruddemo.dao;

import com.boot.cruddemo.entity.UserEntries;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface UserEntriesRepository extends JpaRepository<UserEntries, Long> {

    //we can add costum query method if needed
}
