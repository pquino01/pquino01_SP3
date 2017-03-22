/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worksheet_solid;

import java.util.List;
import java.util.Random;

/**
 *
 * @author pablo
 */
public class SecurityControlUnit extends ControlUnit{
    
    private int randomTime;
    
    public SecurityControlUnit(List<Sensor> sensors) {
        super(sensors);
        Random rn = new Random();
        this.randomTime = rn.nextInt(24) + 1;
        if (randomTime<6 || randomTime>=22){
            super.pollSensors();
        }
    }
    
}
