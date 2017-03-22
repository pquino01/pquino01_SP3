/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet_solid;

/**
 *
 * @author pablo
 */
public interface SecuritySensor extends Sensor {
    
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
    
}
