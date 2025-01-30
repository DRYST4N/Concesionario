package Tienda;

import java.io.Serializable;
import java.util.ArrayList;

public class Seccion implements Serializable {

    //Atributos
    private String id; //Nombre que se le pone a la seccion
    private String descripcion;//Breve descripcion de la seccion
    private ArrayList<Coche> coches;

    //Constructor
    public Seccion(String id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        coches = new ArrayList<>();
    }

    /**
     * Obtiene el identificador único de la sección.
     * 
     * Este método devuelve el valor de la variable {@code id}, que representa 
     * el identificador único asociado a la sección.
     * 
     * @return una cadena que contiene el identificador único de la sección.
     */
    public String getId() {return id;}

    /**
     * Agrega un coche a la lista de coches de la sección.
     * 
     * Este método añade el objeto {@code Coche} proporcionado a la colección interna 
     * de coches pertenecientes a la sección.
     * 
     * @param coche el objeto {@code Coche} que se añadirá a la lista de coches de la sección.
     */
    public void agregarCoche(Coche coche) {
        coches.add(coche);
    }

    /**
     * Obtiene la lista de coches de la sección.
     * 
     * Este método devuelve la colección de objetos {@code Coche} asociados a la sección.
     * 
     * @return una lista de coches ({@code ArrayList<Coche>}) pertenecientes a la sección.
     */
    public ArrayList<Coche> getCoches() {return coches;}

    /**
     * Muestra la información detallada de la sección.
     * 
     * Este método imprime en la consola los valores de los atributos de la sección, 
     * incluyendo su identificador único ({@code id}) y su descripción.
     */
    public void MostrarInfo(){
        System.out.println("ID: "+id);
        System.out.println("Descripcion: "+descripcion);
    }

    /**
     * Recupera un coche de la lista de coches de la sección basado en su identificador único.
     * 
     * Este método busca en la lista de coches de la sección y devuelve el coche cuyo ID coincide 
     * con el ID proporcionado. Si no se encuentra ningún coche con ese ID, devuelve {@code null}.
     * 
     * @param id el identificador único del coche que se desea recuperar.
     * @return el objeto {@code Coche} correspondiente al ID, o {@code null} si no se encuentra.
     */
    public Coche RecuperarCoche(String id){
        for (Coche coche : coches) {
            if(coche.getId().equals(id)){
                return coche;
            }
        }return  null;
    }

    /**
     * Lista todos los coches registrados en la sección.
     * 
     * Este método recorre la lista de coches de la sección y muestra la información de cada coche, 
     * numerándolos de manera consecutiva. Para cada coche, llama al método {@code mostrarInfo()} 
     * para detallar su información.
     */
    public void ListarCoches(){
        int i = 1;
        for (Coche coche : coches) {
            System.out.println(i + "- ");
            coche.mostrarInfo();
            i = i + 1;
        }
    }
}
