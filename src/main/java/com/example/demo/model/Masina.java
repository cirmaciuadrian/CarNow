package com.example.demo.model;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Masina {

    public int id;
    @Size(min = 1)
    @Size(max = 45)
    @NotNull(message = "Firma nu poate fi null")
    public String firma;

    @Size(min = 1)
    @Size(max = 45)
    @NotNull(message = "model nu poate fi null")
    public String model;

    @Min(value=10, message = "Capacitatea cilindrica trebuie sa fie mai mare de 10")
    @NotNull(message = "capacitateCilindrica nu poate fi null")
    public int capacitateCilindrica;

    @Min(value=10, message = "Puterea trebuie sa fie mai mare de 10")
    @NotNull(message = "putere nu poate fi null")
    public int putere;

    @Size(min = 1)
    @Size(max = 45)
    @NotNull(message = "culoare nu poate fi null")
    public String culoare;

    @Size(min = 1)
    @Size(max = 45)
    @NotNull(message = "nrInmatriculare nu poate fi null")
    public String nrInmatriculare;
    @NotNull(message = "inchiriata nu poate fi null")
    public boolean inchiriata;

    @Min(value=10, message = "Pretul trebuie sa fie mai mare de 10")
    @NotNull(message = "pret nu poate fi null")
    public int pret;

    public Masina() {
    }

    public Masina(int id, String firma, String model, int capacitateCilindrica, int putere, String culoare, String nrInmatriculare, boolean inchiriata, int pret) {
        this.id = id;
        this.firma = firma;
        this.model = model;
        this.capacitateCilindrica = capacitateCilindrica;
        this.putere = putere;
        this.culoare = culoare;
        this.nrInmatriculare = nrInmatriculare;
        this.inchiriata = inchiriata;
        this.pret = pret;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirma() {
        return firma;
    }

    public void setFirma(String firma) {
        this.firma = firma;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacitateCilindrica() {
        return capacitateCilindrica;
    }

    public void setCapacitateCilindrica(int capacitateCilindrica) {
        this.capacitateCilindrica = capacitateCilindrica;
    }

    public int getPutere() {
        return putere;
    }

    public void setPutere(int putere) {
        this.putere = putere;
    }

    public String getCuloare() {
        return culoare;
    }

    public void setCuloare(String culoare) {
        this.culoare = culoare;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public boolean isInchiriata() {
        return inchiriata;
    }

    public void setInchiriata(boolean inchiriata) {
        this.inchiriata = inchiriata;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }
}
