package br.com.luxfacta.model.dto;

import java.io.Serializable;
import java.util.Arrays;

import br.com.luxfacta.model.entidades.Poll;
import br.com.luxfacta.model.entidades.PollOption;

/**
 * 
 * Entidade de enquetes
 *
 */
public class PollDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -7361574264483937412L;

	/**
	 * id de enquete
	 */
	private long poll_id;

	/**
	 * descrição da enquete
	 */
	private String poll_description;

	/**
	 * Lista de opções da enquete
	 */
	private PollOptionDto[] options;

	// getters and setters

	public long getPoll_id() {
		return poll_id;
	}

	public String getPoll_description() {
		return poll_description;
	}

	public PollOptionDto[] getOptions() {
		return options;
	}

	public void setPoll_id(long poll_id) {
		this.poll_id = poll_id;
	}

	public void setPoll_description(String poll_description) {
		this.poll_description = poll_description;
	}

	public void setOptions(PollOptionDto[] options) {
		this.options = options;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (poll_id ^ (poll_id >>> 32));
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
		PollDto other = (PollDto) obj;
		if (poll_id != other.poll_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PollDto [poll_id=" + poll_id + ", poll_description=" + poll_description + ", options="
				+ Arrays.toString(options) + "]";
	}

	/**
	 * Faz o parse de Poll para PollDto
	 * 
	 * @param poll
	 * @return - PollDto
	 */
	public static PollDto parse(Poll poll) {

		PollOptionDto[] options = new PollOptionDto[poll.getOptions().size()];

		int i = 0;
		for (PollOption option : poll.getOptions()) {
			options[i] = PollOptionDto.parse(option);
			i++;
		}

		PollDto pollDto = new PollDto();
		pollDto.setPoll_id(poll.getId());
		pollDto.setPoll_description(poll.getDescription());
		pollDto.setOptions(options);
		return pollDto;
	}

}
