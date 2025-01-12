package Menus;

import Tienda.Concesionario;

public class MenuCoche extends Menu{
    public MenuCoche(Concesionario c){super(c);}


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

    public String seleccion(String opcion){
        switch(opcion){
            case "0":
                return "n";
            case "1":{}
            case "2":{}
            case "3":{}
            case "4":{}
        }return "";
    }

}
