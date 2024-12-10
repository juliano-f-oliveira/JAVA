package br.com.desafio.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import br.com.desafio.model.ConsultaCep;


@Service
public class CepDAO {
	

	 private final JdbcTemplate jdbcTemplate;

	    @Autowired
	    public CepDAO(JdbcTemplate jdbcTemplate) {
	        this.jdbcTemplate = jdbcTemplate;
	    }

	    public void salvarConsulta(String cep, String resultadoJson) {
	        String sql = "INSERT INTO consultas_cep (cep, resultado) VALUES (?, ?::jsonb)";
	        jdbcTemplate.update(sql, cep, resultadoJson);
	        System.out.println("Consulta salva com sucesso!");
	    }
	    
	    public List<ConsultaCep> obterConsultas() {
	        String sql = "SELECT cep, resultado, data_hora FROM consultas_cep";
	        return jdbcTemplate.query(sql, new ConsultaCepRowMapper());
	    }

}
