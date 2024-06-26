package com.kwonjh0406.blog.service;

import com.kwonjh0406.blog.model.User;
import com.kwonjh0406.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public int 회원가입(User user){
        try{
            userRepository.save(user);
            return 1;
        } catch(Exception e){
            e.printStackTrace();
            System.out.println("UserService : 회원가입() : "+e.getMessage());
        }
        return -1;
    }

    @Transactional(readOnly = true)
    public User 로그인(User user){
        return userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
    }
}
