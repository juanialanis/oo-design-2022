package facade.bandpractice;

public class BandPracticeGarageFacade {

       Amplifier amp;
       Light lights;
       CeilingFan fan;

       public BandPracticeGarageFacade(Amplifier amp, Light lights, CeilingFan fan) {
              this.amp = amp;
              this.lights = lights;
              this.fan = fan;
       }

       public void startPractice() {
              System.out.println("Get ready to start practicing...");
              lights.on();
              fan.high();
              amp.on();
              amp.setVolume(75);
       }

       public void endPractice() {
              System.out.println("Wrapping up the practice...");
              amp.off();
              fan.off();
              lights.off();
       }
}
