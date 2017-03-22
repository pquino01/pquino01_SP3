package worksheet_solid;

import java.util.Random;




/**
 *
 * @author pablo
 */
public class FireSensor implements HazardSensor {
    
    private int batteryPercentage;
    private int randomTimeAlarm;

    public FireSensor() {
        this.batteryPercentage=100;
        Random rn = new Random();
        this.randomTimeAlarm = rn.nextInt(100) + 1;
    }

    @Override
    public Boolean isTriggered() {
        batteryPercentage-=10;
        return randomTimeAlarm<=5; //5% of the time FireSensor is called, it raises an alarm
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getSensorType() {
        return "Fire sensor";
    }

    @Override
    public int getBatteryPercentage() {
        return batteryPercentage;
    }
    
}
