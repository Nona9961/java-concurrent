package com.nona;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.*;

public class ConcurrentTest {


    private ExecutorService pools;

    @BeforeEach
    public void before() {
        pools = new ThreadPoolExecutor(4, 8,
                0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(128),new ThreadPoolExecutor.CallerRunsPolicy());
    }

    @Test
    void example1() throws InterruptedException {
        Sequence sequence = new Sequence();
        for (int i = 0; i < 10000; i++) {
            pools.execute(sequence);
        }
        TimeUnit.SECONDS.sleep(2);
        System.out.println("Sequence.i = " + Sequence.i);
    }


    private CountDownLatch getLatch(int counts) {
        return new CountDownLatch(counts);
    }

    @Test
    void strLength() throws IOException {
        Path path = Paths.get("C:\\Users\\78679\\Desktop", "8DE32E50-B239-48c6-94C3-E2216FEE42B2.txt");
        System.out.println(Files.exists(path));
        BufferedReader bufferedReader = Files.newBufferedReader(path, StandardCharsets.UTF_16LE);
        String s = bufferedReader.readLine();
        System.out.println(s);
    }
}
