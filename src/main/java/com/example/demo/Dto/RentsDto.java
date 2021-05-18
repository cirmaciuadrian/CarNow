package com.example.demo.Dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Date;

public class RentsDto {
    public String numeComplet;
    public String nrInmatriculare;
    public String masina;
    @JsonFormat(pattern = "YYYY-MM-dd")
    public Date dataInchiriere;
    @JsonFormat(pattern = "YYYY-MM-dd")
    public Date dataFinalizare;
    public int pretTotal;

    public RentsDto() {
    }

    public RentsDto(String numeComplet, String nrInmatriculare, String masina, Date dataInchiriere, Date dataFinalizare, int pretTotal) {
        this.numeComplet = numeComplet;
        this.nrInmatriculare = nrInmatriculare;
        this.masina = masina;
        this.dataInchiriere = dataInchiriere;
        this.dataFinalizare = dataFinalizare;
        this.pretTotal = pretTotal;
    }

    public String getNumeComplet() {
        return numeComplet;
    }

    public void setNumeComplet(String numeComplet) {
        this.numeComplet = numeComplet;
    }

    public String getNrInmatriculare() {
        return nrInmatriculare;
    }

    public void setNrInmatriculare(String nrInmatriculare) {
        this.nrInmatriculare = nrInmatriculare;
    }

    public String getMasina() {
        return masina;
    }

    public void setMasina(String masina) {
        this.masina = masina;
    }

    public Date getDataInchiriere() {
        return dataInchiriere;
    }

    public void setDataInchiriere(Date dataInchiriere) {
        this.dataInchiriere = dataInchiriere;
    }

    public Date getDataFinalizare() {
        return dataFinalizare;
    }

    public void setDataFinalizare(Date dataFinalizare) {
        this.dataFinalizare = dataFinalizare;
    }

    public int getPretTotal() {
        return pretTotal;
    }

    public void setPretTotal(int pretTotal) {
        this.pretTotal = pretTotal;
    }
}
