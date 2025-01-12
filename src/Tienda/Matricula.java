package Tienda;

public class Matricula{

    //Atributos
    private  int numeroActual=0 ; // Contador de números
    private static int indiceLetras = 0; // Contador de letras
    private static final String LETRAS_PERMITIDAS = "BCDFGHJKLMNPRSTVWXYZ";


    public Matricula(int numeroActual){
        this.numeroActual=numeroActual;
    }

    // Metodo para generar una matrícula secuencial
    public String generarMatricula() {
        // Formatear los números
        String formatoNumeros = String.format("%04d", numeroActual);

        // Generar las letras correspondientes al índice actual
        int primeraLetra = (indiceLetras / (21 * 21)) % 21;
        int segundaLetra = (indiceLetras / 21) % 21;
        int terceraLetra = indiceLetras % 21;

        String letras = "" + LETRAS_PERMITIDAS.charAt(primeraLetra) +
                LETRAS_PERMITIDAS.charAt(segundaLetra) +
                LETRAS_PERMITIDAS.charAt(terceraLetra);

        // Incrementar el número y, si se llega al máximo, reiniciar y avanzar el índice de letras
        numeroActual++;
        if (numeroActual > 9999) {
            numeroActual = 0;
            indiceLetras++;
        }

        return formatoNumeros + " " + letras;
    }
}
