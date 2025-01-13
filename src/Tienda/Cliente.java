package Tienda;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String ID; //DNI o NIE
    private String Nombre;
    private int Telefono;
    private boolean Info;
    public Cliente(String ID, String Nombre, int Telefono, boolean Info) {
        this.ID = ID;
        this.Nombre = Nombre;
        this.Telefono = Telefono;
        this.Info = Info;
    }

    /**
     * Obtiene el identificador único del objeto.
     * 
     * Este método devuelve el valor de la variable {@code ID}, que representa 
     * el identificador único asociado al objeto.
     * 
     * @return una cadena que contiene el identificador único del objeto.
     */
    public String getID(){
        return ID;
    }
    
    /**
     * Muestra la información detallada del objeto.
     * 
     * Este método imprime en la consola los valores de los atributos del objeto, 
     * incluyendo el identificador único, el nombre, el teléfono y la preferencia de información.
     * 
     * Atributos mostrados:
     * <ul>
     *   <li>ID: Identificador único del objeto.</li>
     *   <li>Nombre: Nombre asociado al objeto.</li>
     *   <li>Telefono: Número de teléfono asociado al objeto.</li>
     *   <li>Info: Preferencia sobre recibir información.</li>
     * </ul>
     */
    public void MostrarInfo(){
        System.out.println("ID: " + ID);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Telefono: " + Telefono);
        System.out.println("Info: " + Info);
    }

    /**
     * Obtiene la preferencia de información asociada al objeto.
     * 
     * Este método devuelve el valor de la variable {@code Info}, que indica si 
     * el objeto está configurado para recibir información.
     * 
     * @return {@code true} si el objeto está configurado para recibir información, 
     *         {@code false} en caso contrario.
     */
    public boolean getInfo(){
        return Info;
    }
}
