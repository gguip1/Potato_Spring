//package Potato.Potato_Spring.service;
//
//import Potato.Potato_Spring.domain.Post;
//import Potato.Potato_Spring.repository.PostRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class PostService {
//    private final PostRepository postRepository;
//
//    @Autowired
//    public PostService(PostRepository postRepository){
//        this.postRepository = postRepository;
//    }
//
//    public String save(Post post){
//        postRepository.post(post);
//        return post.toString();
//    }
//}
