package Menus;

import Entradas.MyInPut;
import Tienda.Coche;
import Tienda.Concesionario;
import Tienda.Seccion;

public class MenuCoche extends Menu{
    public MenuCoche(Concesionario c){super(c);}
    public void agregarCoche(){
        System.out.println("Cual es la seccion en la que lo va a meter:");
        String seccion = MyInPut.readString();
        System.out.println("Introduzca el modelo del coche:");
        String modelo = MyInPut.readString();
        System.out.println("Introduzca el año del coche: ");
        String ano = MyInPut.readString();
        String id = modelo + "-" + ano;
        System.out.println("Hola");
        Coche cocheNuevo= getConcesionario().recuperarSeccion(seccion).RecuperarCoche(id);
        if(cocheNuevo == null){
            System.out.println("Introduzca el precio base del coche: ");
            double precioBase = MyInPut.readDouble();
            cocheNuevo = new Coche(id, precioBase);
            Seccion categoria = getConcesionario().recuperarSeccion(seccion);
            categoria.agregarCoche(cocheNuevo);
        }else{
            System.out.println("El coche ya existe en el sistema");
            System.out.println("Vuelva a intentarlo");
        }
    }
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
    public void excepcion(){
        System.out.println("El coche no existe en el sistema.");
        System.out.println("Vuelva a intentarlo.");
    }
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
