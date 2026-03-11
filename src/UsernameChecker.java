public class UsernameChecker {
    private Map<String, String> users = new HashMap<>();
    private Map<String, Integer> attempts = new HashMap<>();

    public boolean checkAvailability(String username) {
        attempts.put(username, attempts.getOrDefault(username, 0) + 1);
        return !users.containsKey(username);
    }

    public List<String> suggestAlternatives(String username) {
        return Arrays.asList(username + "1", username + "2", username + ".doe");
    }

    public String getMostAttempted() {
        if (attempts.isEmpty()) return null;
        return Collections.max(attempts.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
