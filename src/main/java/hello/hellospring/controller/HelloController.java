package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){ //Model은 controller->view 데이터를 전달할 수 있는 데이터 컨테이너입니다
        model.addAttribute("data","hello!!");
        //Model이라는 객체에 data라는 속성을 추가하였고 속성 값은 hello!!이다.
        return "hello";

    }
}
