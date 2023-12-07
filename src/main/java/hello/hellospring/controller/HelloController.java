package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    //API 방식
    @GetMapping("hello-string")
    @ResponseBody//http body부분에 return 데이터를 바로 넣어 주겠다는 의미
    public String helloString(@RequestParam("name") String name){
        return "hello" + name;//"hello spring"이건 view가 없고 바로 이 문자가 그대로 내려감

    }


    @GetMapping("hello-api")
    @ResponseBody//객체를 반환하고 Response Body해놓으면 json을 반환하는 것이 디폴트.
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;//getter&setter단축키 -> alt+insert ,getter/setter : JavaBean 규약
        //private 라서 외부에서 바로 못 꺼냄 사용할때 메서드를 통해서 접근하게함.

        public String getName() {
            return name;//메서드는 public으로 염.
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
//결국 동적이냐 API냐 문제

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