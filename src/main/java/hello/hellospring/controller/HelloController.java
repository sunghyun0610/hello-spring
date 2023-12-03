package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    @GetMapping("hello")
    public String hello(Model model){//Model은 controller->view로 데이터를 전달할 수 있는 데이터 컨테이너.
        model.addAttribute("data","hello!!");
        //Model객체에 data라는 속성을 추가하였고 그 속성값은 "hello!!"이다.
        return "hello";

    }
}
/*
* controller에서 return값으로 문자를 반환하면 viewResolver가 화면을 찾아서 처리한다.
* 템플릿 viewName 매핑하는 과정 : [resources: templates/] +{ViewName}+.[html]  []값은 알아서 처리해주는 값
* */