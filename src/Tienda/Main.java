package Tienda;

import Entradas.MyInPut;
import Menus.MenuPrincipal;

public class Main {
    public static void main(String[] args) {
        Concesionario tienda = Concesionario.getInstance();
        MenuPrincipal menu = new MenuPrincipal(tienda);
        menu.ejecutar();
        MyInPut.serialize(tienda, "BackUp.dat");
    }
}