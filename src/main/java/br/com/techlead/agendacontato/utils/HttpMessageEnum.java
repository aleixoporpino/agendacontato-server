package br.com.techlead.agendacontato.utils;

/**
 * Enum de mensagens de retorno http.
 *
 * @author José Aleixo Araujo Porpino Filho
 * @version 1.0
 * @since 19/01/2018
 */
public enum HttpMessageEnum {
    SUCCESS_SAVE("Saved successfully!"),
    SUCCESS_UPDATE("Updated successfully!"),
    SUCCESS_DELETE("Deleted successfully!");

    private String message;

    private HttpMessageEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
