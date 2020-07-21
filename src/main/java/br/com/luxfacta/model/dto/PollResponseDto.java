package br.com.luxfacta.model.dto;

import java.io.Serializable;

/**
 * 
 * Response de nova enquete
 *
 */
public class PollResponseDto implements Serializable {

	/**
	 * construtor default
	 * 
	 * @param id
	 */
	public PollResponseDto(long id) {
		this.poll_id = id;
	}

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 7842255312093825813L;

	/**
	 * id de enquete
	 */
	private long poll_id;

	// getters and setters

	public long getPoll_id() {
		return poll_id;
	}

	public void setPoll_id(long poll_id) {
		this.poll_id = poll_id;
	}

}
