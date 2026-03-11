public class ParkingLot {
    private String[] spots = new String[500];

    public int parkVehicle(String plate) {
        int hash = Math.abs(plate.hashCode() % 500);
        int originalHash = hash;
        while (spots[hash] != null) {
            hash = (hash + 1) % 500;
            if (hash == originalHash) return -1; // Full
        }
        spots[hash] = plate;
        return hash;
    }
}

