package br.com.luxfacta.model.dto;

import java.io.Serializable;

import br.com.luxfacta.model.entidades.PollOption;

public class PollOptionDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = -7361574264483937412L;

	/***
	 * option_id
	 */
	private long option_id;

	/**
	 * option_description
	 */
	private String option_description;

	// getters and setters

	public long getOption_id() {
		return option_id;
	}

	public String getOption_description() {
		return option_description;
	}

	public void setOption_id(long option_id) {
		this.option_id = option_id;
	}

	public void setOption_description(String option_description) {
		this.option_description = option_description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (option_id ^ (option_id >>> 32));
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
		PollOptionDto other = (PollOptionDto) obj;
		if (option_id != other.option_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PollOptionDto [option_id=" + option_id + ", option_description=" + option_description + "]";
	}

	/**
	 * Faz o parse da PollOption para PollOptionDto
	 * 
	 * @param option
	 * @return - PollOptionDto
	 */
	public static PollOptionDto parse(PollOption option) {
		PollOptionDto pollOptionDto = new PollOptionDto();
		pollOptionDto.setOption_id(option.getId());
		pollOptionDto.setOption_description(option.getDescription());
		return pollOptionDto;
	}

}
