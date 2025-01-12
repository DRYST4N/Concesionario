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
    public String getID(){
        return ID;
    }
    public void MostrarInfo(){
        System.out.println("ID: " + ID);
        System.out.println("Nombre: " + Nombre);
        System.out.println("Telefono: " + Telefono);
        System.out.println("Info: " + Info);
    }
}
