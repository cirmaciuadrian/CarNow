package com.example.demo.repository;

import com.example.demo.model.Client;
import com.example.demo.model.Masina;
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
public class MasinaRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Optional<Masina> getMasinaById(int id){
        return jdbcTemplate.query(Querys.GET_MASINA_BY_ID, new BeanPropertyRowMapper<>(Masina.class), id).stream().findFirst();
    }

    public Masina addMasina (Masina masina){
        PreparedStatementCreator preparedStatementCreator = connection -> {
            PreparedStatement preparedStatement = connection.prepareStatement(Querys.ADD_MASINA, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, masina.getFirma());
            preparedStatement.setString(2, masina.getModel());
            preparedStatement.setInt(3, masina.getCapacitateCilindrica());
            preparedStatement.setInt(4,masina.getPutere());
            preparedStatement.setString(5, masina.getCuloare());
            preparedStatement.setString(6, masina.getNrInmatriculare());
            preparedStatement.setBoolean(7, masina.isInchiriata());
            preparedStatement.setInt(8, masina.getPret());
            return preparedStatement;
        };
        GeneratedKeyHolder generatedKeyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(preparedStatementCreator, generatedKeyHolder);

        masina.setId(generatedKeyHolder.getKey().intValue());
        return masina;
    }

    public List<Masina> getMasiniByNrInmatriculare(String nrInmatriculare){
        String sql = "SELECT * FROM masini WHERE masini.NrInmatriculare LIKE '%" + nrInmatriculare + "%'";
        List<Masina> masini = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Masina.class));
        return masini;
    }

    public List<Masina> getMasini (){
        return jdbcTemplate.query(Querys.GET_MASINI, new BeanPropertyRowMapper<>(Masina.class));
    }

    public List<Masina> searchMasini(String cautare){
        String sql = "SELECT * FROM masini WHERE NrInmatriculare LIKE '%"+cautare+"%' or Model LIKE '%"+cautare+"%' or Firma LIKE '%"+cautare+"%' or culoare LIKE '%"+cautare+"%';";
        List<Masina> masini = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Masina.class));
        return masini;
    }


}
