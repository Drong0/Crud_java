package com.example.demo.Controllers;

import com.example.demo.Models.User;
import com.example.demo.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/")
public class MainController {
    @Autowired
    private UserRepo repo;

    @PostMapping("/save")
    public ResponseEntity Register(@RequestBody User user){

        repo.save(user);
        return ResponseEntity.ok(user);
    }


    @GetMapping("/read") public ResponseEntity readUserById() {

        Iterable<User> user = repo.findAll();
        return ResponseEntity.ok(user);
    }

    @PostMapping("/delete")
    public ResponseEntity deleteById(@RequestParam int id){

        repo.deleteById(id);
        return ResponseEntity.ok("Deleted");
    }
    @PostMapping("/update")
    public ResponseEntity updateById(@RequestParam int id, @RequestBody User user){
        User userFromDb = repo.findById(id).get();
        userFromDb.setUser_email(user.getUser_email());
        userFromDb.setSubscription(user.isSubscription());
        userFromDb.setUser_name(user.getUser_name());
        repo.save(userFromDb);
        repo.findById(id).get().setUser_name(user.getUser_name());
        return ResponseEntity.ok(user);

    }




}
