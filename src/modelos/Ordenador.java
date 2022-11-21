package modelos;

import java.io.Serializable;

public class Ordenador implements Serializable {

    private int numSerie;
    private String marca;
    private String modelo;
    private int RAM;
    private float SSD;

    public Ordenador(int numSerie, String marca, String modelo, int RAM, float SSD) {
        this.numSerie = numSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.RAM = RAM;
        this.SSD = SSD;
    }

    public Ordenador() {
    }

    public int getNumSerie() {
        return numSerie;
    }

    public void setNumSerie(int numSerie) {
        this.numSerie = numSerie;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getRAM() {
        return RAM;
    }

    public void setRAM(int RAM) {
        this.RAM = RAM;
    }

    public float getSSD() {
        return SSD;
    }

    public void setSSD(float SSD) {
        this.SSD = SSD;
    }

    @Override
    public String toString() {
        return "Ordenador{" +
                "numSerie=" + numSerie +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                ", RAM=" + RAM +
                ", SSD=" + SSD +
                '}';
    }
}
