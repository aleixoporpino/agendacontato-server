package br.com.techlead.agendacontato.utils;

import org.springframework.beans.factory.annotation.Autowired;

/**
* Classe de apoio possui objetos que são utilizados em todos os Controllers.
*
* @author  José Aleixo Araújo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
public class RestUtils<T> {
	
	@Autowired
	public T service;
	
	public HttpReturnMessage httpReturnMessage;

	public RestUtils() {
	}

	public T getService() {
		return service;
	}

	public void setService(T service) {
		this.service = service;
	}

	public HttpReturnMessage getHttpReturnMessage() {
		return httpReturnMessage;
	}

	public void setHttpReturnMessage(HttpReturnMessage httpReturnMessage) {
		this.httpReturnMessage = httpReturnMessage;
	}

}
