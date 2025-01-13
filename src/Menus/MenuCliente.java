package Menus;
import Entradas.MyInPut;
import Tienda.Concesionario;
import Tienda.Cliente;

public class MenuCliente extends Menu{
    public MenuCliente(Concesionario c) { super(c); }

    /**
     * Solicita datos del cliente al usuario y lo agrega al concesionario si no existe previamente.
     * 
     * Este método verifica si un cliente con el ID proporcionado ya está registrado en el sistema.
     * Si no lo está, solicita información adicional al usuario (nombre, teléfono, preferencia de recibir información)
     * y lo añade al sistema. Si el cliente ya existe, muestra un mensaje de error.
     */
    private void agregarCliente() {
        System.out.println(" Introduzca el id del cliente: ");
        String id = MyInPut.readString();
        Cliente c =getConcesionario().recuperarClientes(id);
        if (c == null) {
            System.out.println("Introduzca el nombre del cliente:");
            String nombre = MyInPut.readString();
            System.out.println("Introduzca el telefono del cliente:");
            int telefono = MyInPut.readInt();
            System.out.println("El cliente desea recibir informacion (1 = Si // 0 = No): ");
            int info = MyInPut.readInt();
            c = new Cliente(id, nombre, telefono, getInfo(info));
            getConcesionario().anadirClientes(c);
        }else{
            System.out.println("El cliente ya existe en el sistema.");
            System.out.println("Vuelva a intentarlo.");
        }
    }

    /**
     * Convierte un valor entero en un valor booleano.
     * 
     * Este método interpreta el entero proporcionado como una preferencia:
     * <ul>
     *   <li>Si {@code info} es igual a 1, devuelve {@code true}.</li>
     *   <li>En cualquier otro caso, devuelve {@code false}.</li>
     * </ul>
     * 
     * @param info un entero que representa la preferencia (1 = Sí, otros valores = No).
     * @return {@code true} si el valor es 1, de lo contrario {@code false}.
     */
    public boolean getInfo(int info){
        if (info == 1) {
            return true;
        }
        return false;
    }

    /**
     * Muestra la información de un cliente identificado por su ID.
     * 
     * Este método solicita al usuario que introduzca el ID de un cliente, 
     * busca al cliente en el concesionario y, si lo encuentra, muestra su información 
     * llamando al método {@code MostrarInfo} del cliente. Si el cliente no existe, 
     * invoca el método {@code excepcion()} para manejar la situación.
     */
    public void mostrarCliente(){
        System.out.println("Introduzca el id del cliente: ");
        String id = MyInPut.readString();
        Cliente c = getConcesionario().recuperarClientes(id);
        if (c == null) {
            excepcion();
        }else{
            c.MostrarInfo();
        }
    }

    /**
     * Muestra un mensaje de error indicando que el ID del cliente no existe.
     * 
     * Este método informa al usuario que el cliente con el ID proporcionado no se encuentra 
     * en el sistema e invita a intentarlo nuevamente.
     */
    public void excepcion(){
        System.out.println("El id del cliente no existe");
        System.out.println("Vuelva a intentarlo");
    }

    /**
     * Muestra el menú de opciones para la gestión de clientes.
     * 
     * Este método imprime un conjunto de opciones en la consola, permitiendo al usuario 
     * seleccionar acciones relacionadas con la gestión de clientes, como dar de alta un nuevo cliente, 
     * obtener información de clientes específicos o mostrar información general.
     */
    public void opciones(){
        System.out.println(" ");
        System.out.println("Gestion de clientes");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Dar de alta un nuevo cliente.");
        System.out.println("2. Informacion de un cliente concreto.");
        System.out.println("3. Mostrar informacion de todos los clientes.");
        System.out.println("4. Mostrar informacion de los clientes que quieran publicidad.");
        System.out.println("0. Salir.");
    }

    
    /**
     * Procesa la opción seleccionada por el usuario y ejecuta la acción correspondiente.
     * 
     * Este método utiliza un bloque `switch` para determinar la acción a realizar según 
     * la opción proporcionada como entrada. Las opciones disponibles son:
     * <ul>
     *   <li>"1": Agregar un nuevo cliente llamando a {@code agregarCliente()}.</li>
     *   <li>"2": Mostrar información de un cliente llamando a {@code mostrarCliente()}.</li>
     *   <li>"3": Listar todos los clientes llamando a {@code getConcesionario().ListarClientes()}.</li>
     *   <li>"4": Listar los clientes interesados en recibir publicidad llamando a 
     *       {@code getConcesionario().ListarClientesInfo()}.</li>
     *   <li>"0": Salir del menú devolviendo {@code "n"}.</li>
     * </ul>
     * Si la opción no es válida, devuelve una cadena vacía.
     * 
     * @param s la opción seleccionada por el usuario como cadena.
     * @return una cadena de control:
     *         <ul>
     *           <li>{@code "s"} para continuar en el ciclo principal.</li>
     *           <li>{@code "n"} para detener el ciclo principal.</li>
     *           <li>Cadena vacía si la opción es inválida.</li>
     *         </ul>
     */
    public String seleccion(String s){
        switch (s) {
            case "1": {
                agregarCliente();
                return "s";
            }
            case "2": {
                mostrarCliente();
                return "s";
            }
            case "3": {
                getConcesionario().ListarClientes();
                return "s";
            }
            case "4": {
                getConcesionario().ListarClientesInfo();
                return "s";
            }
            case "0": {
                return "n";
            }
        }return "";
    }
}
