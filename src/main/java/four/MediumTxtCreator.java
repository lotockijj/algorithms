package four;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;

public class MediumTxtCreator {
    private final static String FILE_URL = "https://algs4.cs.princeton.edu/41graph/largeG.txt";
    private final static String FILE_NAME = "largeG.txt";

    public static void main(String[] args) {
        URL url = null;
        try {
            url = new URL(FILE_URL);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        try (ReadableByteChannel readableByteChannel = Channels.newChannel(url.openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME);
             FileChannel fileChannel = fileOutputStream.getChannel()) {
            fileOutputStream.getChannel()
                    .transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Done");
    }
}