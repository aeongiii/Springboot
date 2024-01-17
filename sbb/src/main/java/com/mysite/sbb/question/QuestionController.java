package com.mysite.sbb.question;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	@GetMapping("/list")										// 페이지 구현 시 첫 페이지 번호 0부터 시작
    public String list(Model model, @RequestParam(value="page", defaultValue="0") int page) {
        Page<Question> paging = this.questionService.getList(page);
        model.addAttribute("paging", paging);
        return "question_list";
    }
	 @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id, AnswerForm answerForm) {
    	
    	Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
	 @GetMapping("/create")
	 public String questionCreate(QuestionForm questionForm) {
		 return "question_form";
	 }
	 
	// POST 방식으로 요청된 데이터를 처리하기 위해 오버라이딩.	// 매개변수 제목(subject)과 내용(content)이 question_form.html의 값과 동일해야 함.
	// 폼 클래스 (QuestionForm.java)를 컨트롤러에서 사용할 수 있도록.
	 @PostMapping("/create")
	    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {	// 오류 있는 경우 다시 제목과 내용을 작성하는 화면으로 돌아가도록. (빈 값 저장되지 않음)
	            return "question_form";
	        }
	        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
	        return "redirect:/question/list";
	    }
	 
	 
	}