package br.uniamerica.taskq.controller.users;

import br.uniamerica.taskq.controller.dto.response.UserResponse;
import br.uniamerica.taskq.controller.dto.resquest.UserRequest;
import br.uniamerica.taskq.entity.User;
import br.uniamerica.taskq.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor

public class UserController {
    private final UserService userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponse> newUser(@RequestBody @Valid UserRequest userRequest){
        try {
            User user = this.userService.create(userRequest);
            return new ResponseEntity<UserResponse>(UserResponse.from(user), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/read")
    public ResponseEntity<List<UserResponse>> listUsers(){
        try{
            List<UserResponse> users = this.userService.findAll();
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody UserRequest userRequest){
        try {
            UserResponse user = userService.update(id, userRequest);
            return ResponseEntity.ok(user);

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<UserResponse> deleteUser(@PathVariable Long id){
        try {
            this.userService.delete(id);
            return ResponseEntity.noContent().build();

        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/addXp")
    public ResponseEntity<UserResponse> addXp(@PathVariable Long id, @RequestParam Long xp){
        try{
            UserResponse user = this.userService.addXp(id, xp);
            return ResponseEntity.ok(user);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

//    @PatchMapping("/{id}/removeXp")
//    public ResponseEntity<UserResponse> removeXp(@PathVariable Long id, @RequestParam Long xp){
//        try{
//            User user = this.userService.removeXp(id, xp);
//            return ResponseEntity.ok(UserResponse.from(user));
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
}
