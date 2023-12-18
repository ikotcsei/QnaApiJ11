package somaog.QnaApiJ11;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;



@SpringBootApplication
public class QnaApiJ11Application extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(QnaApiJ11Application.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
		return builder.sources(QnaApiJ11Application.class);
	}
}
