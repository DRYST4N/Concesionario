package Menus;

import Entradas.MyInPut;
import Tienda.Coche;
import Tienda.Concesionario;
import Tienda.Seccion;

import java.util.ArrayList;

public class MenuSecciones extends Menu{
    public MenuSecciones(Concesionario c){super(c);}
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
    public void excepcion(){
        System.out.println("La seccion no existe.");
        System.out.println("Vuelva a intentarlo.");
    }

    public void opciones(){
        System.out.println("Gestion de Secciones");
        System.out.println("Elija una opcion:");
        System.out.println("1. Crear Seccion");
        System.out.println("2. Eliminar Seccion");
        System.out.println("3. Mostrar todas las secciones");
        System.out.println("0. Salir");
    }
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
