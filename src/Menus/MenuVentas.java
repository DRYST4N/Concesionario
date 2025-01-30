package Menus;

import Entradas.MyInPut;
import Tienda.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class MenuVentas extends Menu{


    public MenuVentas(Concesionario c) {super(c);}


    private String generarIdVenta() {
        int num =getConcesionario().numeroVentas();
        String id = String.format("V%08d",num);
        return id;
    }

    public void registarVenta() {
        try {
            System.out.println("Registrando la venta");
            System.out.println("Escribe cual es la seccion en donde quieres comprar el coche:");
            String seccion = MyInPut.readString();
            Seccion s = getConcesionario().recuperarSeccion(seccion);
            if (s==null){
                throw new Exception("No se encontro el seccion");
            }
            System.out.println("Escribe el id del coche que quieres comprar:");
            String id = MyInPut.readString();
            Coche c = s.RecuperarCoche(id);
            if (c.getStock() < 0) {
                throw new Exception("No se puede comprar el coche");
            }
            System.out.println("Escribe el DNI/NIF del cliente:");
            String dni = MyInPut.readString();
            Cliente cliente = getConcesionario().recuperarClientes(dni);
            if (cliente == null) {
                throw new Exception("No se encontro el cliente");
            }
            System.out.println("¿desea agregar alguna mejora?(s/n)");
            int num = MyInPut.readInt();

            if (num == 1) {
                menuMejoras(c,0);
            }
            String id_venta = generarIdVenta();
            String matricula = generarMatricula(getConcesionario().matriculaCoche());
            LocalDate hoy = LocalDate.now();

            Venta venta =new Venta(id_venta,cliente,c,matricula,hoy);

            getConcesionario().anadirVentas(venta);

        }catch (Exception e) {
            System.out.println( e.getMessage());
            System.out.println("No se puede comprar el coche");
        }
    }

    public void  menuMejoras(Coche c , int num){
        System.out.println("Elige tipo de mejora (el numero) /n 1.Calefaccion /n 2.GPS /n 3.Llantas /n 4.Tapiceria de cuero");
        int eleccion = MyInPut.readInt();
        if (eleccion == num){
            System.out.println("No se puede añadir la misma mejora");
        }else{
            switch (num) {
                case 1:
                    c= new Calefaccion(c);
                    break;
                case 2:
                    c= new GPS(c);
                    break;
                case 3:
                    c= new Llantas(c);
                    break;
                case 4:
                    c=new Tapiceria_Cuero(c);
                    break;
                default:
                    System.out.println("No has elegido ninguna mejora");
            }
        }
        System.out.println("Quieres Añadir otra mejora: (1 si ,0 no)");
        num = MyInPut.readInt();
        if(num==1){
            menuMejoras(c,eleccion);
        }


    }

    /**
     * Obtiene la matrícula del coche vendido.
     *
     * @return El numero de la matricula anterior.
     */
    public String generarMatricula(String matriculaAnterior) {
        // Validar la matrícula anterior
        if (matriculaAnterior == null || !matriculaAnterior.matches("\\d{4} [BCDFGHJKLMNPRSTVWXYZ]{3}")) {
            throw new IllegalArgumentException("Formato de matrícula inválido.");
        }

        // Letras permitidas en las matrículas españolas
        String LETRAS_PERMITIDAS = "BCDFGHJKLMNPRSTVWXYZ";

        // Descomponer la matrícula en números y letras
        String numerosParte = matriculaAnterior.substring(0, 4);
        String letrasParte = matriculaAnterior.substring(5);

        // Incrementar la parte numérica
        int numeroActual = Integer.parseInt(numerosParte);
        numeroActual++;

        // Si se supera el límite, reiniciar los números y avanzar las letras
        if (numeroActual > 9999) {
            numeroActual = 0;

            // Incrementar las letras
            char[] letrasArray = letrasParte.toCharArray();
            int primeraLetra = LETRAS_PERMITIDAS.indexOf(letrasArray[0]);
            int segundaLetra = LETRAS_PERMITIDAS.indexOf(letrasArray[1]);
            int terceraLetra = LETRAS_PERMITIDAS.indexOf(letrasArray[2]);

            // Avanzar la última letra primero
            terceraLetra++;
            if (terceraLetra == LETRAS_PERMITIDAS.length()) {
                terceraLetra = 0;
                segundaLetra++;

                if (segundaLetra == LETRAS_PERMITIDAS.length()) {
                    segundaLetra = 0;
                    primeraLetra++;

                    if (primeraLetra == LETRAS_PERMITIDAS.length()) {
                        throw new IllegalArgumentException("Se han agotado todas las combinaciones posibles de matrículas.");
                    }
                }
            }

            // Reconstruir las letras
            letrasParte = "" + LETRAS_PERMITIDAS.charAt(primeraLetra) +
                    LETRAS_PERMITIDAS.charAt(segundaLetra) +
                    LETRAS_PERMITIDAS.charAt(terceraLetra);
        }

        // Formatear la parte numérica y generar la nueva matrícula
        return String.format("%04d %s", numeroActual, letrasParte);
    }



    public void mostarIforacionVenta(){
        System.out.println("Escribe el id de la venta");
        String id = MyInPut.readString();
        Venta v = getConcesionario().recuperarVenta(id);
        v.mostrarInformacion();
    }

    @Override
    public String seleccion(String s) {
        switch (s) {
            case "1": {
                registarVenta();
                return "s";
            }
            case "2": {
                mostarIforacionVenta();
                return "s";
            }
            case "3": {
                getConcesionario().mostarVentas();
                return "s";
            }
            case "0": {
                return "n";
            }
        }return "";
    }


    @Override
    public void opciones() {
        System.out.println(" ");
        System.out.println("Gestion de Ventas");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1. Registrar una Venta.");
        System.out.println("2. Mostrar Informacion de un venta concreta.");
        System.out.println("3. Mostrar informacion de todas las ventas.");
        System.out.println("0. Salir.");

    }
}