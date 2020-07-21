package br.com.luxfacta.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.luxfacta.model.dto.NewPollDto;
import br.com.luxfacta.model.dto.PollDto;
import br.com.luxfacta.model.dto.PollResponseDto;
import br.com.luxfacta.model.dto.StatsResponseDto;
import br.com.luxfacta.model.dto.VoteDto;
import br.com.luxfacta.model.dto.VoteQuantityDto;
import br.com.luxfacta.model.entidades.Poll;
import br.com.luxfacta.model.entidades.PollOption;
import br.com.luxfacta.repositories.PollOptionRepository;
import br.com.luxfacta.repositories.PollRepository;

@Service
public class ApiService {

	@Autowired
	private PollRepository pollRepository;

	@Autowired
	private PollOptionRepository pollOptionRepository;

	/**
	 * Obtém enquete por id
	 * 
	 * @param poll_id
	 * @return - PollDto
	 */
	public PollDto obterEnquete(long poll_id) {

		Poll poll = pollRepository.findById(poll_id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "enquete não encontrada"));
		return PollDto.parse(poll);
	}

	/**
	 * Cria um nova enquete
	 * 
	 * @param novaEnquete
	 * @return - PollResponseDto
	 */
	public PollResponseDto criaEnquete(NewPollDto novaEnquete) {

		List<PollOption> listaOpcoes = new ArrayList<PollOption>();
		Poll poll = new Poll();

		for (int i = 0; i < novaEnquete.getOptions().length; i++) {
			PollOption opcao = new PollOption(novaEnquete.getOptions()[i]);
			opcao.setPoll(poll);
			opcao.setVotes(0);
			listaOpcoes.add(opcao);
		}

		poll.setDescription(novaEnquete.getPoll_description());
		poll.setOptions(listaOpcoes);
		pollRepository.save(poll);
		return new PollResponseDto(poll.getId());
	}

	/**
	 * Registra voto para a enquete
	 * 
	 * @param poll_id
	 * @param novoVoto
	 * @return
	 */
	public void registraVoto(long poll_id, VoteDto novoVoto) {

		Poll poll = pollRepository.findById(poll_id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "enquete não encontrada"));

		PollOption pollOption = pollOptionRepository.findById(novoVoto.getOption_id()).orElseThrow(
				() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "opção de enquete não encontrada"));

		// só necessito do poll_id caso queira validar que a opção pertence ao poll
		// e mesmo que queira validar, poderia enviar dentro do VoteDto o poll_id
		if (!pollOption.getPoll().getId().equals(poll.getId())) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "enquete não encontrada");
		}

		pollOption.setVotes(pollOption.getVotes() + 1);
		pollOptionRepository.save(pollOption);
	}

	/**
	 * Obtém estatística da enquete
	 * 
	 * @param poll_id
	 * @return
	 */
	public StatsResponseDto obterEstatisticas(long poll_id) {

		// obtém quantidade de views da enquete
		int views = pollOptionRepository.obterViews(poll_id);

		// obtém todas as opções da enquete
		List<PollOption> listaOpcoes = pollOptionRepository.obterOpcoesPorEnquete(poll_id);

		int i = 0;
		VoteQuantityDto[] votosAgrupados = new VoteQuantityDto[listaOpcoes.size()];

		for (PollOption option : listaOpcoes) {
			votosAgrupados[i] = VoteQuantityDto.parse(option);
			i++;
		}

		StatsResponseDto response = new StatsResponseDto();
		response.setViews(views);
		response.setVotes(votosAgrupados);
		return response;
	}

}
