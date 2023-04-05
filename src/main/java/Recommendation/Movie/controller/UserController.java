package Recommendation.Movie.controller;


import Recommendation.Movie.entity.UserEntity;
import Recommendation.Movie.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @GetMapping("/home")
    public String home()
    {
        return "Home Page";
    }
    @PostMapping("/createUser")
    public ResponseEntity creteUser( @RequestBody UserEntity userDetails)
    {
     return ResponseEntity.ok(userService.createUser(userDetails));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity getUser(@PathVariable String id)
    {
        return ResponseEntity.ok(userService.getUser(id));
    }
    @GetMapping("/user/{id}/movie")
    public String getMovie(@PathVariable String id) {


        return userService.getRecommendation(Integer.parseInt(id));
    }
    @GetMapping("/user/{id}/history")
    public List<String> getMovieHistory(@PathVariable String id) {
        return userService.getHistory(Integer.parseInt(id));
    }

    @GetMapping("/user/{id}/reset")
    public void resetHistory(@PathVariable String id)
    {
        userService.getReset(Integer.parseInt((id)));
    }

}
