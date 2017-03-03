
package telecomunicaciones;


public class Formulas {
  private double fm, m, vm, k;
  
    public Formulas(double fm, double vm,double m, double k){ //Constructor para FM
        this.fm = fm;
        this.vm = vm;
        this.m = m;
        this.k = k;
    }
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public double kFM() { //sensibilidad de la desviacion (kl)
        return ((fm * m) / vm);
    }
    //////////////////////FM-FM-FM-FM///////////////////////////
    public double DesviacionFrecuencia() { //delta f
        if(k!=0 && vm!=0){
            return k * vm;
        }else{
            if(k==0 && vm!=0){
              return (kFM() * vm);  
            }
            if(k!=0 && vm==0){
              return k * vmFM();
            }else{
               return kFM() * vmFM(); 
            }
        }  
    }
    public double mFM() { //Indice de modulacion (m)
        return ((k * vm) / fm);
    }
    public double vmFM(){ //amplitud moduladora (vm)
        if(fm!=0 && m!=0 && k!=0){
            return (fm * m) / k;
        }else{
            if(fm==0 && m!=0 && k!=0){
               return (fFM()*m)/k;
            }
            if(fm==0 && m!=0 && k==0){
               return (fFM()*m)/kFM(); 
            }
            if(fm!=0 && m!=0 && k==0){
                System.out.println("Faltan datos kl");
               return ((fm * m) / kFM());
            }
        }
        return 0.0;
    }
    public double fFM(){ //frecuencia moduladora (fm)
        return (DesviacionFrecuencia() / m);
    }
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////
    public double kPM() {//sensibilidad a la desviacion (k) PM
        return ((k * vm) / vm);
    }
    //////////////////////PM-PM-PM-PM///////////////////////////    
    public double mPM() {//Desviacion de fase (m)
        return (k * vm);
    }
    public  double vmPM(){//amplitud moduladora (vm)
        if(m!=0 && k!=0){
          return (m / k);  
        }else{
           if(m!=0 && k==0){
             return m / kPM();
           }
           if(m==0 && k!=0){
             return mPM() / k;
           }else{
            return (mPM() / kPM());   
           }
        }
    }
    
////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////

   
    
}
