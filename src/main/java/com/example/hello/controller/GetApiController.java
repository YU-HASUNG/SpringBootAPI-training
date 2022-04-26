package com.example.hello.controller;

import com.example.hello.dto.UserRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/get")
public class GetApiController {

    //Path Variable
    @GetMapping(path="/hello") // http://localhost:8080/api/get/hello
    public String hello(){
        return "get Hello";
    }

    // @GetMapping("/hi") get / post/ put/ delete 다 됨.
    @RequestMapping(path = "/hi", method = RequestMethod.GET) // get 만 됨 http://localhost:8080/api/get/hi
    public String hi(){
        return "get hi";
    }

    @GetMapping("/path-variable/{name}") // http://localhost:8080/api/get/path/path-variable/{name}
    public String pathVariable(@PathVariable String name){ //변화하는 부분에 대한 것은 @PathVariable로 받음 /주소의 변수명과 @PathVariable의 변수명은 같아야 함
        System.out.println("PathVariable : "+name);
        return name;
    }

    //Query Parameter
    //검색할 때 여러가지 매개변수 인자
    //ex) 구글 intellij 검색
    //https://www.google.com/
    // search? q = intellij
    // &oq = intellij
    // &aqs = chrome..69i57j69i59l4j0i512l2j69i61.2600j0j7
    // &sourceid = chrome
    // &ie = UTF-8
    // ?로 시작해서 Key = Value 형태

    // http://localhost:8080/api/get/query-param?user=steve&email=steve@naver.com&age=30
    @GetMapping(path = "query-param")
    public String queryParam(@RequestParam Map<String, String> queryParam){

        StringBuilder sb = new StringBuilder();



        queryParam.entrySet().forEach(entry->{
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            System.out.println("\n");

            sb.append(entry.getKey()+" = "+entry.getValue()+"\n");

        });

        return sb.toString();
    }

    @GetMapping("query-param02")
    public String queryParam02(
        @RequestParam String name,
        @RequestParam String email,
        @RequestParam int age
    ){
        System.out.println(name);
        System.out.println(email);
        System.out.println(age);

        return name+" "+email+" "+age;
    }

    @GetMapping("query-param03")
    public String queryParam03(UserRequest userRequest){
        System.out.println(userRequest.getName());
        System.out.println(userRequest.getEmail());
        System.out.println(userRequest.getAge());

        return userRequest.toString();
    }



}
