package Menus;

import Entradas.MyInPut;
import Tienda.*;

public abstract class Menu {
    private Concesionario concesionario;
    public Menu(Concesionario concesionario) {this.concesionario = concesionario;}
    public Concesionario getConcesionario() {return concesionario;}
    public void ejecutar() {
        String respuesta = "";
        do {
            respuesta = ejecutarOpciones();

        } while (respuesta.equals("s"));
    }
    public String ejecutarOpciones(){
    opciones();
    String respuesta =MyInPut.readString();
    respuesta = seleccion(respuesta);
    if (respuesta.equals("")) {
        System.out.println("No se puede ejecutar el opcion");
        return"s";
    }else return respuesta;
    }
    public abstract String seleccion(String respuesta);
    public abstract void opciones();
}
