import java.util.concurrent.*;

class TokenBucket {
    int tokens = 1000;
    long lastRefill = System.currentTimeMillis();
}

public class RateLimiter {
    private Map<String, TokenBucket> clients = new ConcurrentHashMap<>();

    public boolean checkRateLimit(String clientId) {
        TokenBucket bucket = clients.computeIfAbsent(clientId, k -> new TokenBucket());
        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }
        return false;
    }
}
