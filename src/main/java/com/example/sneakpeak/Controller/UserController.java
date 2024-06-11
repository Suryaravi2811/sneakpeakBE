package com.example.sneakpeak.Controller;

import com.example.sneakpeak.DTO.UserDTO;
import com.example.sneakpeak.DTO.UserRequestDTO;
import com.example.sneakpeak.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/sneakpeak/")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("signup")
    public ResponseEntity<String> SignUp(@RequestBody UserDTO userDTO){
    return new ResponseEntity<>(userService.SignUpService(userDTO),HttpStatus.CREATED);
    }

    @PostMapping("login")
    public ResponseEntity<Map<String,Object>> userLogin(@RequestBody UserRequestDTO userRequestDTO){
       return new ResponseEntity<>(userService.login(userRequestDTO), HttpStatus.ACCEPTED);
    }
}
