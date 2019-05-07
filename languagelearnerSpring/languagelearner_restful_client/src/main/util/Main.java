package util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Main {

    private static final Map<byte[], byte[]> cache = new ConcurrentHashMap<>();

    public static byte[] generate(byte[] src) {
        byte[] generated = cache.get(src);
        if (generated == null) {
           generated = doGenerate(src);
           cache.put(src, generated);
        }
        return generated;
    }

    private static byte[] doGenerate(byte[] src) {
        return null;
    }
}
