package worksheet_solid;

import java.util.Random;

/**
 *
 * @author pablo
 */
public class SmokeSensor implements HazardSensor {
    
    private int batteryPercentage;
    private int randomTimeAlarm;

    public SmokeSensor() {
        this.batteryPercentage=100;
        Random rn = new Random();
        this.randomTimeAlarm = rn.nextInt(100) + 1;
    }

    @Override
    public Boolean isTriggered() {
        batteryPercentage-=20;
        return randomTimeAlarm<=10; //10% of the time FireSensor is called, it raises an alarm
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getSensorType() {
        return "Smoke sensor";
    }

    @Override
    public int getBatteryPercentage() {
        return batteryPercentage;
    }
    
}
