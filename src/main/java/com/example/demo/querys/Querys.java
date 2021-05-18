package com.example.demo.querys;

public class Querys {

    public final static String GET_CLIENTI_SQL = "select * from clienti";
    public final static String ADAUGA_CLIENT ="INSERT INTO clienti values (null,?,?,?)";
    public final static String EDIT_CLIENT = "update clienti c  set c.Nume=?,  c.Prenume = ?, c.ContBancar=? where c.Id = ?";
    public final static String GET_CLIENT_BY_ID = "select * from clienti where Id =?";
    public final static String GET_MASINA_BY_ID = "select * from masini where Id =?";
    public final static String ADD_MASINA = "insert into masini values (null, ?, ?, ?, ?, ?, ? ,? ,?)";
    public final static String GET_MASINI = "select * from masini";
    public final static String ADD_EXCEPTIONS = "insert into exceptions values (null, ?,?)";
    public final static String GET_RENTS ="select CONCAT(c.Nume,' ', c.Prenume) AS NumeComplet, m.NrInmatriculare, CONCAT(m.Firma,' ', m.Model) AS Masina , r.DataInchiriere, r.DataFinalizare , r.PretTotal from rents as r, masini as m, clienti as c where c.Id = r.IdClient and  m.Id = r.IdMasina";
    public final static String GET_CAR_BY_ID = "select * from masini where id = ?";
    public final static String ADD_RENT = "insert into rents values (null, ?, ?, ?, ?, ?)";
    public final static String GET_RENT_BY_ID ="select CONCAT(c.Nume,' ', c.Prenume) AS NumeComplet, m.NrInmatriculare, CONCAT(m.Firma,' ', m.Model) AS Masina , r.DataInchiriere, r.DataFinalizare , r.PretTotal from rents as r, masini as m, clienti as c where c.Id = r.IdClient and  m.Id = r.IdMasina and r.Id = ? ";
    public final static String SET_MASINA_INCHIRIATA = "UPDATE masini SET  Inchiriata = ? WHERE Id = ?";
    public final static String GET_RENT_FOR_FINISH = "SELECT * FROM rents where DataFinalizare Is NULL and IdMasina = ?";
    public final static String FINISH_RENT= "UPDATE rents SET DataFinalizare = ?, PretTotal = ? WHERE Id = ?;";
    public final static String GET_RENT_BY_ID_MASINA = "select CONCAT(c.Nume,' ', c.Prenume) AS NumeComplet, m.NrInmatriculare, CONCAT(m.Firma,' ', m.Model) AS Masina , r.DataInchiriere, r.DataFinalizare , r.PretTotal from rents as r, masini as m, clienti as c where c.Id = r.IdClient and  m.Id = r.IdMasina and m.Id = ? ";
    public final static String GET_ANGAJATI = "select * from angajati";
    public final static String ADD_ANGAJAT = "insert into angajati values (null,?,?,?,?)";
    public final static String CAUTA_ANGAJAT_DUPA_CNP= "select * from angajati where CNP = ?";
    public final static String DELET_ANGAJAT = "DELETE FROM angajati where Id = ?";
}
