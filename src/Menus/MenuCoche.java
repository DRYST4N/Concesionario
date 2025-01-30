package Menus;

import Entradas.MyInPut;
import Tienda.Coche;
import Tienda.Cochebase;
import Tienda.Concesionario;
import Tienda.Seccion;

public class MenuCoche extends Menu{
    public MenuCoche(Concesionario c){super(c);}

    /**
     * Agrega un coche a una sección específica del concesionario.
     * 
     * Este método solicita información del coche al usuario, como el modelo, año y precio base, 
     * y lo agrega a la sección indicada si no existe previamente. Si el coche ya está registrado, 
     * muestra un mensaje de error e invita al usuario a intentarlo nuevamente.
     * 
     * El ID del coche se genera combinando el modelo y el año.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita la sección donde se agregará el coche.</li>
     *   <li>Solicita detalles del coche: modelo, año y precio base.</li>
     *   <li>Verifica si el coche ya existe en la sección especificada.</li>
     *   <li>Si no existe, crea el coche y lo agrega a la sección correspondiente.</li>
     *   <li>Si ya existe, muestra un mensaje de error.</li>
     * </ul>
     */
    public void agregarCoche(){
        System.out.println("Cual es la seccion en la que lo va a meter:");
        String seccion = MyInPut.readString();
        System.out.println("Introduzca el modelo del coche:");
        String modelo = MyInPut.readString();
        System.out.println("Introduzca el año del coche: ");
        String ano = MyInPut.readString();
        String id = modelo + "-" + ano;
        System.out.println("Hola");
        if(getConcesionario().recuperarSeccion(seccion) == null){
            System.out.println("La seccion no existe.");
        }
        Coche cocheNuevo= getConcesionario().recuperarSeccion(seccion).RecuperarCoche(id);
        if(cocheNuevo == null){
            System.out.println("Introduzca el precio base del coche: ");
            double precioBase = MyInPut.readDouble();
            cocheNuevo = new Cochebase(id, precioBase);
            Seccion categoria = getConcesionario().recuperarSeccion(seccion);
            categoria.agregarCoche(cocheNuevo);
        }else{
            System.out.println("El coche ya existe en el sistema");
            System.out.println("Vuelva a intentarlo");
        }
    }

    /**
     * Muestra la información de un coche específico dentro de una sección del concesionario.
     * 
     * Este método solicita al usuario el ID de la sección y el ID del coche, busca el coche 
     * en la sección especificada y, si lo encuentra, muestra su información llamando al método 
     * {@code mostrarInfo()} del coche. Si el coche no existe, invoca el método {@code excepcion()} 
     * para manejar la situación.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita al usuario el ID de la sección.</li>
     *   <li>Solicita al usuario el ID del coche.</li>
     *   <li>Busca el coche en la sección indicada.</li>
     *   <li>Si el coche existe, muestra su información.</li>
     *   <li>Si no existe, muestra un mensaje de error llamando a {@code excepcion()}.</li>
     * </ul>
     */
    public void MostrarCoche(){
        System.out.println("Introduzca el id de la seccion: ");
        String seccion = MyInPut.readString();
        System.out.println("Introduzca el id del coche: ");
        String id = MyInPut.readString();
        Coche coche = getConcesionario().recuperarSeccion(seccion).RecuperarCoche(id);
        if(coche != null){
            coche.mostrarInfo();
        }else{
            excepcion();
        }
    }

    /**
     * Muestra un mensaje de error indicando que el coche no existe en el sistema.
     * 
     * Este método informa al usuario que el coche con el ID proporcionado no está registrado
     * en el sistema e invita a intentarlo nuevamente.
     */
    public void excepcion(){
        System.out.println("El coche no existe en el sistema.");
        System.out.println("Vuelva a intentarlo.");
    }

