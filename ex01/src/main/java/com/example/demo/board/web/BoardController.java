package com.example.demo.board.web;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.board.service.BoardService;
import com.example.demo.board.service.BoardVO;
import com.example.demo.common.Paging;


@Controller
public class BoardController {
	
	@Autowired BoardService boardService;   //서비스(interface) 주입
	
	//게스글 목록
	@GetMapping("boardList")  //[[url  =/= *.html경로]]
	public String BoardList(Model model, BoardVO boardVO, Paging paging) {
		paging.setTotalRecord(boardService.selectCount(boardVO));
		paging.setPageUnit(5);
		boardVO.setFirst(paging.getFirst());
		boardVO.setLast(paging.getLast());
		                 // (View 지정,  DB 결과 (인터페이스 -> mapper.xml SQL 실행))
		model.addAttribute("boardList", boardService.selectBoard(boardVO));
		return "board/boardList";  // View에 전달 .html파일경로
	}
	
	//단건조회
	@GetMapping("board")
	public String Board(Model model, @RequestParam("bno") Long bno) {
		model.addAttribute("board", boardService.selectBoardByBno(bno));  // 단일 게시글
		model.addAttribute("replyList", boardService.selectReply(bno)); // 댓글 리스트
		return "board/board";
	}
	
	//게시글 첨부파일 등록로직 1)등록페이지 이동 2)등록처리  =>get방식은 이동 & post는 등록으로 처리
	//1)등록페이지 이동
	@GetMapping("/board/register")
	public String boardpage(BoardVO boardVO) {
		return "board/register";
	}
	
	@Value("${file.upload.dir}")
	String UPLOAD_DIR;
	
	//2)등록처리
	@PostMapping("/board/register")
	public String boardRegister(BoardVO boardVO, MultipartFile file) throws IllegalStateException, IOException  {
		
		if(! file.isEmpty() && file.getSize() > 0 ) { //파일이 있으면
		//첨부파일순서 
		//1)첨부파일 업로드
		file.transferTo(new File("c:/upload", file.getOriginalFilename()));
		
		//2)파일명을 DB저장
		boardVO.setAttach(file.getOriginalFilename());
		}
		//게시글
		boardService.insertBoard(boardVO);
		return "redirect:/boardList";   //"redirect:는 url주소 작성해줘야함! " 
	}
	
	//파일다운로드
	@GetMapping("/filedown/{filename}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String filename) throws MalformedURLException {
		// 파일 경로 설정
		Path filePath = Paths.get(UPLOAD_DIR).resolve(filename).normalize();

		// 파일을 Resource 로 로드
		Resource resource = new UrlResource(filePath.toUri());
		if (!resource.exists()) {
			return ResponseEntity.notFound().build();
		}

		// Content-Disposition 헤더에 다운로드용 파일명 지정
		String contentDisposition = "attachment; filename=\"" + resource.getFilename() + "\"";

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_OCTET_STREAM) // 이진 파일
				.header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition).body(resource);
	}
	
}