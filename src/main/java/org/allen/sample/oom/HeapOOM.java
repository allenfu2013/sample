package org.allen.sample.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. java -Xms20m -Xmx20m -Xmn10m -XX:+HeapDumpOnOutOfMemoryError HeapOOM
 * 2. jhat <heap-dump-file>
 * 3. 浏览器打开localhost:7000
 *
 * Memory Leak or Memory Overflow
 *
 * Eclipse Memory Analyzer
 */
public class HeapOOM {

    static class OOMObject {
        private byte[] bytes = new byte[1024];
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
