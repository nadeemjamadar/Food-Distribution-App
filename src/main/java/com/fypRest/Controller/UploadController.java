package com.fypRest.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @CrossOrigin
    @PostMapping("/picture")
    public boolean pictureUpload(@RequestParam("file") MultipartFile file) {

        System.out.println(file.getName());
        System.out.println(file.getOriginalFilename());
        System.out.println(file.getSize());

        try {
            Path downloadedFile = Paths.get(file.getOriginalFilename());
            Files.deleteIfExists(downloadedFile);

            Files.copy(file.getInputStream(), downloadedFile);

            return true;
        }
        catch (IOException e) {
            LoggerFactory.getLogger(this.getClass()).error("pictureupload", e);
            return false;
        }

    }
}