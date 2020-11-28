////////////////////////////////////////////////////////////////////
// [DANIELE] [SPIGOLON] [1193290]
////////////////////////////////////////////////////////////////////
package it.unipd.tos.model;

import java.util.List;

public class InvoiceTotal {
    private List<MenuItem> lista;
    private User user;
    private int tempoInSecondi;
    private double price;

    public InvoiceTotal(List<MenuItem> lista, User user, int tempoInSecondi, double price) {
        this.lista = lista;
        this.user = user;
        this.tempoInSecondi = tempoInSecondi;
        this.price = price;
    }

    public List<MenuItem> getLista() {
        return lista;
    }

    public User getUser() {
        return user;
    }

    public int gettempoInSecondi() {
        return tempoInSecondi;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double p){
        price = p;
    }
}