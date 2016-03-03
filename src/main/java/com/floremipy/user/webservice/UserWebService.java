package com.floremipy.user.webservice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.floremipy.user.User;


@RestController
public class UserWebService {

    
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/user")
    public User user(@RequestParam String lastname, @RequestParam String firstname, @RequestParam String password, @RequestParam String username, @RequestParam String usertype) {
        return new User(counter.incrementAndGet(),String.format(lastname), String.format(firstname), String.format(password), String.format(username), String.format(usertype) );
    }
 
}