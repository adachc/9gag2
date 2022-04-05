package christof.at.gag2.service;

import christof.at.gag2.model.Post;
import christof.at.gag2.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.TemporalUnit;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service
public class PostService {

    private PostRepository repository;

    @Autowired
    public PostService(PostRepository repository) {
        this.repository = repository;
    }

    public List<Post> getPostsForHomepage(){
        return repository.findAll()
                .stream()
                .filter(post -> post.getPostTime().isAfter(LocalDateTime.now().minusDays(7)))
                .sorted((o1, o2) -> -Long.compare(o1.getVotes(), o2.getVotes()))
                .limit(10)
                .collect(Collectors.toList());
    }
}
