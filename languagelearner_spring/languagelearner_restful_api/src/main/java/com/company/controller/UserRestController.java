package com.company.controller;


//users GET
//users POST
//users/1 GET
//users/1 PUT
//users/1 DELETE

//users/1/teachers GET


import com.company.beans.ErrorCodes;
import com.company.beans.Messages;
import com.company.dao.impl.UserDaoInter;
import com.company.dto.ResponseDTO;
import com.company.dto.UserDTO;
import com.company.dto.WordlistDTO;
import com.company.entity.User;
import com.company.entity.Wordlist;
import com.company.exceptions.NotfoundException;
import com.company.form.UserForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    @Autowired
    UserDaoInter userDao;

    @GetMapping
    public ResponseDTO getUsers(
                           @RequestParam(name="name", required = false) String name,
                           @RequestParam(name="surname", required = false) String surname){

        List<User> users = null;
        if(name!=null && !name.trim().isEmpty()) {
            users = userDao.getAll(name);
        }else{
            users = userDao.getAll();//MODEL - View - Controller
        }

        List<UserDTO> result = new ArrayList<>();
        for(int i=0;i<users.size();i++){
            User u = users.get(i);
            UserDTO usr = new UserDTO(u.getId(),u.getName(), u.getSurname());

            List<WordlistDTO> wordlistDTOS = new ArrayList<>();
            List<Wordlist> wordlists = u.getWordlistList();
            for(int j=0;j<wordlists.size();j++){
                Wordlist w = wordlists.get(j);
                wordlistDTOS.add(new WordlistDTO(w.getId(), w.getWord(), w.getTranslation()));
            }//Data Transfer Object

            usr.setWordlistList(wordlistDTOS);
            result.add(usr);
        }

        return ResponseDTO.of(result);
    }

    @PostMapping
    public ResponseDTO userAdd(
            @Valid @RequestBody UserForm userForm ,
            BindingResult result
    ){
        if(result.hasErrors()){
            return ResponseDTO.of(result.getAllErrors().toString(), ErrorCodes.INVALID_FIELDS);
        }
        User user = new User();
        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        userDao.add(user);
        UserDTO usr = new UserDTO(user.getId(),user.getName(), user.getSurname());
        return ResponseDTO.of(Messages.SUCCESS_ADD_MSG,usr);
    }

    @PutMapping("/{id}")
    public ResponseDTO editUser(
                           @PathVariable(name="id") int userId,
                           @RequestBody UserForm userForm
                           ){

        User user = userDao.getById(userId);

        user.setName(userForm.getName());
        user.setSurname(userForm.getSurname());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());

        userDao.update(user);

        UserDTO usr = new UserDTO(user.getId(),user.getName(), user.getSurname());
        return ResponseDTO.of("successfully updated",usr);
    }


    @GetMapping("/{id}")
    public ResponseDTO getUser(
            @PathVariable(name="id") int userId
    ){
        User user = userDao.getById(userId);

        if(user==null) throw new NotfoundException();

        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setSurname(user.getSurname());

        return ResponseDTO.of(userDto);
    }


    @DeleteMapping("/{id}")
    public ResponseDTO deleteUser(
            @PathVariable(name="id") int userId
    ){
        userDao.deleteById(userId);

        UserDTO userDto = new UserDTO();
        userDto.setId(userId);
        return ResponseDTO.of("successfully deleted",userDto);
    }


}
