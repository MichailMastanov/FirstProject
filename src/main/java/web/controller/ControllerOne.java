package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.DaoUser;
import web.dao.UserRepositories;
import web.model.User;

import java.security.Principal;

@Controller
public class ControllerOne {

    private DaoUser daoUser;

    @Autowired
    public void setDaoUser(DaoUser daoUser){
        this.daoUser = daoUser;
    }

    private UserRepositories userRepositories;

    @Autowired
    public void setUserRepositories(UserRepositories userRepositories) {
        this.userRepositories = userRepositories;
    }

    @GetMapping("/user")
    public String openUser(Principal principal, Model model){
        User userName = (User)userRepositories.findByUsername(principal.getName());
        model.addAttribute("user", userName);
        return "user";
    }

    @GetMapping("/")
    public String newAct(){
        return "new";
    }

    @GetMapping("/admin")
    public String usersAll(Model model){
        model.addAttribute("xxx", daoUser.getUsers());
        return "hello";
    }

    @GetMapping("/new")
    public String newCar(Model model){
        model.addAttribute("nUser", new User());
        return "newUser";
    }

    @GetMapping("/create_user")
    public String createUser(@ModelAttribute("newUser") User user){
        daoUser.save(user);
        return "redirect:/admin";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam Long id){
        daoUser.removeUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/update")
    public String updateUser(@ModelAttribute("newUser") User user, Model model){
        model.addAttribute("upUser", user);
        return "updateUser";
    }

    @GetMapping("/up_user")
    public String updateUs(@ModelAttribute("upUser") User user, Model model){
        daoUser.upUs(user);
        model.addAttribute("xxx", daoUser.getUsers());
        return "redirect:/admin";
    }

}

