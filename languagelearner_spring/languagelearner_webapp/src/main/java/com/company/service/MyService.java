package com.company.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @PreAuthorize("hasRole('ADMIN')")
    public void foo(){
        System.out.println("foo called");
    }
}
