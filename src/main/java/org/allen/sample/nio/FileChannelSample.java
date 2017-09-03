package org.allen.sample.nio;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class FileChannelSample {

    public static void main(String[] args) throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("nio-data.txt", "rw");
        FileChannel inChannel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        // 读取数据到buffer
        int bytesRead = inChannel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read: " + bytesRead);
            // 将Buffer从写模式切换到读模式
            buf.flip();
            while (buf.hasRemaining()) {
                // 一次读取一个byte
                System.out.println((char) buf.get());
            }
            // 清空buffer
            buf.clear();
            bytesRead = inChannel.read(buf);
        }
        aFile.close();
    }
}
