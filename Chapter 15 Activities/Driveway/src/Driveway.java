import java.util.Stack;

/**
 * Class for simulating a driveway and a street, using stacks
 * of cars with license plate numbers as representation.
 */
public class Driveway {
    /**
     * Stack representing the cars in the driveway.
     */
    private Stack<Integer> driveway;
    /**
     * Stack representing the cars in the street.
     */
    private Stack<Integer> street;

    /**
     * Constructor.
     */
    public Driveway() {
        // Complete the constructor
        driveway = new Stack<>();
        street = new Stack<>();
    }

    /**
     * Add the given license plate to the driveway.
     *
     * @param licensePlate number of license plate.
     */
    public void add(int licensePlate) {
        // Complete this method
        // Check for duplicates before adding
        if (!driveway.contains(licensePlate)) {
            System.out.println("Adding car " + licensePlate);
            driveway.push(licensePlate);
        } else {
            System.out.println("Car " + licensePlate + " is already in the driveway.");
        }
    }

    /**
     * Remove the given license plate from the driveway.
     *
     * @param licensePlate number of license plate.
     */
    public void remove(int licensePlate) {
        // Complete this method
        // First, check if the car is even in the driveway.
        if (!driveway.contains(licensePlate)) {
            System.out.println("Car " + licensePlate + " is not in the driveway.");
            return;
        }

        System.out.println("Removing car " + licensePlate);

        // Move cars from the driveway to the street until the desired car is at the top.
        while (!driveway.isEmpty() && driveway.peek() != licensePlate) {
            int movedCar = driveway.pop();
            street.push(movedCar);
        }

        // If the car was found, pop it from the driveway to remove it.
        if (!driveway.isEmpty()) {
            driveway.pop();
        }

        // Move all cars from the street back to the driveway.
        while (!street.isEmpty()) {
            int movedCar = street.pop();
            driveway.push(movedCar);
        }
    }

    /**
     * Prints the driveway and street details to the screen.
     */
    public void print() {
        System.out.println("\nIn Driveway, starting at first in (one license plate per line):");
        // Print the cars in the driveway here
        // The enhanced for-loop iterates from the bottom of the stack to the top.
        for (Integer licensePlate : driveway) {
            System.out.println(licensePlate);
        }

        System.out.println("\nIn Street, starting at first in (one license plate per line):");
        // Print the cars in the street here
        if (street.isEmpty()) {
             System.out.println("The street is empty.");
        } else {
            for (Integer licensePlate : street) {
                System.out.println(licensePlate);
            }
        }
    }
}
