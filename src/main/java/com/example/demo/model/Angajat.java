package com.example.demo.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Angajat {
    public int id;
    @NotNull
    public String nume;
    @NotNull
    public String prenume;
    @NotNull
    @Size(min=13, message = "Cnp-ul trebuie sa aiba 13 caractere!")
    @Size(max=13, message = "Cnp-ul trebuie sa aiba 13 caractere!")
    public String cnp;
    @NotNull
    public String post;

    public Angajat() {
    }

    public Angajat(int id, String nume, String prenume, String CNP, String post) {
        this.id = id;
        this.nume = nume;
        this.prenume = prenume;
        this.cnp = CNP;
        this.post = post;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
