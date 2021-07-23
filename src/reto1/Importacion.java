/*
 * Solucion a Reto 1 comparacion entre interes simple y compuest
 */
package reto1;

/**
 *
 * @author josea
 */
public class Importacion {
    
    private double interesSimple;
    private double interesCompuesto;
    private double compararInvImportacion;
    private String respuesta;
    
    public String compararInvImportacion(int tiempo, double capital, double interes){
        if (tiempo > 0 && capital > 0 && interes >0){
            interesSimple = capital * interes * tiempo;
            interesCompuesto = capital * ((Math.pow((1+interes),tiempo)) -1) ;
            compararInvImportacion = interesCompuesto - interesSimple;
            respuesta = "La diferencia en el total de intereses generados para "
                    + "el proyecto, si escogemos entre evaluarlo a una tasa de "
                    + "interés Compuesto y evaluarlo a una tasa de interés "
                    + "Simple, asciende a la cifra de: $" 
                    + Double.toString(compararInvImportacion);
        }
        else{
            respuesta = "Faltan datos para calcular la diferencia en el "
                    + "total de intereses generados para el proyecto.";
        }
        return respuesta;
    }
}
