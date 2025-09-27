package com.sena.introductionMaven.CrediSystem;

import java.util.ArrayList;
import java.util.List;

public class Prestamo {
    private String name;
    private List<Deudor> listaDeudas;   // "me deben"
    private List<Deudor> listaPrestamos; // "Debo"

    public Prestamo(String name) {
        this.name = name;
        this.listaDeudas = new ArrayList<>();
        this.listaPrestamos = new ArrayList<>();
    }


    public void addDeudor(Deudor deudor, String tipo) {
        if ("preste".equalsIgnoreCase(tipo)) {
            listaDeudas.add(deudor);
        } else if ("debo".equalsIgnoreCase(tipo)) {
            listaPrestamos.add(deudor);
        }
    }


    public void deleteDeudor(Deudor deudor, String tipo) {
        if ("preste".equalsIgnoreCase(tipo)) {
            listaDeudas.remove(deudor);
        } else if ("debo".equalsIgnoreCase(tipo)) {
            listaPrestamos.remove(deudor);
        }
    }


    public void updateDeudor(Deudor deudor) {

    }


    public List<Deudor> getListaDeudas() { return listaDeudas; }
    public List<Deudor> getListaPrestamos() { return listaPrestamos; }
}
