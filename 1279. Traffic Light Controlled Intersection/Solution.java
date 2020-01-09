/**
 * Runtime: 37 ms, faster than 91.90% of Java online submissions for Traffic Light Controlled Intersection.
 * Memory Usage: 36.8 MB, less than 100.00% of Java online submissions for Traffic Light Controlled Intersection.
 */
class TrafficLight {
    private int greenLightRoad;
    public TrafficLight() {
        this.greenLightRoad = 1;
    }

    public void carArrived(
            int carId,           // ID of the car
            int roadId,          // ID of the road the car travels on. Can be 1 (road A) or 2 (road B)
            int direction,       // Direction of the car
            Runnable turnGreen,  // Use turnGreen.run() to turn light to green on current road
            Runnable crossCar    // Use crossCar.run() to make car cross the intersection
    ) {
        synchronized (this) {
            if (this.greenLightRoad != roadId) {
                turnGreen.run();
                this.greenLightRoad = roadId;
            }
            crossCar.run();
        }
    }
}

