package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.querys.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

@Repository
public class  ClientRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Client> getClienti(){
       List <Client> clienti = jdbcTemplate.query(Querys.GET_CLIENTI_SQL, new BeanPropertyRowMapper<>(Client.class));
        return clienti;
    }

    public List<Client> adaugaClient (Client client){
        jdbcTemplate.update(Querys.ADAUGA_CLIENT, client.getNume(), client.getPrenume(), client.getContBancar());
        return jdbcTemplate.query(Querys.GET_CLIENTI_SQL, new BeanPropertyRowMapper<>(Client.class));
    }

    public List<Client> editClientById (Client client){
        var id= client.getId();
        jdbcTemplate.update(Querys.EDIT_CLIENT, client.getNume(),  client.getPrenume(), client.getContBancar(), client.getId());
        var sql = "select * from clienti where clienti.Id =" + String.valueOf(id)+";";
        return jdbcTemplate.query(sql , new BeanPropertyRowMapper<>(Client.class));
    }



}
