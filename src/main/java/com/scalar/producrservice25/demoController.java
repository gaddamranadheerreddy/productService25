package com.scalar.producrservice25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testing")
public class demoController {
    @GetMapping("/hello")
    public String hello(){
        return "hello you";
    }

    @GetMapping("/hey/{num}")
    public String fun(@PathVariable("num") int numberOfTimes){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<numberOfTimes;i++){
            sb.append("Om Namo Venkateshaya || ");
        }
        return sb.toString();
    }
}
