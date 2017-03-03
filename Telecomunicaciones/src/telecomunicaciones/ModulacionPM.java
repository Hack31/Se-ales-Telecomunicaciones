package telecomunicaciones;

public class ModulacionPM extends ModulacionAngular{
  private final double m;
  private final double Ap;
  private static double fm;
  private double vc; 
  private double vm;
  private double PM;
  private String TipoSeñalModuladora;
  private String TipoSeñalPortadora;
  private static final double pi = Math.PI;
    
    public ModulacionPM(double fm, double fc, double vc, double vm, double m){
        super(fm,fc,vc,vm,m);
        this.Ap = vc;
        this.m = m;
        this.fm = fm;
        this.vm = vm;
    }   
    public void setTipoSeñalModuladora (String TpSeñal) {
        this.TipoSeñalModuladora = TpSeñal;
    }
    public String getTipoSeñalModuladora(){
       return TipoSeñalModuladora; 
    }
    public void setTipoSeñalPortadora(String TpSeñal) {
        this.TipoSeñalPortadora = TpSeñal;
    }
    public String getTipoSeñalPortadora(){
       return TipoSeñalPortadora; 
    }
    
    public double ModularPM(double tiempo){     
        switch (TipoSeñalModuladora) { //Tipo de Señal Moduladora
            case "Cosenoidal": { 
                switch(TipoSeñalPortadora){//Tipo de Señal Portadora
                    case "Cosenoidal":{
                      PM = Ap * Math.cos(FrecuenciaAngularPortadora() * tiempo + m * Math.cos(FrecuenciaAngularModulante() * tiempo));
                      break;
                    }
                    case "Senoidal":{
                       PM = Ap * Math.sin(FrecuenciaAngularPortadora() * tiempo + m * Math.cos(FrecuenciaAngularModulante() * tiempo));
                      break;  
                    }
                    case "Diente de Sierra": {
                        PM = -(2 * Ap / pi) * Math.atan(1 / Math.tan(FrecuenciaAngularPortadora()*tiempo + m * Math.cos(FrecuenciaAngularModulante() * tiempo)));
                        break;
                    }
                    case "Triangular": {
                        PM = (2*Ap/pi)*Math.asin(Math.sin(FrecuenciaAngularPortadora()*tiempo+m*Math.cos(FrecuenciaAngularModulante()*tiempo)));
                        break;
                    }
                }
                 break;
            }
            case "Senoidal": { //Tipo de Señal Moduladora
                switch(TipoSeñalPortadora){//Tipo de Señal Portadora
                    case "Cosenoidal":{
                      PM = Ap * Math.cos(FrecuenciaAngularPortadora() * tiempo + m * Math.sin(FrecuenciaAngularModulante() * tiempo));
                      break;
                    }
                    case "Senoidal":{
                       PM = Ap * Math.sin(FrecuenciaAngularPortadora() * tiempo + m * Math.sin(FrecuenciaAngularModulante() * tiempo));
                      break;  
                    }
                    case "Diente de Sierra": {
                        PM = -(2 * Ap / pi) * Math.atan(1 / Math.tan(FrecuenciaAngularPortadora()*tiempo + m * Math.sin(FrecuenciaAngularModulante() * tiempo)));
                        break;
                    }
                    case "Triangular": {
                        PM = (2 * Ap / pi) * Math.asin(Math.sin(FrecuenciaAngularPortadora() * tiempo + m * Math.sin(FrecuenciaAngularModulante() * tiempo)));
                        break;
                    }
                }
               break;
            }
            case "Diente de Sierra": {//Tipo de Señal Moduladora
                switch (TipoSeñalPortadora) {//Tipo de Señal Portadora
                    case "Cosenoidal": {
                        PM = Ap * Math.cos(FrecuenciaAngularPortadora() * tiempo - m *(2*vm/pi)*Math.atan(1/Math.tan(tiempo*pi*fm)));
                        break;
                    }
                    case "Senoidal": {
                        PM = Ap * Math.sin(FrecuenciaAngularPortadora() * tiempo - m *(2*vm/pi)*Math.atan(1/Math.tan(tiempo*pi*fm)));
                        break;
                    }
                    case "Diente de Sierra": {
                        PM = -(2 * Ap / pi) * Math.atan(1 / Math.tan(FrecuenciaAngularPortadora() * tiempo - m *(2*vm/pi)*Math.atan(1/Math.tan(tiempo*pi*fm))));
                        break;
                    }
                    case "Triangular": {
                        PM = (2 * Ap / pi) * Math.asin(Math.sin(FrecuenciaAngularPortadora() * tiempo - m *(2*vm/pi)*Math.atan(1/Math.tan(tiempo*pi*fm))));
                        break;
                    }
                }
                break;
            }
            case "Triangular": {//Tipo de Señal Moduladora
                switch (TipoSeñalPortadora) {//Tipo de Señal Portadora
                    case "Cosenoidal": {
                        PM = Ap * Math.cos(FrecuenciaAngularPortadora() * tiempo + m *(2*vm/pi)*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo)));
                        break;
                    }
                    case "Senoidal": {
                        PM = Ap * Math.sin(FrecuenciaAngularPortadora() * tiempo + m *(2*vm/pi)*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo)));
                        break;
                    }
                    case "Diente de Sierra": {
                        PM = -(2 * Ap / pi) * Math.atan(1 / Math.tan(FrecuenciaAngularPortadora() * tiempo + m *(2*vm/pi)*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo))));
                        break;
                    }
                    case "Triangular": {
                        PM = (2 * Ap / pi) * Math.asin(Math.sin(FrecuenciaAngularPortadora() * tiempo + m *(2*vm/pi)*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo))));
                        break;
                    }
                }
              break;
            }
        }
        return PM;
    }
}
