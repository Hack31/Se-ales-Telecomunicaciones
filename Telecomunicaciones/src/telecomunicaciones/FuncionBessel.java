
package telecomunicaciones;
import cern.jet.math.Bessel;

public class FuncionBessel {
    private double m; //indice de modulacion
    private int n; //numero de bandas laterales significativas
    private double Ap; //amplitud de la portadora para el calculo de los voltajes
    private double anchoBessel;
    private double anchoCarson;
    
    public FuncionBessel() { //constructor sin parametros
    }
        
    public FuncionBessel(double m, double Ap){
        this.m = m;
        this.Ap = Ap;  
    }
    
    public int ConjuntoBandasLateralesSignificativas() { //Calcula las baandas laterales significativas de bessel
        int cont = -1;
        double bessel;

        for (int i = 0; i <= 16; i++) { //Calcula las n bandas laterales significativas
            bessel = Bessel.jn(i, m);
            
            if (bessel > -1 && bessel <= -0.01) { //compruebo que el resultado de bessel no sea 
                bessel = bessel * -1;               //negativo de lo contrario lo multiplico por -1 
            }                                   //para volverlo positivo
            if (bessel >= 0.01) {  
                cont++;
            } else {
                break;
            }
        }
        this.n = cont;
        return cont; //retorna la cantidad de bandas laterales significativas
    }

    public double[] amplitudes() { 
        double[] voltajes = new double[n+1];
        double bessel;

        for (int i = 0; i <= 16; i++) {
            bessel = Bessel.jn(i, m);

            if (bessel > -1 && bessel <= -0.01) {
                bessel = bessel * -1;
            }
            if (bessel >= 0.01) {
                voltajes[i] = (Math.rint(bessel * 100) / 100) * Ap;//rint para redondear el double a 2 digitos
            } else {
                break;
            }
        }
        return voltajes;
    }
    
    public double anchoBandaBessel(double fm){
     anchoBessel = 2 * (n * fm);    
     return anchoBessel;   
    }
    
    public double anchoBandaCarson(double desviacionF, double fm){
     anchoCarson = 2 * (desviacionF + fm);
     return anchoCarson;   
    }
}
