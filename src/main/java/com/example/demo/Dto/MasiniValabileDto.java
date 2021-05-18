package com.example.demo.Dto;

public class MasiniValabileDto {
    public String numarInmatriculare;
    public String valabil;

    public MasiniValabileDto() {
    }

    public MasiniValabileDto(String numarInmatriculare, String valabil) {
        this.numarInmatriculare = numarInmatriculare;
        this.valabil = valabil;
    }

    public String getNumarInmatriculare() {
        return numarInmatriculare;
    }

    public void setNumarInmatriculare(String numarInmatriculare) {
        this.numarInmatriculare = numarInmatriculare;
    }

    public String getValabil() {
        return valabil;
    }

    public void setValabil(String valabil) {
        this.valabil = valabil;
    }
}
