package com.example.demo.repository;

import com.example.demo.model.Angajat;
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
public class AngajatRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Angajat> getAll(){
       return jdbcTemplate.query(Querys.GET_ANGAJATI, new BeanPropertyRowMapper<>(Angajat.class));
    }

    public Angajat addAngajat(Angajat angajat){
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(Querys.ADD_ANGAJAT, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, angajat.getNume());
            preparedStatement.setString(2, angajat.getPrenume());
            preparedStatement.setString(3, angajat.getCnp());
            preparedStatement.setString(4,angajat.getPost());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        angajat.setId(generatedKeyHolder.getKey().intValue());
        return angajat;
    }

    public Optional<Angajat> cautaAngajatDupaCnp(String CNP){
        return jdbcTemplate.query(Querys.CAUTA_ANGAJAT_DUPA_CNP, new BeanPropertyRowMapper<>(Angajat.class), CNP).stream().findFirst();
    }

    public boolean stergeAngajat(int id){
        jdbcTemplate.update(Querys.DELET_ANGAJAT, id);
        return true;
    }
}
