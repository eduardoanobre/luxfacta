package br.com.luxfacta.model.dto;

import java.io.Serializable;

/**
 * 
 * Response de nova enquete
 *
 */
public class StatsResponseDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -5345704601135216012L;

	/**
	 * views
	 */
	private int views;

	/**
	 * votes
	 */
	private VoteQuantityDto[] votes;

	// getters and setters

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public VoteQuantityDto[] getVotes() {
		return votes;
	}

	public void setVotes(VoteQuantityDto[] votes) {
		this.votes = votes;
	}

}
