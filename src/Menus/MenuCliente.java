package Menus;
import Entradas.MyInPut;
import Tienda.Concesionario;
import Tienda.Cliente;

public class MenuCliente extends Menu{
    public MenuCliente(Concesionario c) { super(c); }
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
        }
    }
    public boolean getInfo(int info){
        if (info == 1) {
            return true;
        }
        return false;
    }
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

    public void excepcion(){
        System.out.println("El id del cliente no existe");
        System.out.println("Vuelva a intentarlo");
    }

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
