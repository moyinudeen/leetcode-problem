class ParkingSystem {
    // Array to store the capacity of big, medium, and small slots
    // Index 0 = big (carType 1), Index 1 = medium (carType 2), Index 2 = small (carType 3)
    private int[] count;

    public ParkingSystem(int big, int medium, int small) {
        this.count = new int[]{big, medium, small};
    }
    
    public boolean addCar(int carType) {
        // carType is 1-indexed, so map it to 0-indexed array by subtracting 1
        if (count[carType - 1] > 0) {
            count[carType - 1]--;
            return true;
        }
        return false;
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */
