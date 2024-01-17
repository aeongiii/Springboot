package com.mysite.sbb.question;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import org.springframework.validation.BindingResult;

import com.mysite.sbb.answer.AnswerForm;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

//	private final QuestionRepository questionRepository;
	private final QuestionService questionService;
	
	 @GetMapping("/list")
    public String list(Model model) {
//        List<Question> questionList = this.questionRepository.findAll();
    	List<Question> questionList = this.questionService.getList();
    	model.addAttribute("questionList", questionList);
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