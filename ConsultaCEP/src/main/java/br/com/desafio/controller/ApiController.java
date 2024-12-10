package br.com.desafio.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import br.com.desafio.dao.CepDAO;
import br.com.desafio.model.ConsultaCep;

@RestController
@RequestMapping("/api")
public class ApiController {
	
	//Consulta no ServerMock
	
	@GetMapping("/consultacep-mock")
    public String consultaCepMock(@RequestParam String cep) {
        String url = "http://localhost:8181/cep/" + cep;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        return response.getBody();
    }
	
	//Consulta em API Externa | Registro de evento em BD
	
	@Autowired
    private CepDAO cepDAO;
	
	@GetMapping("/consultacep-ext")
    public String consultaCepExt(@RequestParam String cep) {
        String url = "https://viacep.com.br/ws/" + cep + "/json/";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
        
        // Salvar a consulta no banco de dados
        cepDAO.salvarConsulta(cep, response.getBody());
        
        return response.getBody();
    }
	
	//GET de eventos em BD
	@GetMapping("/eventos")
    public List<ConsultaCep> listarConsultas() {
        return cepDAO.obterConsultas();
    }

}
