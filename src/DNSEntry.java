import java.util.*;

class DNSEntry {
    String ip;
    long expiryTime;
    DNSEntry(String ip, long ttlSeconds) {
        this.ip = ip;
        this.expiryTime = System.currentTimeMillis() + (ttlSeconds * 1000);
    }
}

public class DNSCache {
    private Map<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {
        DNSEntry entry = cache.get(domain);
        if (entry == null || System.currentTimeMillis() > entry.expiryTime) {
            cache.remove(domain);
            return "Cache MISS or EXPIRED";
        }
        return entry.ip;
    }
}
