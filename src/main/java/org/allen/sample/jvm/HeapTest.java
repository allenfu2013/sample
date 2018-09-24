package org.allen.sample.jvm;

import java.util.ArrayList;
import java.util.List;

public class HeapTest {

    static class OOMObject {
        public byte[] placeholder = new byte[64*1024];
    }

    public static void main(String[] args) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            Thread.sleep(50);
            System.out.println("add obj " + i);
            list.add(new OOMObject());
        }
        System.gc();
    }
}
