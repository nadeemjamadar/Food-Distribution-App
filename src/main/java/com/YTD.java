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
        String credentialsToEncode = "acc_7fdb8d4160abe4e" + ":" + "33d152abb1b8ee9b95bec94b46fa8956";
        String basicAuth = Base64.getEncoder().encodeToString(credentialsToEncode.getBytes(StandardCharsets.UTF_8));

        String endpoint_url = "https://api.imagga.com/v2/tags";
        String image_url = "https://raw.githubusercontent.com/MuzammalHussain6313/muzammal-ionic/master/assets/download.jpg";

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
