package com.example.demo.model;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Size;
import java.sql.Date;

public class Rent {
    public int id;
    public int idMasina;
    public int idClient;
    @FutureOrPresent(message = "Data de inchiriere trebuie sa fie din viitor sau din prezent")
    public Date dataInchiriere;
    @FutureOrPresent(message ="Data de finalizare trebuie sa fie din viitor sau din prezent")
    public Date dataFinalizare;
    @Size(min=10)
    public int pretTotal;

    public Rent() {
    }

    public Rent(int id, int idMasina, int idClient, Date dataInchiriere, Date dataFinalizare, int pretTotal) {
        this.id = id;
        this.idMasina = idMasina;
        this.idClient = idClient;
        this.dataInchiriere = dataInchiriere;
        this.dataFinalizare = dataFinalizare;
        this.pretTotal = pretTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMasina() {
        return idMasina;
    }

    public void setIdMasina(int idMasina) {
        this.idMasina = idMasina;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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
