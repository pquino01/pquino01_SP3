package worksheet_solid;

/**
 *
 * @author pablo
 */
public interface HazardSensor extends Sensor, SensorWithBattery {

   /**
    * Returns true/false for whether the sensor is triggered or not.
    *
    * @return true/false sensor triggered
    */
   Boolean isTriggered();
   
   /**
    * Returns a description of the location of the sensor.
    *
    * @return description of sensor location
    */
   String getLocation();
   
   /**
    * returns a textual description of the sensor type such as
    * "Fire sensor" or "Smoke sensor".
    *
    * @return description of sensor type
    */
   String getSensorType();
   
   /**
    * Returns a number between 0-100 where 0 is empty and
    * 100 is fully charged.
    *
    * @return battery range
    */
   int getBatteryPercentage();

}
