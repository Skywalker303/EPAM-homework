package com.company;

import java.io.*;

public class FileWorker {
    public FileWorker() throws FileNotFoundException {}

    public static void write(byte[] bytes) throws IOException {
        FileOutputStream stream = new FileOutputStream("C:\\Users\\norri\\IdeaProjects\\Mod4\\Exc1\\KWords.txt");
        try {
            stream.write(bytes);
        } finally {
            stream.close();
        }
    }

    public static byte[] read(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[32768];
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        while (true){
            int readBytesCount = inputStream.read(buffer);
            if (readBytesCount == -1) {
                break;
            }
            if (readBytesCount > 0) {
                baos.write(buffer, 0, readBytesCount);
            }
        }
        baos.flush();
        baos.close();
        return baos.toByteArray();
    }
}