    /**
     * Agrega o actualiza el stock de un coche específico en una sección del concesionario.
     * 
     * Este método solicita al usuario el ID de la sección y el ID del coche, 
     * busca el coche en la sección especificada y, si lo encuentra, permite al usuario 
     * introducir la cantidad de stock para actualizar. Si el coche no existe, 
     * se invoca el método {@code excepcion()} para manejar la situación.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita al usuario el ID de la sección.</li>
     *   <li>Solicita al usuario el ID del coche.</li>
     *   <li>Busca el coche en la sección especificada.</li>
     *   <li>Si el coche existe, solicita la cantidad de stock y actualiza el stock del coche 
     *       usando el método {@code setStock()}.</li>
     *   <li>Si el coche no existe, muestra un mensaje de error llamando a {@code excepcion()}.</li>
     * </ul>
     */
    public void agregarStock(){
        System.out.println("Introduzca el id de la seccion: ");
        String seccion = MyInPut.readString();
        System.out.println("Introduzca el id del coche: ");
        String id = MyInPut.readString();
        Coche coche = getConcesionario().recuperarSeccion(seccion).RecuperarCoche(id);
        if(coche != null){
            System.out.println("Introduzca el stock del coche: ");
            int stock = MyInPut.readInt();
            coche.setStock(stock);
        }else{
            excepcion();
        }
    }

    /**
     * Muestra la lista de coches de una sección específica del concesionario.
     * 
     * Este método solicita al usuario el ID de la sección, verifica si la sección existe 
     * y, si es así, llama al método {@code ListarCoches()} de la sección para mostrar 
     * todos los coches que pertenecen a ella. Si la sección no existe, muestra un mensaje 
     * de error indicando que la categoría no está registrada.
     * 
     * Pasos del método:
     * <ul>
     *   <li>Solicita al usuario el ID de la sección.</li>
     *   <li>Busca la sección en el concesionario.</li>
     *   <li>Si la sección existe, muestra la lista de coches llamando a {@code ListarCoches()}.</li>
     *   <li>Si la sección no existe, muestra un mensaje de error y solicita al usuario intentarlo nuevamente.</li>
     * </ul>
     */
    public void mostrarCoche(){
        System.out.println("Introduzca el id de la seccion: ");
        String seccion = MyInPut.readString();
        Seccion categoria = getConcesionario().recuperarSeccion(seccion);
        if(categoria != null){
            categoria.ListarCoches();
        }else{
            System.out.println("La categoria no existe en el sistema.");
            System.out.println("Vuelva a intentarlo.");
        }
    }

    /**
     * Muestra el menú de opciones para la gestión de coches.
     * 
     * Este método imprime un conjunto de opciones en la consola, permitiendo al usuario 
     * seleccionar acciones relacionadas con la gestión de coches en el concesionario. 
     * Las opciones incluyen agregar un coche, mostrar datos de un coche, aumentar el stock 
     * y listar coches en una sección específica.
     */
    public void opciones(){
        System.out.println("");
        System.out.println("Gestion de coches.");
        System.out.println("Elija una opcion:");
        System.out.println("1. Dar alta coche.");
        System.out.println("2. Mostrar datos de un coche.");
        System.out.println("3. Aumentar el stock");
        System.out.println("4. Mostrar los coches de una seccion.");
        System.out.println("0. Salir");
    }

    /**
     * Procesa la opción seleccionada por el usuario y ejecuta la acción correspondiente.
     * 
     * Este método utiliza un bloque `switch` para determinar qué acción realizar en función 
     * de la opción proporcionada por el usuario. Las opciones disponibles son:
     * <ul>
     *   <li>"0": Salir del menú y devolver {@code "n"}.</li>
     *   <li>"1": Llama al método {@code agregarCoche()} para dar de alta un nuevo coche y devuelve {@code "s"}.</li>
     *   <li>"2": Llama al método {@code MostrarCoche()} para mostrar los datos de un coche específico y devuelve {@code "s"}.</li>
     *   <li>"3": Llama al método {@code agregarStock()} para aumentar el stock de un coche y devuelve {@code "s"}.</li>
     *   <li>"4": Llama al método {@code mostrarCoche()} para listar los coches de una sección y devuelve {@code "s"}.</li>
     * </ul>
     * Si la opción no coincide con ninguna de las anteriores, devuelve una cadena vacía.
     * 
     * @param opcion la opción seleccionada por el usuario como cadena.
     * @return una cadena de control:
     *         <ul>
     *           <li>{@code "s"} para continuar en el ciclo principal.</li>
     *           <li>{@code "n"} para detener el ciclo principal.</li>
     *           <li>Cadena vacía si la opción es inválida.</li>
     *         </ul>
     */
    public String seleccion(String opcion){
        switch(opcion){
            case "0":
                return "n";
            case "1":{
                agregarCoche();
                return "s";
            }
            case "2":{
                MostrarCoche();
                return "s";
            }
            case "3":{
                agregarStock();
                return "s";
            }
            case "4":{
                mostrarCoche();
                return "s";
            }
        }return "";
    }

}
