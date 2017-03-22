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
public class MotionSensor implements SecuritySensor {

    @Override
    public Boolean isTriggered() {
        return false;
    }

    @Override
    public String getLocation() {
        return null;
    }

    @Override
    public String getSensorType() {
        return "Motion sensor";
    }
    
}
