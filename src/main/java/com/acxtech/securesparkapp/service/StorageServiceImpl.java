package com.acxtech.securesparkapp.service;

import com.acxtech.securesparkapp.model.FileData;
import com.acxtech.securesparkapp.repository.FileDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Optional;

@Service
public class StorageServiceImpl implements StorageService{

    @Autowired
    private FileDataRepository fileDataRepository;

    private final String FOLDER_PATH="C://MyFiles/";

    @Override
    public String uploadImageToFileSystem(MultipartFile file) throws IOException {
        String filePath=FOLDER_PATH+file.getOriginalFilename();

        FileData fileData = fileDataRepository.save(FileData.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .filePath(filePath).build());

        file.transferTo(new File(filePath));

        if (fileData != null) {
            return String.valueOf(fileData.getFileId());
        }
        return null;
    }

    @Override
    public byte[] downloadImageFromFileSystem(String fileName) throws IOException {
        Optional<FileData> fileData = fileDataRepository.findByName(fileName);
        String filePath=fileData.get().getFilePath();
        return Files.readAllBytes(new File(filePath).toPath());
    }
}
