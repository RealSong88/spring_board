package com.mycompany.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mycompany.service.BoardService;
import com.mycompany.vo.BoardVO;
import com.mycompany.vo.Criteria;
import com.mycompany.vo.PageMaker;

@Controller
@RequestMapping("/board/*")
public class BoardController {

	private static final Logger logger = LoggerFactory.getLogger(BoardController.class);
	
	@Inject
	BoardService boardService;
	
	// 게시판 글 작성 화면
	@RequestMapping(value = "/board/writeView", method = RequestMethod.GET)
	public void writeView() throws Exception{
		logger.info("writeView");
	}
	
	// 게시판 글 작성
	@RequestMapping(value = "/board/write", method = RequestMethod.POST)
	public String write(BoardVO boardVO) throws Exception {
		logger.info("write");
		
		boardService.write(boardVO);
		
		return "redirect:/";
	}
	
	// 게시판 목록 조회
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String list(Model model, Criteria cri) throws Exception{
		logger.info("list");
		
		model.addAttribute("list", boardService.list(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.listCount());
		
		model.addAttribute("pageMaker", pageMaker);
		
		return "board/list";
	}
	
	// 게시판 조회
	@RequestMapping(value = "/readView", method = RequestMethod.GET)
	public String read(BoardVO boardVO, Model model) throws Exception{
		logger.info("read");
		
		model.addAttribute("read", boardService.read(boardVO.getBno()));
		
		return "board/readView";
	}
	
	// 게시판 수정뷰
	@RequestMapping(value = "/updateView", method = RequestMethod.GET)
	public String updateView(BoardVO boardVO, Model model) throws Exception{
		logger.info("updateView");
		
		model.addAttribute("update", boardService.read(boardVO.getBno()));
		
		return "board/updateView";
	}
	
	// 게시판 수정
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(BoardVO boardVO) throws Exception {
		logger.info("update");
		
		boardService.update(boardVO);
		
		return "redirect:/board/list";
	}
	
	// 게시판 삭제
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String delete(BoardVO boardVO) throws Exception {
		logger.info("delete");
		
		boardService.delete(boardVO.getBno());
		
		return "redirect:/board/list";
	}
}
