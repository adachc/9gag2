package christof.at.gag2.component;

import christof.at.gag2.model.Post;
import christof.at.gag2.repository.PostRepository;
import christof.at.gag2.service.PostService;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class TestPostLoader {

    @Autowired
    private PostService postService;
    @Autowired
    private PostRepository postRepository;

    @Bean
    public void TestPostBean() {
        Faker faker = new Faker(new Locale("de-DE"), new Random(10));

        for(int i = 0; i < 2000; i++) {
            LocalDateTime ldt = LocalDateTime.ofInstant(faker.date()
                    .past(600, TimeUnit.DAYS).toInstant(), ZoneId.systemDefault());

            Post post = Post.builder()
                    .title(faker.lorem().characters(10, 20, true))
                    .text(faker.chuckNorris().fact())
                    .votes(faker.number().numberBetween(-10, 1000))
                    .postTime(ldt)
                    .build();

            postRepository.save(post);

        }
        System.out.println("Testposts created");

    }
}
