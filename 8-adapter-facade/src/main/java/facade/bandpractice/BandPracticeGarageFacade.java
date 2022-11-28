package facade.bandpractice;

public class BandPracticeGarageFacade {

       private Amplifier amp;
       private Light lights;
       private CeilingFan fan;

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

       public Amplifier getAmp() {
              return this.amp;
       }

       public Light getLight() {
              return this.lights;
       }

       public CeilingFan getFan() {
              return this.fan;
       }
}
