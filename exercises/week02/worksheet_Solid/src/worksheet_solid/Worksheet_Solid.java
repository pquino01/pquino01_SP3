package worksheet_solid;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author pablo
 */
public class Worksheet_Solid {

    private static final String EXIT = "exit";
    private static final String POLL = "poll";

    public static void main(String[] args) throws IOException {
        List<Sensor> hazardSensors = new ArrayList<Sensor>();
        hazardSensors.add(new FireSensor());
        hazardSensors.add(new SmokeSensor());
        ControlUnit controlUnit = new ControlUnit(hazardSensors);
        Scanner scanner = new Scanner(System.in);
        String input = "";
        while (!input.equals(EXIT)) {
            System.out.println("Type \"poll\" to poll all sensors once or \"exit\" to exit");
            input = scanner.nextLine();
            if (input.equals(POLL)) {
                controlUnit.pollSensors();
            }
        }
        List<Sensor> securitySensors = new ArrayList<Sensor>();
        securitySensors.add(new MotionSensor());
        ControlUnit controlUnit2 = new SecurityControlUnit(securitySensors);
    }
}
