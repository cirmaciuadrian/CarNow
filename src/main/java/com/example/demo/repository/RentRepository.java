package com.example.demo.repository;

import com.example.demo.Dto.Message;
import com.example.demo.Dto.RentsDto;
import com.example.demo.model.Client;
import com.example.demo.model.Masina;
import com.example.demo.model.Rent;
import com.example.demo.querys.Querys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.List;
import java.util.Optional;

@Repository
public class RentRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<RentsDto> getAll(){
        return jdbcTemplate.query(Querys.GET_RENTS, new BeanPropertyRowMapper<>(RentsDto.class));
    }

    public boolean carExits(int id){
        var masina =  jdbcTemplate.query(Querys.GET_CAR_BY_ID, new BeanPropertyRowMapper<>(Masina.class), id).stream().findFirst();
        if(masina.isPresent())
            return true;
        return false;
    }

    public boolean clientExists(int id){
        var client =  jdbcTemplate.query(Querys.GET_CLIENT_BY_ID, new BeanPropertyRowMapper<>(Client.class), id).stream().findFirst();
        if(client.isPresent())
            return true;
        return false;
    }

    public boolean carIsFree(int id){
        var masina =  jdbcTemplate.query(Querys.GET_CAR_BY_ID, new BeanPropertyRowMapper<>(Masina.class), id).stream().findFirst().get();
        if(masina.isInchiriata())
            return false;
        return true;
    }

    public RentsDto addRent(Rent rent){
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(Querys.ADD_RENT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setInt(1, rent.getIdMasina());
            preparedStatement.setInt(2, rent.getIdClient());
            preparedStatement.setDate(3, rent.getDataInchiriere());
            preparedStatement.setDate(4,rent.getDataFinalizare());
            preparedStatement.setInt(5, rent.getPretTotal());

            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

         int id = generatedKeyHolder.getKey().intValue();
        return jdbcTemplate.query(Querys.GET_RENT_BY_ID, new BeanPropertyRowMapper<>(RentsDto.class), id).stream().findFirst().get();
    }

    public void markCarAsBusy(int id){
        jdbcTemplate.update(Querys.SET_MASINA_INCHIRIATA, 1,  id);
    }

    public void markCarAsFree(int id){
        jdbcTemplate.update(Querys.SET_MASINA_INCHIRIATA, 0,  id);
    }

    public Optional<Rent> getDataInceput(int idMasina){
        return jdbcTemplate.query(Querys.GET_RENT_FOR_FINISH, new BeanPropertyRowMapper<>(Rent.class), idMasina).stream().findFirst();
    }

    public int getPretMasina(int id){
        return jdbcTemplate.query(Querys.GET_MASINA_BY_ID, new BeanPropertyRowMapper<>(Masina.class), id).stream().findFirst().get().getPret();
    }

    public boolean finishRent(Rent rent){
        var id = rent.getId();
        jdbcTemplate.update(Querys.FINISH_RENT, rent.getDataFinalizare(), rent.getPretTotal(),rent.getId());
        return true;
    }

    public List<RentsDto> getIstoricMasina(int id){
        return jdbcTemplate.query(Querys.GET_RENT_BY_ID_MASINA, new BeanPropertyRowMapper<>(RentsDto.class), id);

    }



}
