package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.FileData;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface StorageService {
    String uploadImageToFileSystem(MultipartFile file) throws IOException;
    byte[] downloadImageFromFileSystem(String fileName) throws IOException;
}
