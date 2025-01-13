package Menus;

import Entradas.MyInPut;
import Tienda.*;

public abstract class Menu {
    private Concesionario concesionario;
    public Menu(Concesionario concesionario) {this.concesionario = concesionario;}
    
    /**
     * Obtiene el concesionario asociado.
     *
     * @return el objeto {@code Concesionario} correspondiente.
     */
    public Concesionario getConcesionario() {return concesionario;}

    /**
     * Ejecuta un ciclo interactivo para procesar opciones del usuario.
     * 
     * Este método continúa ejecutándose mientras el usuario introduzca "s" 
     * como respuesta en el método {@code ejecutarOpciones}.
     */
    public void ejecutar() {
        String respuesta = "";
        do {
            respuesta = ejecutarOpciones();

        } while (respuesta.equals("s"));
    }

    /**
     * Ejecuta las opciones disponibles para el usuario y procesa su selección.
     * 
     * Este método presenta las opciones al usuario, captura la entrada, la procesa
     * y determina la respuesta que controlará el flujo del programa.
     * 
     * @return una cadena que representa la respuesta procesada. Si no se puede ejecutar
     *         la opción seleccionada, devuelve "s" para indicar que el ciclo debe continuar.
     */
    public String ejecutarOpciones(){
    opciones();
    String respuesta =MyInPut.readString();
    respuesta = seleccion(respuesta);
    if (respuesta.equals("")) {
        System.out.println("No se puede ejecutar el opcion");
        return"s";
    }else return respuesta;
    }

    /**
     * Procesa y valida la respuesta proporcionada por el usuario.
     * 
     * Este método debe ser implementado por las subclases para definir 
     * cómo manejar y transformar la respuesta del usuario según la lógica específica.
     * 
     * @param respuesta la entrada proporcionada por el usuario.
     * @return una cadena que representa la respuesta procesada.
     */
    public abstract String seleccion(String respuesta);

    /**
     * Muestra o define las opciones disponibles para el usuario.
     * 
     * Este método debe ser implementado por las subclases para especificar
     * las opciones que se presentarán al usuario en el contexto correspondiente.
     */
    public abstract void opciones();
}
