import java.util.Scanner;

public class ClockAngleCalculator {

    public static void main(String[] args) {
        final int MINUTE_HAND_ANGLE = 6;    //angle change per minute (360/60mins)
        final int HOUR_HAND_ANGLE = 30;     //angle change per hour  (360/12hrs)
        final float HOUR_HAND_PER_MINUTE_ANGLE = 0.5f; //angle change per unit of hour hand (30/60mins)
        final int CIRCLE_ANGLE = 360;
        Scanner kbd = new Scanner(System.in);
        int hour = 0;
        int min = 0;

        boolean isInputValid = false;
        System.out.println("\nThis application calculate lesser angle in degrees between hours hand and minutes hand");
        while (true) {
            while (!isInputValid) {
                System.out.print("\nEnter the time (e.g. 10:11): ");
                try {
                    String[] time = kbd.nextLine().split(":", 2);
                    hour = Integer.parseInt(time[0]);
                    min = Integer.parseInt(time[1]);
                    isInputValid = true;
                } catch (Exception e) {
                    System.out.println("Please enter a valid time\n");
                }
            }

            float hrsAngle = HOUR_HAND_ANGLE * hour + HOUR_HAND_PER_MINUTE_ANGLE * min;
            float minsAngle = MINUTE_HAND_ANGLE * min;

            float firstAngle = hrsAngle - minsAngle;
            float secondAngle = CIRCLE_ANGLE - firstAngle;

            if (firstAngle < secondAngle) {
                System.out.println("The angle between the hour and minute hand is " + firstAngle + "°");
            } else {
                System.out.println("The angle between the hour and minute hand is " + secondAngle + "°");

            }
            System.out.print("\nEnter a new time? (y/n): ");
            String i = kbd.nextLine();
            while (!i.equalsIgnoreCase("y") && !i.equalsIgnoreCase("n")) {
                System.out.print("\nEnter a new time? (y/n): ");
                i = kbd.nextLine();
            }
            if (i.equalsIgnoreCase("n")) {
                kbd.close();
                System.exit(0);
            }
            isInputValid = false;
        }
    }
}

