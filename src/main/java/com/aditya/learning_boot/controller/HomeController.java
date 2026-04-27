package com.aditya.learning_boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// @Controller annotation searches for a file (assuming file is being returned) because of the old way hence we use RestController
// to make it realize it is data that is coming not file
@RestController
public class HomeController {

    @RequestMapping("/") // for / this method will run
    public String greet(){
        return "Welcome here";
    }

    @RequestMapping("/about")
    public String about(){
        return "This is about page";
    }
}

                             // SECOND WAY
// @Controller
//public class HomeController {
//
//    @RequestMapping("/")
//    @ResponseBody
//    public String greet(){
//        return "Welcome here";
//    }
//}

