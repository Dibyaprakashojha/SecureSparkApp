package com.acxtech.securesparkapp.controller;


import com.acxtech.securesparkapp.service.StorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/image")
@CrossOrigin("*")
public class StorageController {

    @Autowired
    private StorageServiceImpl service;

    @PostMapping("/fileSystem")
    public ResponseEntity<?> uploadImageToFIleSystem(@RequestParam("image") MultipartFile file) throws IOException {
        String uploadImage = service.uploadImageToFileSystem(file);
        return ResponseEntity.ok()
                .body(uploadImage);
    }

    @GetMapping("/fileSystem/{fileName}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable String fileName) throws IOException {
        byte[] imageData=service.downloadImageFromFileSystem(fileName);
        return ResponseEntity.ok()
                .contentType(MediaType.valueOf("image/png"))
                .contentType(MediaType.valueOf("application/pdf"))
                .body(imageData);

    }
}
