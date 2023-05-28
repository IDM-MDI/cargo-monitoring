package by.ishangulyyev.desktop.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Optional;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@UtilityClass
public class IPUtil {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 255;
    private static final int CONNECTION_TIMEOUT = 500;
    private static final int THREAD_POOL_SIZE = 10;

    public static Optional<String> findIP(int port) {
        String baseIpAddress = "192.168.0.";
        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = START_RANGE; i <= END_RANGE; i++) {
            String ipAddress = baseIpAddress + i;
            completionService.submit(() -> {
                try(Socket socket = new Socket()) {
                    socket.connect(new InetSocketAddress(ipAddress, port), CONNECTION_TIMEOUT);
                    return ipAddress;
                } catch (IOException ignored) {
                    return null;
                }
            });
        }
        executorService.shutdown();
        for (int i = 0; i < END_RANGE - START_RANGE + 1; i++) {
            try {
                Future<String> future = completionService.take();
                String ipAddress = future.get();
                if (ipAddress != null) {
                    executorService.shutdownNow();
                    return Optional.of(ipAddress);
                }
            } catch (Exception ignored) {
                return Optional.empty();
            }
        }
        return Optional.empty();
    }
}