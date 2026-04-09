package com.rubypaper.persistence;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.rubypaper.domain.Board;

// JpaRepository를 상속한 인터페이스만 정의하면 구현 클래스는 Spring에서 자동으로 제공한다.
public interface BoardRepository extends JpaRepository<Board, Integer> {
	// JpaRepository로부터 상속한 CRUD 기능의 메소드가 기본 제공된다.
	
//	// 쿼리 메소드를 통해 복잡한 JPQL을 대체한다.
//	// 생성되는 JPQL : select b from Board as b where b.title = ?
//	List<Board> findBoardByTitle(String keyword);
//	
//	// 생성되는 JPQL : select b from Board as b where b.title = ?
//	List<Board> findByTitle(String keyword);
//	
//	// 생성되는 JPQL : select b from Board as b where b.title like ?
//	List<Board> findByTitleContaining(String keyword);
//	
//	// 생성되는 JPQL : select b from Board as b where b.title like ? or b.content like ?
//	List<Board> findByTitleContainingOrContentContaining(String title, String content);
//	
//	// 생성되는 JPQL : select b from Board as b where b.title like ? order by b.seq desc
//	List<Board> findByTitleContainingOrderBySeqDesc(String keyword);
//	
//	// 생성되는 JPQL : select b from Board as b where b.title like ?
//	Page<Board> findByTitleContaining(String keyword, Pageable pageable);
	
	@Query("select b.seq, b.title, b.content from Board b where b.title like %:searchKeyword% order by b.seq desc")
	List<Object[]> getBoardListByJPQL(@Param("searchKeyword") String keyword, Pageable pageable);
	
	
	@Query(nativeQuery = true, 
		   value = "select seq, title, content from board where title like '%'||:searchKeyword||'%' order by seq desc")
	List<Object[]> getBoardListBySQL(@Param("searchKeyword") String keyword, Pageable pageable);
}




