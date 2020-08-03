package com;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class YTD
{
    public static void main(String[] args) throws IOException
    {
        String link = "https://www.urdupoint.com/islam/download-quran.php?id=2&type=urdu";
        URL url=new URL(link);
        int count=-1; //this is for counter
        int offset=0;
        BufferedInputStream bufferedInputStream=new BufferedInputStream(url.openStream());
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\test.mp3");
        byte data[] = new byte[1024];
        while( ((count=bufferedInputStream.read(data,0,1024))!=-1) )
        {
            fileOutputStream.write(data,0, count);
        }
        bufferedInputStream.close();
        fileOutputStream.close();
        System.out.println("File has download");
    }
}
