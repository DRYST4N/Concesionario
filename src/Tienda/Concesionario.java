package Tienda;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class Concesionario implements Serializable {
    private static Concesionario tienda;
    private ArrayList<Seccion> Secciones;
    private ArrayList<Cliente> Clientes;
    private  ArrayList<Venta> Ventas;

    private Concesionario() {
        Secciones = new ArrayList();
        Clientes = new ArrayList();
        Ventas = new ArrayList();
    }

    /**
     * Obtiene la instancia única del concesionario, implementando el patrón Singleton.
     * 
     * Este método garantiza que solo exista una única instancia de la clase {@code Concesionario}.
     * Si la instancia no está inicializada:
     * <ul>
     *   <li>Intenta deserializar la instancia desde el archivo "BackUp.dat".</li>
     *   <li>Si la deserialización falla o el archivo no existe, crea una nueva instancia de {@code Concesionario}.</li>
     * </ul>
     * 
     * @return la instancia única de {@code Concesionario}.
     */
    public static Concesionario getInstance() {
        if(tienda == null) {
            tienda = deserialize("BackUp.dat");
            if (tienda == null) {
                tienda = new Concesionario();
            }
        }
        return tienda;
    }

    /**
     * Deserializa un objeto desde un archivo especificado.
     * 
     * Este método intenta leer y deserializar un objeto genérico desde un archivo 
     * proporcionado como argumento. Si ocurre un error durante la deserialización, 
     * se captura la excepción y se imprime un mensaje de error.
     * 
     * @param <A> el tipo de objeto que se deserializará.
     * @param nombreFichero el nombre del archivo desde el cual se deserializará el objeto.
     * @return el objeto deserializado si la operación es exitosa, o {@code null} si ocurre un error.
     */
    private static <A> A deserialize(String nombreFichero) {
        try {
            FileInputStream fis = new FileInputStream(nombreFichero) ;
            ObjectInputStream iis = new ObjectInputStream(fis) ;
            return (A) iis.readObject() ;
        } catch (IOException e) {
            System.err.println("Problem: "+e);}
        catch(ClassNotFoundException e)
        { System.out.println(e.getMessage()); }
        return null ;
    }

    //Implementaremos las cosas de Clientes
    /**
     * Añade un cliente a la lista de clientes del concesionario.
     * 
     * Este método agrega el cliente proporcionado como argumento a la colección 
     * interna de clientes del concesionario.
     * 
     * @param c el objeto {@code Cliente} que se añadirá a la lista de clientes.
     */
    public void anadirClientes(Cliente c){
        Clientes.add(c);
    }

    /**
     * Recupera un cliente de la lista de clientes basado en su identificador único.
     * 
     * Este método busca en la lista de clientes y devuelve el cliente cuyo ID coincide 
     * con el ID proporcionado. Si no se encuentra ningún cliente con ese ID, devuelve {@code null}.
     * 
     * @param id el identificador único del cliente que se desea recuperar.
     * @return el objeto {@code Cliente} correspondiente al ID, o {@code null} si no se encuentra.
     */    
    public Cliente recuperarClientes(String id){
        for(Cliente c: Clientes) {
         if(c.getID().equals(id)) {
             return c;
         }
        }
        return null;
    }

    /**
     * Lista todos los clientes registrados en el concesionario.
     * 
     * Este método recorre la colección de clientes y muestra la información de cada cliente,
     * numerándolos de manera consecutiva. Para cada cliente, llama al método {@code MostrarInfo()} 
     * para detallar su información.
     */
    public void ListarClientes(){
        for (Cliente c: Clientes) {
            int i = 1;
            System.out.println(i + " - ");
            c.MostrarInfo();
            i = i + 1;
        }
    }

    /**
     * Lista todos los clientes que desean recibir información adicional.
     * 
     * Este método recorre la colección de clientes y muestra la información de aquellos
     * que tienen configurada la preferencia para recibir información. Numerando de manera consecutiva, 
     * llama al método {@code MostrarInfo()} de cada cliente que cumple con la condición.
     */
    public void ListarClientesInfo(){
        for (Cliente c: Clientes) {
            int i = 1;
            if (c.getInfo()){
                System.out.println(i + ".- ");
                c.MostrarInfo();
                i = i + 1;
            }
        }
    }

    //Desde aqui se implementaran los metodos que tienen que ver con las Secciones
    /**
     * Agrega una sección a la lista de secciones del concesionario.
     * 
     * Este método añade el objeto {@code Seccion} proporcionado a la colección interna 
     * de secciones del concesionario.
     * 
     * @param s el objeto {@code Seccion} que se añadirá a la lista de secciones.
     */
    public void agregarSeccion(Seccion s){
        Secciones.add(s);
    }

    /**
     * Recupera una sección de la lista de secciones basada en su identificador único.
     * 
     * Este método busca en la lista de secciones y devuelve la sección cuyo ID coincide 
     * con el ID proporcionado. Si no se encuentra ninguna sección con ese ID, devuelve {@code null}.
     * 
     * @param id el identificador único de la sección que se desea recuperar.
     * @return el objeto {@code Seccion} correspondiente al ID, o {@code null} si no se encuentra.
     */
    public Seccion recuperarSeccion(String id){
        for(Seccion s: Secciones) {
            if(s.getId().equals(id)) {
                return s;
            }
        }return null;
    }

    /**
     * Elimina una sección de la lista de secciones del concesionario.
     * 
     * Este método elimina el objeto {@code Seccion} proporcionado de la colección interna 
     * de secciones del concesionario. Si la sección no existe en la lista, no se realiza ninguna acción.
     * 
     * @param s el objeto {@code Seccion} que se desea eliminar de la lista de secciones.
     */
    public void eliminarSeccion(Seccion s){
        Secciones.remove(s);
    }

    /**
     * Lista todas las secciones registradas en el concesionario.
     * 
     * Este método recorre la colección de secciones y muestra la información de cada sección, 
     * numerándolas de manera consecutiva. Para cada sección, llama al método {@code MostrarInfo()} 
     * para detallar su información.
     */
    public void ListarSecciones(){
        for (Seccion s: Secciones) {
            int i = 1;
            System.out.println(i + " - ");
            s.MostrarInfo();
            i = i + 1;
        }
    }
}
