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
public interface SensorWithBattery extends Sensor {
    
    /**
    * Returns a number between 0-100 where 0 is empty and
    * 100 is fully charged.
    *
    * @return battery range
    */
   int getBatteryPercentage();
    
}
