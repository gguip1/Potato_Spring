package Potato.Potato_Spring.controller;

import Potato.Potato_Spring.domain.Post;
import Potato.Potato_Spring.service.APIService;
import Potato.Potato_Spring.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

public class PostController {
    private final PostService postService;

    @Autowired
    public PostController(APIService apiService, PostService postService) {
        this.postService = postService;
    }

    @GetMapping("members/test")
    public String testForm(){
        return "members/test";
    }

    @PostMapping("members/test")
    public String create(PostForm postForm){
        Post post = new Post();
        post.setPost_id(postForm.getPost_id());
        post.setTitle(postForm.getTitle());
        post.setAuthor_id(postForm.getAuthor_id());
        post.setContent(postForm.getContent());
        post.setCreated_at(postForm.getCreated_at());

        postService.save(post);

        return "redirect:/";
    }
}
