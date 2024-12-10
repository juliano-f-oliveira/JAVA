package br.com.desafio.dao;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import br.com.desafio.model.ConsultaCep;

public class ConsultaCepRowMapper implements RowMapper<ConsultaCep>{
	
	@Override
    public ConsultaCep mapRow(ResultSet rs, int rowNum) throws SQLException {
        ConsultaCep consulta = new ConsultaCep();
        consulta.setCep(rs.getString("cep"));
        consulta.setResultado(rs.getString("resultado"));
        consulta.setDataHora(rs.getString("data_hora"));
        return consulta;
    }

}
