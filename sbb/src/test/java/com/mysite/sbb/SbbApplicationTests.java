package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mysite.sbb.answer.Answer;
import com.mysite.sbb.answer.AnswerRepository;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionRepository;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;
//    @Transactional
    @Test
    void testJpa() {  
// ================ 1. 질문 데이터 저장하기 ====================
//        Question q1 = new Question();
//        q1.setSubject("sbb가 무엇인가요?");
//        q1.setContent("sbb에 대해서 알고 싶습니다.");
//        q1.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q1);  // 첫번째 질문 저장
//
//        Question q2 = new Question();
//        q2.setSubject("스프링부트 모델 질문입니다.");
//        q2.setContent("id는 자동으로 생성되나요?");
//        q2.setCreateDate(LocalDateTime.now());
//        this.questionRepository.save(q2);  // 두번째 질문 저장

// findAll 메서드 : Question 테이블에 저장된 모든 데이터 조회 => 데이터의 사이즈가 2인지 테스트 (저장된 데이터가 총 두개인지)
//    	 List<Question> all = this.questionRepository.findAll();
//         assertEquals(2, all.size());
//
//         Question q = all.get(0);
//         assertEquals("sbb가 무엇인가요?", q.getSubject());
    	
// findById 메서드 : ID를 활용해 조회 => 아이디가 1인 질문의 제목이 "sbb가 무엇인가요?" 인 경우 통과. (* 리턴 타입은 Question이 아닌 Optional)
//        Optional<Question> oq = this.questionRepository.findById(1);
//        if(oq.isPresent()) {
//            Question q = oq.get();
//            assertEquals("sbb가 무엇인가요?", q.getSubject());
//        }
    	
// findBySubject 메서드 : 리포지터리에서 기본적으로 제공 X -> QuestionRepository 인터페이스에 관련 메서드 추가해야 함
//    	Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
//        assertEquals(1, q.getId());
    	
// findBySubjectAndContent 메서드 : 리포지터리에서 기본적으로 제공 X -> QuestionRepository 인터페이스에 관련 메서드 추가해야 함
//    	Question q = this.questionRepository.findBySubjectAndContent(
//                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
//        assertEquals(1, q.getId());

// findBySubjectLike 메서드 : subject 값 중에서 특정 문자열을 포함하는 데이터 조회
//        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
//        Question q = qList.get(0);
//        assertEquals("sbb가 무엇인가요?", q.getSubject());
        
// ==================== 2. 질문 데이터 수정하기 ====================
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        q.setSubject("수정된 제목");		// 수정
//        this.questionRepository.save(q);	// 저장
        
// ==================== 3. 질문 데이터 삭제하기 =======================
//    	assertEquals(2, this.questionRepository.count());
//        Optional<Question> oq = this.questionRepository.findById(1);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//        this.questionRepository.delete(q);		// Id = 1 인 내용 삭제
//        assertEquals(1, this.questionRepository.count());	// 삭제 후 총 개수가 1이 되었는지

// ==================== 4. 답변 데이터 저장하기 =======================
//    	Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        Answer a = new Answer();
//        a.setContent("네 자동으로 생성됩니다.");
//        a.setQuestion(q);  // 어떤 질문의 답변인지 알기위해서 Question 객체가 필요하다.
//        a.setCreateDate(LocalDateTime.now());
//        this.answerRepository.save(a);
        
// ===================== 5. 답변 데이터 조회하기 ==================
//        Optional<Answer> oa = this.answerRepository.findById(1);
//        assertTrue(oa.isPresent());
//        Answer a = oa.get();
//        assertEquals(2, a.getQuestion().getId());
        
// ================ 6. 질문데이터에서 답변데이터 찾기 ================
//        Optional<Question> oq = this.questionRepository.findById(2);
//        assertTrue(oq.isPresent());
//        Question q = oq.get();
//
//        List<Answer> answerList = q.getAnswerList();
//
//        assertEquals(1, answerList.size());
//        assertEquals("네 자동으로 생성됩니다.", answerList.get(0).getContent());
    }
}
