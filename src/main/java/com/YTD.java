package com;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class YTD
{
    //    public static void main(String[] args) throws IOException
//    {
//        String link = "https://www.urdupoint.com/islam/download-quran.php?id=2&type=urdu";
//        URL url=new URL(link);
//        int count=-1; //this is for counter
//        int offset=0;
//        BufferedInputStream bufferedInputStream=new BufferedInputStream(url.openStream());
//        FileOutputStream fileOutputStream=new FileOutputStream("D:\\test.mp3");
//        byte data[] = new byte[1024];
//        while( ((count=bufferedInputStream.read(data,0,1024))!=-1) )
//        {
//            fileOutputStream.write(data,0, count);
//        }
//        bufferedInputStream.close();
//        fileOutputStream.close();
//        System.out.println("File has download");
//    }
    public static void main(String[] args) throws IOException
    {
//        String credentialsToEncode = "acc_7fdb8d4160abe4e" + ":" + "33d152abb1b8ee9b95bec94b46fa8956";
//        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));
//
//        // Change the file path here
//        String filepath = System.getProperty("user.dir")+ "\\assets\\20181212_182132.jpg";
//        File fileToUpload = new File(filepath);
//
//        String endpoint = "/categories/personal_photos";
//
//
//        String crlf = "\r\n";
//        String twoHyphens = "--";
//        String boundary =  "Image Upload";
//
//        URL urlObject = new URL("https://api.imagga.com/v2" + endpoint);
//        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
//        connection.setRequestProperty("Authorization", "Basic " + basicAuth);
//        connection.setUseCaches(false);
//        connection.setDoOutput(true);
//
//        connection.setRequestMethod("POST");
//        connection.setRequestProperty("Connection", "Keep-Alive");
//        connection.setRequestProperty("Cache-Control", "no-cache");
//        connection.setRequestProperty(
//                "Content-Type", "multipart/form-data;boundary=" + boundary);
//
//        DataOutputStream request = new DataOutputStream(connection.getOutputStream());
//
//        request.writeBytes(twoHyphens + boundary + crlf);
//        request.writeBytes("Content-Disposition: form-data; name=\"image\";filename=\"" + fileToUpload.getName() + "\"" + crlf);
//        request.writeBytes(crlf);
//
//
//        InputStream inputStream = new FileInputStream(fileToUpload);
//        int bytesRead;
//        byte[] dataBuffer = new byte[1024];
//        while ((bytesRead = inputStream.read(dataBuffer)) != -1) {
//            request.write(dataBuffer, 0, bytesRead);
//        }
//
//        request.writeBytes(crlf);
//        request.writeBytes(twoHyphens + boundary + twoHyphens + crlf);
//        request.flush();
//        request.close();
//
//        InputStream responseStream = new BufferedInputStream(connection.getInputStream());
//
//        BufferedReader responseStreamReader = new BufferedReader(new InputStreamReader(responseStream));
//
//        String line = "";
//        StringBuilder stringBuilder = new StringBuilder();
//
//        while ((line = responseStreamReader.readLine()) != null) {
//            stringBuilder.append(line).append("\n");
//        }
//        responseStreamReader.close();
//
//        String response = stringBuilder.toString();
//        System.out.println(response);
//
//        responseStream.close();
//        connection.disconnect();
//    }

        String credentialsToEncode = "acc_7fdb8d4160abe4e" + ":" + "33d152abb1b8ee9b95bec94b46fa8956";
        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));

        String endpoint_url = "https://api.imagga.com/v2/tags";
//        String image_url = "https://raw.githubusercontent.com/MuzammalHussain6313/muzammal-ionic/master/assets/download.jpg";

//        String image_url = "https://doc-0g-c4-docs.googleusercontent.com/docs/securesc/tjm37ih90dsg6mb2de6990rrd7dmc0e5/f092k1cnu557c7knrr4ipd4t5vqcnve2/1597936200000/09162100626123583969/09162100626123583969/1C1oSh82GFEtOco3pP9llqgfSOYa47MsA?e=download&authuser=0&nonce=t2j61mt6toouq&user=09162100626123583969&hash=pl9cdqhe2hs56bms9plmd206ca3btlpf";
        String image_url = "https://firebasestorage.googleapis.com/v0/b/food-distribution-app-fb350.appspot.com/o/food.png?alt=media&token=23043d43-eae4-4be5-8f03-c39f12096d6e";
        String url = endpoint_url + "?image_url=" + image_url;
        URL urlObject = new URL(url);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();

        connection.setRequestProperty("Authorization", "Basic " + basicAuth);

        int responseCode = connection.getResponseCode();

        System.out.println("\nSending 'GET' request to URL : " + url);
        System.out.println("Response Code : " + responseCode);

        BufferedReader connectionInput = new BufferedReader(new InputStreamReader(connection.getInputStream()));

        String jsonResponse = connectionInput.readLine();

        connectionInput.close();

        System.out.println(jsonResponse);
    }
}
