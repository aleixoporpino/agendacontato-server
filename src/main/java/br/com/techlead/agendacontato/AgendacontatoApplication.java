package br.com.techlead.agendacontato;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
/*@EnableResourceServer*/
@ComponentScan("br.com.techlead.agendacontato")
public class AgendacontatoApplication {

	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC-3"));
	}

	public static void main(String[] args) {
		SpringApplication.run(AgendacontatoApplication.class, args);
	}
	
}
