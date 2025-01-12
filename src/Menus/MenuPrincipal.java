package Menus;
import Tienda.Concesionario;
import Entradas.MyInPut;
import java.util.ArrayList;

public class MenuPrincipal extends Menu{
    private ArrayList<Menu> Menus = new ArrayList<>();
    public MenuPrincipal(Concesionario c){
        super(c);
        Menus.add(new MenuCliente(c));
        Menus.add(new MenuCoche(c));
        Menus.add(new MenuSecciones(c));
        //Menus.add(new MenuVenta(c));
    }
    public void opciones(){
        System.out.println("");
        System.out.println("Seleccione una opcion:");
        System.out.println("0.- Salir del programa.");
        System.out.println("1. Gestion de Secciones.");
        System.out.println("2. Gestion de coches.");
        System.out.println("3. Gestion de ventas.");
        System.out.println("4. Gestion de clientes.");
    }
    public String seleccion(String s){
    return  null;
    }
    public String ejecutarOpciones(){
        opciones();
        System.out.println("Elija una opcion: ");
        String opcion = MyInPut.readString();
        int i;
        try{
            i = Integer.parseInt(opcion);
        }catch(NumberFormatException e){
            System.out.println("El valor de la opcion no es valido.");
            return "s";
        }
        if(i>=0 && i<=Menus.size()){
            Menus.get(i-1).ejecutar();
            return "s";
        }else if(i<0 || i>Menus.size()){
            System.out.println("Opcion no valida.");
            return "s";
        }else return "n";
    }
}
