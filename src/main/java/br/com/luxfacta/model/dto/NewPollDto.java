package br.com.luxfacta.model.dto;

import java.io.Serializable;

/**
 * 
 * nova enquete
 *
 */
public class NewPollDto implements Serializable {

	/**
	 * serial UID
	 */
	private static final long serialVersionUID = 9018438237337322283L;

	/**
	 * descrição da enquete
	 */
	private String poll_description;

	/**
	 * Lista de opções da enquete
	 */
	private String[] options;

	// getters and setters

	public String getPoll_description() {
		return poll_description;
	}

	public void setPoll_description(String poll_description) {
		this.poll_description = poll_description;
	}

	public String[] getOptions() {
		return options;
	}

	public void setOptions(String[] options) {
		this.options = options;
	}

}
