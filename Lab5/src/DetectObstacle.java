package example.code;

import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3UltrasonicSensor;
import lejos.robotics.subsumption.Behavior;

/**
 * A behaviour which allows the GELway to avoid obstacles using the Ultrasonic Sensor.
 * 
 * @author Steven Jan Witzand
 * @version August 2009
 */
public class DetectObstacle implements Behavior
{
   CtrlParam ctrl = new CtrlParam();
   MotorDirection mv;
   EV3UltrasonicSensor us = new EV3UltrasonicSensor(SensorPort.S1);

   /**
    * DetectObstacle constructor.
    * 
    * @param ctrl
    *           The motor control parameters.
    */
   public DetectObstacle(CtrlParam ctrl)
   {
      this.ctrl = ctrl;
      mv = new MotorDirection(ctrl);
      
      /** get an instance of this sensor in measurement mode
		SampleProvider distance= sensor.getMode("Distance");
		
		// initialize an array of floats for fetching samples. 
		// Ask the SampleProvider how long the array should be
		float[] sample = new float[distance.sampleSize()];
		
		// fetch a sample
		while(true) 
		  distance.fetchSample(sample, 0);*/
   }

   /**
    * Trigger for the Behaviour. This trigger is actioned when a distance less than 25cm is
    * detected.
    */
   public boolean takeControl()
   {
//      return (us.getDistance() < 25);
	   return false;
   }

   /**
    * No suppression required.
    */
   public void suppress()
   {
   }

   /**
    * Action method which stops the robots current movements, reverses the robot and turns
    * 180 degrees.
    */
   public void action()
   {
      ctrl.setLeftMotorOffset(0);
      ctrl.setRightMotorOffset(0);
      ctrl.setDriveState(0);
      mv.backward(200);
      mv.right(1800);
      mv.stop(1000);
      mv.backward(100);
   }

}
