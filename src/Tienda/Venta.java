package Tienda;

import java.util.Date;

public class Venta {
    private String ID; //Identificador de 9 digitos
    private Cliente cliente;
    private Date fecha;
    private Coche coche;
    private DecoradorCoche mejoras;
    private float precio;


    public Venta() {

    }

    //Metodos
    public void asignarMatricula(Matricula m, Coche c){
        c.setMatricula(m.generarMatricula());
    }

}
