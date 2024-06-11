package com.example.sneakpeak.Service;

import com.example.sneakpeak.DTO.UserDTO;
import com.example.sneakpeak.DTO.UserRequestDTO;
import com.example.sneakpeak.Entity.User;
import com.example.sneakpeak.Repository.UserRepository;
import com.example.sneakpeak.Utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JWTUtils jwtUtils;

    @Transactional
    public String SignUpService(UserDTO userDTO) {
        User user = new User();
        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setEmailId(userDTO.getEmailId());
        user.setPassword(userDTO.getPassword());
        userRepository.save(user);
        return "Registered Successfully";
    }

    public Map<String,Object> login(UserRequestDTO userRequestDTO) {
        User user = userRepository.findOneByEmailIdIgnoreCaseAndPassword(userRequestDTO.getEmailId(),userRequestDTO.getPassword());
        if (user == null){
            String response="Login failed";
            Map<String ,Object> responseData= new HashMap<>();
            responseData.put("user",response);
            return responseData;
        }

        String token = jwtUtils.generateJWT(user);
        Map<String,Object> data = new HashMap<>();
        data.put("accessToken",token);
        return data;
    }
}
