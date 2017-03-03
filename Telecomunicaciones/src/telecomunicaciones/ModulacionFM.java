
package telecomunicaciones;

public class ModulacionFM extends ModulacionAngular{
  private double FM;//Señal modulada
  private double kl;
  private double vm;
  private double fm;
  private final double vc;//Amplitud de la portadora
  private final double m;//indice de la modulacion
  private String Tiposeñal;
  private static final double pi = Math.PI;

    public ModulacionFM(double fm, double fc, double vc, double vm, double m) {
        super(fm,fc,vc,vm,m);
        this.vc = vc;
        this.m = m;
        this.vm = vm;
        this.fm = fm;
    }
    
    public void setTipoSeñal(String TpSeñal) {
        this.Tiposeñal = TpSeñal;
    }
    public String getTipoSeñal(){
       return Tiposeñal; 
    }
    public void setSensibilidad(double kl){
       this.kl = kl; 
    }
    public double getSensibilidad(){
      return kl;  
    }
    public double ModularFm(double tiempo) {
        switch(Tiposeñal){
            case "Cosenoidal":{                                          //Integrada
              FM = vc * Math.cos(FrecuenciaAngularPortadora() * tiempo + (kl*vm/fm) * Math.sin(FrecuenciaAngularModulante() * tiempo)); 
              break;
            }
            case "Senoidal":{                                            //Integrada
              FM = vc * Math.cos(FrecuenciaAngularPortadora() * tiempo - (kl*vm/fm)* Math.cos(FrecuenciaAngularModulante() * tiempo));
              break;
            }
            case "Diente de Sierra":{                                    //Integrada la frecuencia de la portadora deber ser alta
              FM = vc * Math.cos(FrecuenciaAngularPortadora() * tiempo - ((kl *vm/2*pi*(fm/2))*(2*tiempo/pi)*((pi*(fm/2)*tiempo)+ Math.atan(1/Math.tan(2*pi*(fm/2)*tiempo)))));
             //2*sin(2*pi*150*x-((20*2)/2*pi*6)*(2*x/pi)*(pi*6*x+atan(cot(2*pi*6*x))))
             //-(2*2/pi)*atan(cot(pi*12*x))-4.2
             //2*cos(2*pi*150*x)+4.2
             
              break;
            }
            case "Triangular":{
              FM = vc * Math.cos(FrecuenciaAngularPortadora() * tiempo +((kl*vm)/FrecuenciaAngularModulante())*(2*vm/pi)*(tiempo*Math.asin(Math.sin(FrecuenciaAngularModulante()*tiempo))-pi*fm*Math.pow(tiempo, 2)*Math.sqrt(Math.pow(Math.cos(FrecuenciaAngularModulante()*tiempo),2))*(1/Math.cos(FrecuenciaAngularModulante()*tiempo))));
            // 2*sin(2*pi*140*x+((20*2)/2*pi*6)*(2*2/pi)*(x*asin(sin(2*pi*6*x))-pi*6*x^(2)*sqrt(cos(2*pi*6*x)^(2))*sec(2*pi*6*x)))
            //(2*2/pi)*asin(sin(2*pi*6*x))-4.2
            //2*cos(2*pi*140*x)+4.2
            break;
            }
          default:
           System.out.println("Creo que haz hecho algo mal Tio");
        }
        return FM;
    }
} 