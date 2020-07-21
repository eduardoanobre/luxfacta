package br.com.luxfacta.model.dto;

import java.io.Serializable;

/**
 * 
 * Voto da enquete
 *
 */
public class VoteDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 8424929425508634291L;

	/**
	 * id de opção do voto
	 */
	private long option_id;

	// getters and setters

	public long getOption_id() {
		return option_id;
	}

	public void setOption_id(long option_id) {
		this.option_id = option_id;
	}

}
