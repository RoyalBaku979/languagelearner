package com.company.controller;


import com.company.dao.impl.UserDaoInter;
import com.company.form.UserForm;
import com.company.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserDaoInter userDao;

    @GetMapping
    public String getUsers(ModelMap model,
                           @RequestParam(name="name", required = false) String name,
                           @RequestParam(name="surname", required = false) String surname){

        List<User> users = null;
        if(name!=null && !name.trim().isEmpty()) {
            users = userDao.getAll(name);
        }else{
            users = userDao.getAll();//MODEL - View - Controller
        }

        model.addAttribute("users", users);
        return "/users";
    }

    @GetMapping("/{id}/edit")
    public String editUserPage(ModelMap model,
                           @PathVariable(name="id") int userId){
        User user = userDao.getById(userId);
        model.addAttribute("user", user);
        return "/useredit";
    }

    @PostMapping("/{id}/edit")
    public String editUser(ModelMap model,
                           @PathVariable(name="id") int userId,
                           @ModelAttribute UserForm userForm
                           ){

        User user = userDao.getById(userId);

        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        userDao.update(user);
        return "redirect:/users";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(ModelMap model,
                           @PathVariable(name="id") int userId
    ){
        userDao.remove(new User(userId));
        return "redirect:/users";
    }


    @GetMapping("/add")
    public String userAddPage(ModelMap model){
        UserForm user = new UserForm();
        user.setName("Sarkhan");
        model.addAttribute("user", user);
        return "/useradd";
    }

    @PostMapping("/add")
    public String userAdd(
            @Valid @ModelAttribute("user") UserForm userForm,

            BindingResult result
    ){
        if(result.hasErrors()){
            return "/useradd.jsp";
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        userDao.add(user);
        return "redirect:/users";
    }
}
