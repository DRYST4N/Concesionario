package Menus;
import Tienda.Concesionario;
import Entradas.MyInPut;
import java.util.ArrayList;

public class MenuPrincipal extends Menu{
    private ArrayList<Menu> Menus = new ArrayList<>();
    public MenuPrincipal(Concesionario c){
        super(c);
        Menus.add(new MenuSecciones(c));
        Menus.add(new MenuCoche(c));
        Menus.add(new MenuVentas(c));
        Menus.add(new MenuCliente(c));
    }

    /**
     * Muestra las opciones disponibles en el sistema para que el usuario seleccione una acción.
     * 
     * Este método imprime un menú en la consola con las opciones numeradas, 
     * permitiendo al usuario elegir entre diferentes gestiones, como secciones, coches, ventas y clientes.
     */
    public void opciones(){
        System.out.println("");
        System.out.println("Seleccione una opcion:");
        System.out.println("0.- Salir del programa.");
        System.out.println("1. Gestion de Secciones.");
        System.out.println("2. Gestion de coches.");
        System.out.println("3. Gestion de ventas.");
        System.out.println("4. Gestion de clientes.");
    }

    /**
     * Procesa la cadena proporcionada como entrada y devuelve un resultado.
     * 
     * En esta implementación específica, el método no realiza ninguna operación
     * y siempre devuelve {@code null}.
     * 
     * @param s la cadena de entrada proporcionada por el usuario.
     * @return {@code null}, ya que este método no está implementado.
     */
    public String seleccion(String s){
    return  null;
    }
    
    /**
     * Muestra las opciones disponibles, solicita una selección del usuario y ejecuta la opción seleccionada.
     * 
     * Este método valida la entrada del usuario, maneja errores de formato en caso de que 
     * la entrada no sea un número válido, y ejecuta la opción correspondiente del menú.
     * 
     * @return una cadena que controla el flujo del programa:
     *         <ul>
     *         <li>{@code "s"}: para continuar el ciclo principal.</li>
     *         <li>{@code "n"}: para indicar que el ciclo debe detenerse.</li>
     *         </ul>
     */
    public String ejecutarOpciones(){
        opciones();
        System.out.println("Elija una opcion: ");
        String opcion = MyInPut.readString();
        int i;
        try{
            i = Integer.parseInt(opcion);
        }catch(NumberFormatException e){
            System.out.println("El valor de la opcion no es valido.");
            return "s";
        }
        if(i> 0 && i<=Menus.size()){
            Menus.get(i - 1).ejecutar();
            return "s";
        }else if(i<0 || i>Menus.size()){
            System.out.println("Opcion no valida.");
            return "s";
        }else return "n";
    }
}
