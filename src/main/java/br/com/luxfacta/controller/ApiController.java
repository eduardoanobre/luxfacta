package br.com.luxfacta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.luxfacta.model.dto.NewPollDto;
import br.com.luxfacta.model.dto.PollDto;
import br.com.luxfacta.model.dto.PollResponseDto;
import br.com.luxfacta.model.dto.StatsResponseDto;
import br.com.luxfacta.model.dto.VoteDto;
import br.com.luxfacta.services.ApiService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "*")
@Api(value = "API Desafio Luxfacta")
@RestController
@RequestMapping(value = "/api/v1/luxfacta")
public class ApiController {

	@Autowired
	private ApiService service;

	@ApiOperation(value = "Index", response = String.class)
	@GetMapping("/")
	@ResponseBody
	public String index() throws Exception {
		return "API Desafio Luxfacta works!";
	}

	@ApiOperation(value = "retorna os dados de uma enquete", response = PollDto.class)
	@GetMapping("/poll/{id}")
	public PollDto obterEnquete(@PathVariable("id") long poll_id) {
		return service.obterEnquete(poll_id);
	}

	@ApiOperation(value = "cria nova enquete", response = PollResponseDto.class)
	@PostMapping(path = "/poll")
	public PollResponseDto criaEnquete(@RequestBody NewPollDto novaEnquete) {
		return service.criaEnquete(novaEnquete);
	}

	@ApiOperation(value = "registra um voto na enquete", response = void.class)
	@PostMapping(path = "/poll/{id}/vote")
	public void registraVoto(@PathVariable("id") long poll_id, @RequestBody VoteDto novoVoto) {
		service.registraVoto(poll_id, novoVoto);
	}

	@ApiOperation(value = "retorna estatística da enquete", response = StatsResponseDto.class)
	@GetMapping("/poll/{id}/stats")
	public StatsResponseDto obterEstatisticas(@PathVariable("id") long poll_id) {
		return service.obterEstatisticas(poll_id);
	}

}
