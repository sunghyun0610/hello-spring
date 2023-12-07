package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    @GetMapping("hello")///hello url을 입력하면 Get방식으로 url에 매칭됨 그리고 밑에 메서드 실행
    public String hello(Model model){ //Model은 controller->view 데이터를 전달할 수 있는 데이터 컨테이너입니다
        model.addAttribute("data","hello!!");//spring에서 직접 hello란 값을 받음
        //Model이라는 객체에 data라는 속성을 추가하였고 속성 값은 hello!!이다., view에선 data라는 속성을 통해 데이터에 접근 가능
        return "hello";
    }

    @GetMapping("hello-mvc") //함수에 ctrl+p하면 요구하는 인자형식 알 수 있음
    public String helloMvc(@RequestParam(value="name") String name, Model model){//외부 url에서 "name"의 데이터 값을 받는 파라미터
        model.addAttribute("name", name);
        return "hello-template";
    }
}
/*

/*=======
* controller에서 return값으로 문자르 반환하면 viewResolver가 화면을 찾아서 처리한다
* viewName 매핑 : [resources:templates/] + {ViewName} + [.html]
* */
/*<<<<<<< HEAD
//main branch
=======
//sunghyun branch
>>>>>>> sunghyun
*/

//view는 화면을 그리는데 모든걸 집중
//controller는 비지니스 로직이나 기능구현하는데 집중