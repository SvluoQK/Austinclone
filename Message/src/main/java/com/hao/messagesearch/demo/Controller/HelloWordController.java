package com.hao.messagesearch.demo.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Hao Luo
 * @Date 2022
 * @description
 */

@RestController
@RequestMapping("/hello")
public class HelloWordController {
    @GetMapping("/hi")
    public String world(){
        return "Hello World";

    }

}
