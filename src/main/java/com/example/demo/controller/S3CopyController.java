package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.S3CopyService;

@RestController
@RequestMapping("/api/s3")
public class S3CopyController {

    @Autowired
    private S3CopyService s3CopyService;

    @PostMapping("/copy")
    public String copyS3Objects(
            @RequestParam String sourceBucket,
            @RequestParam String destinationBucket) {

        return s3CopyService.copyObjects(sourceBucket, destinationBucket);
    }
    
    @GetMapping("/check")
    public String copyS3ObjectsCheck() {

        return "It is working";
    }
}

