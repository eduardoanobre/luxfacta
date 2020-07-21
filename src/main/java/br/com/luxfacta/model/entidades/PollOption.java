package br.com.luxfacta.model.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.luxfacta.model.Entidade;
import br.com.luxfacta.model.dto.PollOptionDto;

@Table(name = "poll_option", catalog = "api_desafio")
@Entity
public class PollOption implements Entidade {

	/**
	 * Construtor default
	 */
	public PollOption() {

	}

	/**
	 * Contrutor com descição
	 * 
	 * @param description
	 */
	public PollOption(String description) {
		setDescription(description);
	}

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -3562294810689290892L;

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "description")
	private String description;

	@ManyToOne
	private Poll poll;

	@Column(name = "votes")
	private int votes;

	// getters and setters

	public Long getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Poll getPoll() {
		return poll;
	}

	public void setPoll(Poll poll) {
		this.poll = poll;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PollOption other = (PollOption) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PollOption [id=" + id + ", description=" + description + ", poll=" + poll + "]";
	}

	/**
	 * Faz o parse de PollOptionDto para PollOption
	 * 
	 * @param pollOptionDto
	 * @return
	 */
	public static PollOption parse(PollOptionDto pollOptionDto) {
		PollOption pollOption = new PollOption();
		pollOption.setId(pollOptionDto.getOption_id());
		pollOption.setDescription(pollOptionDto.getOption_description());
		return pollOption;
	}

}
