import java.util.Random;

class SmartHealthTracker {

    int steps;
    double caloriesBurned;
    double waterLevel;

    SmartHealthTracker() {
        autoTrackSteps();
        calculateCalories();
        calculateWaterLevel();
    }

    void autoTrackSteps() {
        Random r = new Random();
        steps = 3000 + r.nextInt(9000); // 3000–12000 steps
    }

    void calculateCalories() {
        caloriesBurned = steps * 0.04; // approx calories per step
    }

    void calculateWaterLevel() {
        if (steps < 5000)
            waterLevel = 1.8;
        else if (steps < 10000)
            waterLevel = 2.5;
        else
            waterLevel = 3.2;
    }

    String activityStatus() {
        if (steps < 5000)
            return "Low Activity";
        else if (steps < 10000)
            return "Moderate Activity";
        else
            return "High Activity";
    }

    String hydrationStatus() {
        if (waterLevel < 2)
            return "Dehydrated";
        else
            return "Well Hydrated";
    }

    void displayReport() {
        System.out.println("===== SMART HEALTH TRACKER REPORT =====");
        System.out.println("Steps Walked Today     : " + steps);
        System.out.printf("Calories Burned        : %.2f kcal%n", caloriesBurned);
        System.out.printf("Water Level in Body    : %.1f liters%n", waterLevel);
        System.out.println("Activity Status        : " + activityStatus());
        System.out.println("Hydration Status       : " + hydrationStatus());
        System.out.println("======================================");
    }
}

public class HealthTrackerApp {
    public static void main(String[] args) {

        SmartHealthTracker tracker = new SmartHealthTracker();
        tracker.displayReport();

        System.out.println("\nHealth tracking completed automatically!");
    }
}
