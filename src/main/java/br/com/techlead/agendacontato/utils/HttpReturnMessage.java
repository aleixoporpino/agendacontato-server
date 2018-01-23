package br.com.techlead.agendacontato.utils;

/**
* Classe de apoio dos serviços rest.
*
* @author  José Aleixo Araujo Porpino Filho
* @version 1.0
* @since   19/01/2018 
*/
public class HttpReturnMessage {
	private int codigoErro; // 0 - OK, 1 - Erro, 2 - Exception
	private String mensagem;
	private Object objeto;
	
	public HttpReturnMessage(int codigoErro, String mensagem, Object objeto) {
		super();
		this.codigoErro = codigoErro;
		this.mensagem = mensagem;
		this.objeto = objeto;
	}
	
	public HttpReturnMessage() {
	}

	public int getCodigoErro() {
		return codigoErro;
	}
	public void setCodigoErro(int codigoErro) {
		this.codigoErro = codigoErro;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	public Object getObjeto() {
		return objeto;
	}
	public void setObjeto(Object objeto) {
		this.objeto = objeto;
	}
	@Override
	public String toString() {
		return "HttpReturnMessage [codigoErro=" + codigoErro + ", mensagem=" + mensagem + ", objeto=" + objeto + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoErro;
		result = prime * result + ((mensagem == null) ? 0 : mensagem.hashCode());
		result = prime * result + ((objeto == null) ? 0 : objeto.hashCode());
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
		HttpReturnMessage other = (HttpReturnMessage) obj;
		if (codigoErro != other.codigoErro)
			return false;
		if (mensagem == null) {
			if (other.mensagem != null)
				return false;
		} else if (!mensagem.equals(other.mensagem))
			return false;
		if (objeto == null) {
			if (other.objeto != null)
				return false;
		} else if (!objeto.equals(other.objeto))
			return false;
		return true;
	}
}
