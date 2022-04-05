package christof.at.gag2.controller;

import christof.at.gag2.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    public PostService postService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("test", "test123");
        return "index";
    }

    @GetMapping("/heiss")
    public String getTopPosts(Model model){
        model.addAttribute("posts", postService.getPostsForHomepage());

        return "heiss";
    }
}
