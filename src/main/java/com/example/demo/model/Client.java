package com.example.demo.model;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Client {
    private int Id;
    @Size(max=45, message = "Numele nu poate avea mai mult de 100 de caracatere")
    @NotNull(message = "Numele nu poate fi null")
    private String Nume;
    @Size(max=45, message = "Prenumele nu poate avea mai mult de 100 de caracatere")
    @NotNull(message = "Prenumele nu poate fi null")
    private String Prenume;
    @NotNull(message = "Cardul bancar nu poate fi null")
    private String ContBancar;

    public Client(){}

    public Client(int ID, String nume, String prenume, String contBancar) {
        this.Id = ID;
        Nume = nume;
        Prenume = prenume;
        ContBancar = contBancar;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public String getNume() {
        return Nume;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public String getContBancar() {
        return ContBancar;
    }

    public void setContBancar(String contBancar) {
        ContBancar = contBancar;
    }
}
