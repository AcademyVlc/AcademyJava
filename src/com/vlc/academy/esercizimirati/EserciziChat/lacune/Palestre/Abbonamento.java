package com.vlc.academy.esercizimirati.EserciziChat.lacune.Palestre;

public class Abbonamento {
    private Cliente cliente;
    private Palestra palestra;
//    private String codiceCLiente;
//    private String nomePalestra;
    private TipoAbbonamento tipo;
    private double prezzoMensile;

    public Abbonamento(Cliente cliente, Palestra palestra, TipoAbbonamento tipo, double prezzoMensile) {
        this.cliente = cliente;
        this.palestra = palestra;
        this.tipo = tipo;
        this.prezzoMensile = prezzoMensile;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Palestra getPalestra() {
        return palestra;
    }

    public void setPalestra(Palestra palestra) {
        this.palestra = palestra;
    }

    public TipoAbbonamento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAbbonamento tipo) {
        this.tipo = tipo;
    }

    public double getPrezzoMensile() {
        return prezzoMensile;
    }

    public void setPrezzoMensile(double prezzoMensile) {
        this.prezzoMensile = prezzoMensile;
    }
}
