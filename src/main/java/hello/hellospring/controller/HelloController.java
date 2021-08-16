package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","가영");
        return "hello"; //뷰 리졸버가 hello.html을 로드해라. /resource/templates 경로 안에 있어야댐.
    }

    @GetMapping("hello-mvc") /**MVC 방식 테스트*/
    public String helloMvc(@RequestParam(value = "name" , required = true) String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string") /**API 방식 테스트*/
    @ResponseBody // view를 거치지 않고 client 그대로 데이터를 내보내겠다.
    public String helloString(@RequestParam("name") String name){
        return "hello ㄴㅇㄹㄴㄹㅇ " + name ; // 이문자 그대로 view 거치지 않고 client 그대로 내려감.
    }

    @GetMapping("hello-api")
    @ResponseBody /**response body의 기본 설정값 : string일 경우 그대로 , 객체일 경우 json형식으로 전달 by HTTPMessageConverter*/
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name ;
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
    }
}
