
import java.util.*;

public class VideoCacheSystem {
    private Map<String, String> l1 = new LinkedHashMap<>(100, 0.75f, true) {
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > 10000;
        }
    };
    private Map<String, String> l2 = new HashMap<>();

    public String getVideo(String videoId) {
        if (l1.containsKey(videoId)) return l1.get(videoId);
        if (l2.containsKey(videoId)) {
            String data = l2.get(videoId);
            l1.put(videoId, data);
            return data;
        }
        return "Fetch from Database";
    }
}

