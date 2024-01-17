package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/sbb")
    @ResponseBody
    public String index() {
        return "안녕하세요 sbb에 오신 것을 환영합니다.";
    }
    
    // 루트URL 호출 시 404 오류 페이지 대신 질문 목록 화면을 메인 페이지로 출력하도록.
    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";	// 리다이렉트 : 클라이언트가 요청하면 새로운 URL로 전송하는 것.
        									// => 8080/ 페이지에 접속하면 8080/question/list로 주소가 바뀌면서 질문 목록 페이지로 연결됨
    }
}
