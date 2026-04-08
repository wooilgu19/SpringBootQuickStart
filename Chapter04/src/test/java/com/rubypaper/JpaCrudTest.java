package com.rubypaper;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rubypaper.domain.Board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@SpringBootTest
public class JpaCrudTest {

	//@Test
	void getBoardList() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		// EntityManager 생성
		EntityManager em = emf.createEntityManager();

		// 글 목록 검색\
		String jpql = "from Board"; // 모든 Board 객체들을 검색해라
		List<Board> boardList = em.createQuery(jpql).getResultList();

		System.out.println("[ 게시글 목록 ]");

		for (Board board : boardList) {
			System.out.println("---> " + board.toString());
		}

		// 자원 해제
		em.close();
		emf.close();
	}

	// @Test
	void deleteBoard() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		// EntityManager 생성
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();

		// 트랜잭션 시작
		tx.begin();

		// 삭제할 글 검색
		Board board = em.find(Board.class, 1);

		// 글 삭제
		em.remove(board);

		// 트랜잭션 종료
		tx.commit();

		// 자원 해제
		em.close();
		emf.close();
	}

	//@Test
	void updateBoard() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		// EntityManager 생성
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();

		// 트랜잭션 시작
		tx.begin();

		// 수정할 글 검색
		Board board = em.find(Board.class, 1);

		// 글수정
		board.setTitle("-----제목 수정2");
		board.setContent("---내용 수정2");

		// 트랜잭션 종료
		tx.commit();

		// 자원 해제
		em.close();
		emf.close();
	}

	// @Test
	void getBoard() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		// EntityManager 생성
		EntityManager em = emf.createEntityManager();

		// 글 등록
		Board board = em.find(Board.class, 1);
		System.out.println("검색 결과 : " + board.toString());

		// 자원 해제
		em.close();
		emf.close();
	}

	@Test
	void insertBoard() {
		// EntityManagerFactoryBean 생성
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JPAProject");

		// EntityManager 생성
		EntityManager em = emf.createEntityManager();

		// Transaction 생성
		EntityTransaction tx = em.getTransaction();

		// 트랜잭션 시작
		tx.begin();

		// 글 등록
		for (int i = 0; i < 10; i++) {
			
		
		Board board = new Board();
//		board.setSeq(5);
		board.setTitle("MyBatis 테스트");
		board.setWriter("테스터");
		board.setContent("MyBatis 테스트 중입니다.");
		board.setRegDate(new Date());
		board.setCnt(0);
//		board.setEmail("test@test.com");
		em.persist(board);
		}

		// 트랜잭션 종료
		tx.commit();

		// 자원 해제
		em.close();
		emf.close();
	}

}
