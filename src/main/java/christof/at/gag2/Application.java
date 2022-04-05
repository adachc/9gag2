package christof.at.gag2;

import christof.at.gag2.model.Post;
import christof.at.gag2.repository.PostRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
public class Application {

//	@Autowired
//	private PostRepository repository;
//
//	@Bean
//	public void generatePosts(){
//		Faker faker = new Faker(new Locale("de-DE"), new Random(10));
//
//		for(int i = 0; i < 2000; i++) {
//			LocalDateTime ldt = LocalDateTime.ofInstant(faker.date()
//					.past(600, TimeUnit.DAYS).toInstant(), ZoneId.systemDefault());
//
//			Post post = Post.builder()
//					.text(faker.lorem().characters(10, 20, true))
//					.title(faker.chuckNorris().fact())
//					.votes(faker.number().numberBetween(-10, 1000))
//					.postTime(ldt)
//					.build();
//
//			repository.save(post);
//		}
//		System.out.println("Got here");
//	}



	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
