import java.util.*;

public class AnalyticsDashboard {
    private Map<String, Integer> pageViews = new HashMap<>();
    private Map<String, Set<String>> uniqueUsers = new HashMap<>();
    private Map<String, Integer> sources = new HashMap<>();

    public void processEvent(String url, String userId, String source) {
        pageViews.put(url, pageViews.getOrDefault(url, 0) + 1);
        uniqueUsers.computeIfAbsent(url, k -> new HashSet<>()).add(userId);
        sources.put(source, sources.getOrDefault(source, 0) + 1);
    }
}

