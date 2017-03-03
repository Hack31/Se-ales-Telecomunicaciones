package telecomunicaciones;

public class ModulacionAngular {
    private final double fc;
    private static double fm;
    private final double Ap; //Amplitud Portadora
    private final double Am; //Amplitud Moduladora
    private final double m;
    private double vc;
    private double vm;
    private double wc;
    private double wm;
    private static final double pi = Math.PI;
    
    public ModulacionAngular(double fm, double fc, double Ap, double Am, double m) {
      this.fm = fm;
      this.fc = fc;
      this.Ap = Ap;
      this.m = m;
      this.Am = Am;
    }
    
    public double SeñalPortadora(double tiempo, String TpSeñal) {//Calcula la señal Portadora
        switch (TpSeñal) {
            case "Cosenoidal": {
                vc = Ap * Math.cos(wc * tiempo);
                break;
            }
            case "Senoidal": {
                vc = Ap * Math.sin(wc * tiempo);
                break;
            }
            case "Diente de Sierra":{
              vc = -(2*Ap/pi)*Math.atan(1/Math.tan(tiempo*pi*fc));
              break;
            }
            case "Triangular":{
              vc = (2*Ap/pi)*Math.asin(Math.sin(FrecuenciaAngularPortadora()*tiempo));       
              break;
            }
            default:
              System.out.println("Error en Seleccion de Grafica Portadora");  
        }
        return vc;
    }

    public double SeñalModuladora(double tiempo, String TpSeñal) {//Calcula la señal moduladora en base al tiempo y su amplitud
        switch(TpSeñal){
            case "Cosenoidal":{
              vm = Am * Math.cos(wm * tiempo);
              break;
            }
            case "Senoidal":{
              vm = Am * Math.sin(wm * tiempo);
              break;
            }
            case "Diente de Sierra":{
              vm = -(2*Am/pi)*Math.atan(1/Math.tan(tiempo*pi*fm));
              break;
            }
            case "Triangular":{
              vm = (2*Am/pi)*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo));       
              break;
            }
          default:
           System.out.println("Error en Seleccion de Grafica Moduladora");
        }
        return vm;
    }
    
////////////////////////////////////////////////////////////////////////////////    
////////////////////////////////////////////////////////////////////////////////
    public double FrecuenciaAngularPortadora() {
        wc = (2 * pi * fc);
        return wc;
    }
///////////////Frecuencias Angulares Mejor conocidas como Wc y Wm///////////////
    public double FrecuenciaAngularModulante() {
        wm = (2 * pi * fm);
        return wm;
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
}
