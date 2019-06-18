package kr.hs.dgsw.shoppingmall_back.Controller;

import kr.hs.dgsw.shoppingmall_back.Domain.User;
import kr.hs.dgsw.shoppingmall_back.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/getAllUsers")
    public List getAllUsers(){
        return this.userService.findAll();
    }

    @GetMapping("/getUser/{id}")
    public User getUser(@PathVariable Long id){
        return this.userService.findById(id);
    }

    @GetMapping("/loginUser/{account}")
    public User loginUser(@PathVariable String account){
        return this.userService.findByAccount(account);
    }

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user){
        return this.userService.addUser(user);
    }

    @PutMapping("/editUser")
    public User modifyUser(@RequestBody User user){
        return this.userService.editUser(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public boolean deleteUser(@PathVariable Long id){
        return this.userService.deleteById(id);
    }

}
