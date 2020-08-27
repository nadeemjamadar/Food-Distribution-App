package com.fypRest.Controller;

import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;

@RestController
@RequestMapping("/uploadImage")
public class UploadController {

    @CrossOrigin
    @PostMapping("/picture")
    public boolean pictureUpload(@RequestParam("file") MultipartFile file) {

        return false;
//        System.out.println(file.getName());
//        System.out.println(file.getOriginalFilename());
//        System.out.println(file.getSize());
//
//        try {
//            Path downloadedFile = Paths.get(file.getOriginalFilename());
//            Files.deleteIfExists(downloadedFile);
//
//            Files.copy(file.getInputStream(), downloadedFile);
//
//            return true;
//        }
//        catch (IOException e) {
//            LoggerFactory.getLogger(this.getClass()).error("pictureupload", e);
//            return false;
//        }

    }


    @PostMapping("/uploadPicture")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException
    {
        return null;
//
//        System.out.println("file: " + file.getOriginalFilename());
////        String path = System.getProperty("user.dir")+ "\\assets\\" + file.getOriginalFilename();
//
////        System.out.println(path);
//
////        file.transferTo(new File(path));
//
//
//
////        String credentialsToEncode = "acc_7fdb8d4160abe4e" + ":" + "33d152abb1b8ee9b95bec94b46fa8956";
////        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));
////
////        String endpoint_url = "https://api.imagga.com/v2/tags";
//////        String image_url = "https://raw.githubusercontent.com/MuzammalHussain6313/muzammal-ionic/master/assets/food.png";
////        String image_url = "https://food-distribution-app.herokuapp.com/upload/downloadPicture/" + file.getOriginalFilename();
////
////        String url = endpoint_url + "?image_url=" + image_url;
////        URL urlObject = new URL(url);
////        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
////
////        connection.setRequestProperty("Authorization", "Basic " + basicAuth);
////
////        int responseCode = connection.getResponseCode();
////
////        System.out.println("\nSending 'GET' request to URL : " + url);
////        System.out.println("Response Code : " + responseCode);
////
////        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));
////
////        String jsonResponse = connectionInput.readLine();
////        connectionInput.close();
////        System.out.println(jsonResponse);
////        return jsonResponse;
//
//        return null;
    }

    @GetMapping(value = "/downloadPicture/{file}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getImage(@PathVariable("file") String file) throws IOException {

        System.out.println("file: " + file);
        String path = System.getProperty("user.dir")+ "\\assets\\" + file;
        System.out.println("path : " + path);
        File file1 = new File(path);
        BufferedImage image = ImageIO.read(file1);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "jpg", baos);
        byte[] bytes = baos.toByteArray();

        return ResponseEntity
                .ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(bytes);
    }
}