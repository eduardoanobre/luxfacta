package br.com.luxfacta.model.dto;

import java.io.Serializable;

import br.com.luxfacta.model.entidades.PollOption;

/**
 * 
 * Voto da enquete
 *
 */
public class VoteQuantityDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 8424929425508634291L;

	/**
	 * id de opção do voto
	 */
	private long option_id;

	/**
	 * Quantidade de votos computados
	 */
	private int qty;

	// getters and setters

	public long getOption_id() {
		return option_id;
	}

	public void setOption_id(long option_id) {
		this.option_id = option_id;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	/**
	 * Faz o parse de PollOption para VoteQuantityDto
	 * 
	 * @param option
	 * @return
	 */
	public static VoteQuantityDto parse(PollOption option) {
		VoteQuantityDto voteQuantityDto = new VoteQuantityDto();
		voteQuantityDto.setOption_id(option.getId());
		voteQuantityDto.setQty(option.getVotes());
		return voteQuantityDto;
	}

}
