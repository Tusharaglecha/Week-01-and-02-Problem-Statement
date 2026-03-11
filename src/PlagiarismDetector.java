import java.util.*;

public class PlagiarismDetector {
    private Map<String, Set<String>> ngramMap = new HashMap<>();

    public void addDocument(String docId, String content) {
        String[] words = content.split("\\s+");
        for (int i = 0; i <= words.length - 5; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 5; j++) sb.append(words[i + j]).append(" ");
            ngramMap.computeIfAbsent(sb.toString().trim(), k -> new HashSet<>()).add(docId);
        }
    }
}
