package Menus;

import Entradas.MyInPut;
import Tienda.Coche;
import Tienda.Concesionario;
import Tienda.Seccion;

import java.util.ArrayList;

public class MenuSecciones extends Menu{
    public MenuSecciones(Concesionario c){super(c);}

    /**
     * Agrega una nueva sección al concesionario.
     * 
     * Este método solicita al usuario el nombre de la sección. Si la sección no existe, 
     * solicita una descripción adicional, crea la sección y la agrega al concesionario. 
     * Si la sección ya existe, muestra un mensaje de error e invita al usuario a intentarlo nuevamente.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita al usuario el nombre de la sección.</li>
     *   <li>Verifica si la sección ya existe en el concesionario.</li>
     *   <li>Si la sección no existe:
     *       <ul>
     *         <li>Solicita una descripción de la sección.</li>
     *         <li>Crea la nueva sección.</li>
     *         <li>Agrega la sección al concesionario.</li>
     *       </ul>
     *   </li>
     *   <li>Si la sección ya existe, muestra un mensaje de error.</li>
     * </ul>
     */
    public void agregarSeccion(){
        System.out.println("Escriba el nombre de la seccion: ");
        String s = MyInPut.readString();
        Seccion se = getConcesionario().recuperarSeccion(s);
        if (se ==null){
            System.out.println("Introduzca una descripcion de la seccion: ");
            String desc = MyInPut.readString();
            se = new Seccion(s,desc);
            getConcesionario().agregarSeccion(se);
        }else{
            System.out.println("El seccion ya existe.");
            System.out.println("Vuelva a intentarlo.");
        }
    }

    /**
     * Elimina una sección del concesionario si no contiene coches.
     * 
     * Este método solicita al usuario el nombre de la sección a eliminar. Si la sección existe y no 
     * contiene coches, se elimina del concesionario. Si la sección contiene coches, muestra un mensaje 
     * indicando que no puede ser eliminada. Si la sección no existe, invoca el método {@code excepcion()} 
     * para manejar la situación.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita al usuario el nombre de la sección.</li>
     *   <li>Recupera la sección del concesionario.</li>
     *   <li>Si la sección existe:
     *       <ul>
     *         <li>Comprueba si la lista de coches en la sección está vacía.</li>
     *         <li>Si está vacía, elimina la sección del concesionario.</li>
     *         <li>Si no está vacía, muestra un mensaje indicando que no puede eliminarse.</li>
     *       </ul>
     *   </li>
     *   <li>Si la sección no existe, llama al método {@code excepcion()}.</li>
     * </ul>
     */
    public void EliminarSeccion(){
        System.out.println("Escriba el nombre de la seccion: ");
        String s = MyInPut.readString();
        Seccion se = getConcesionario().recuperarSeccion(s);
        ArrayList<Coche> coches = se.getCoches();
        if (se !=null) {
            if (coches.size() == 0) {
                getConcesionario().eliminarSeccion(se);
            }else{
                System.out.println("La seccion contiene coches.");
                System.out.println("No se puede eliminar.");
            }
        }else{
            excepcion();
        }
    }

    /**
     * Muestra un mensaje de error indicando que la sección no existe en el sistema.
     * 
     * Este método informa al usuario que la sección con el nombre proporcionado no está 
     * registrada en el sistema e invita a intentarlo nuevamente.
     */
    public void excepcion(){
        System.out.println("La seccion no existe.");
        System.out.println("Vuelva a intentarlo.");
    }

    /**
     * Muestra el menú de opciones para la gestión de secciones en el concesionario.
     * 
     * Este método imprime un conjunto de opciones en la consola, permitiendo al usuario 
     * seleccionar acciones relacionadas con la gestión de secciones. Las opciones incluyen 
     * crear una nueva sección, eliminar una existente o mostrar todas las secciones registradas.
     * 
     * Opciones disponibles:
     * <ul>
     *   <li>1: Crear una nueva sección.</li>
     *   <li>2: Eliminar una sección existente.</li>
     *   <li>3: Mostrar todas las secciones registradas.</li>
     *   <li>0: Salir del menú.</li>
     * </ul>
     */
    public void opciones(){
        System.out.println("Gestion de Secciones");
        System.out.println("Elija una opcion:");
        System.out.println("1. Crear Seccion");
        System.out.println("2. Eliminar Seccion");
        System.out.println("3. Mostrar todas las secciones");
        System.out.println("0. Salir");
    }

    /**
     * Procesa la opción seleccionada por el usuario y ejecuta la acción correspondiente para la gestión de secciones.
     * 
     * Este método utiliza un bloque `switch` para determinar qué acción realizar en función de la opción 
     * seleccionada por el usuario. Las opciones disponibles son:
     * <ul>
     *   <li>"0": Salir del menú y devolver {@code "n"}.</li>
     *   <li>"1": Llama al método {@code agregarSeccion()} para crear una nueva sección y devuelve {@code "s"}.</li>
     *   <li>"2": Llama al método {@code EliminarSeccion()} para eliminar una sección existente y devuelve {@code "s"}.</li>
     *   <li>"3": Llama al método {@code getConcesionario().ListarSecciones()} para mostrar todas las secciones y devuelve {@code "s"}.</li>
     * </ul>
     * Si la opción no coincide con ninguna de las anteriores, devuelve {@code "n"} para salir del ciclo principal.
     * 
     * @param opcion la opción seleccionada por el usuario como cadena.
     * @return una cadena de control:
     *         <ul>
     *           <li>{@code "s"} para continuar en el ciclo principal.</li>
     *           <li>{@code "n"} para detener el ciclo principal o para manejar opciones inválidas.</li>
     *         </ul>
     */
    public String seleccion(String opcion){
        switch(opcion){
            case "0": return "n";
            case "1":{
                agregarSeccion();
                return "s";
            }
            case "2":{
                EliminarSeccion();
                return "s";
            }
            case "3":{
            getConcesionario().ListarSecciones();
            return "s";
            }
        }return "n";
    }
}
