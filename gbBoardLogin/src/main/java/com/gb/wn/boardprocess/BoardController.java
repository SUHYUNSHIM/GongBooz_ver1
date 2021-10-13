package com.gb.wn.boardprocess;




import java.io.File;


import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.gb.wn.boardService.BoardService;
import com.gb.wn.boardService.ReplayService;
import com.gb.wn.boardVO.BoardVO;
import com.gb.wn.boardVO.Criteria;
import com.gb.wn.boardVO.LikeVO;
import com.gb.wn.boardVO.PageMaker;
import com.gb.wn.boardVO.ReplyVO;
import com.gb.wn.boardVO.SearchCriteria;
import com.gb.wn.memberVO.MemberVO;

@Controller
public class BoardController {

	@Resource(name="boardService")
	private BoardService boardkaja;
	
	@Resource(name="replyService")
	private ReplayService replykaja;

	@RequestMapping(value="board/boardInsert.do")
	public String boardIsert(){
		
		return "board/boardWrite";
	}
	
	//게시판 글쓰기
	@RequestMapping(value="board/boardWrite.do", method = RequestMethod.POST)
	public String boardWrite(BoardVO boardVO,  MultipartHttpServletRequest mpRequest) throws Exception {
		System.out.println("게시판 글쓰러 왔다. ");
		/*System.out.println(boardVO.getTitle());*/
		boardkaja.boardWrite(boardVO, mpRequest);
		
		return "redirect:/board/boardList.do";
	}
	
	//게시판 글 목록
	@RequestMapping(value="board/boardList.do", method = RequestMethod.GET)
	public String boardList(Model model, @ModelAttribute("scri") SearchCriteria scri) throws Exception {
		
		model.addAttribute("boardList", boardkaja.boardList(scri));
		
		PageMaker pageMaker  = new PageMaker();
		pageMaker.setCri(scri);
		pageMaker.setTotalCount(boardkaja.listCount(scri));
		
		model.addAttribute("pageMaker", pageMaker);
		return "board/boardList";
	}
	
	// 게시판 조회
	@RequestMapping(value="board/boardView.do", method = RequestMethod.GET)
	public String boardView(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, MemberVO memVO , Model model) throws Exception {
		System.out.println("게시물글보기");
		System.out.println(memVO.getUserid());
		//좋아요
		LikeVO likebean = new LikeVO();
		
		likebean.setLtbid(boardVO.getBno());
		likebean.setLtmid(memVO.getUserid());
		
		int ltlike = 0;
		
		int check = boardkaja.ltlikecount(likebean);
		System.out.println("갯수"+check);
		if(check ==0) {
			
			boardkaja.likeinsert(likebean);
			System.out.println("insert");
		}else if(check==1) {
			
			ltlike = boardkaja.ltlikegetinfo(likebean);
			System.out.println("좋아요 갯수"+ltlike);
		}
		
		model.addAttribute("ltlike",ltlike);	
		//좋아요 end
		
		model.addAttribute("boardView", boardkaja.boardView(boardVO.getBno()));
		model.addAttribute("scri", scri);
		
		List<ReplyVO> replyList = replykaja.readReply(boardVO.getBno());
		model.addAttribute("replyList", replyList);
		
		List<Map<String, Object>> fileList = boardkaja.selectFileList(boardVO.getBno());
		model.addAttribute("file", fileList);
		return "board/boardView";
	}
//	@RequestMapping(value="board/boardView.do", method = RequestMethod.GET)
//	public String boardView(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri , Model model) throws Exception {
//		System.out.println("게시물글보기");
//		
//		
//		model.addAttribute("boardView", boardkaja.boardView(boardVO.getBno()));
//		model.addAttribute("scri", scri);
//		
//		List<ReplyVO> replyList = replykaja.readReply(boardVO.getBno());
//		model.addAttribute("replyList", replyList);
//		
//		List<Map<String, Object>> fileList = boardkaja.selectFileList(boardVO.getBno());
//		model.addAttribute("file", fileList);
//		return "board/boardView";
//	}
	
	@PutMapping("member/likeupdate.do")
	public Map<String,Object> likeupdate(@RequestBody LikeVO likebean){
	/*	@RequestMapping(value="member/likeupdate.do")
		public Map<String,String> likeupdate(LikeVO likebean){*/
			
			System.out.println("좋아요" + likebean.getLtmid()+"/"+likebean.getLtbid());
		Map<String,Object> map = new HashMap<String, Object>();
		
		try {
			boardkaja.likeupdate(likebean);
			System.out.println("좋아요 수정");
			int like = likebean.getAllltlike();
			map.put("result", "success");
			map.put("like", like);
			
		}catch(Exception e) {
			e.printStackTrace();
			map.put("result", "fail");
		}
		System.out.println(map.get("result"));
		
		return map;
		
	}

	

	
	//게시판 수정 뷰
	@RequestMapping(value="board/modifyView.do", method = RequestMethod.GET)
	public String modifyView(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, Model model) throws Exception {
		System.out.println("수정뷰");
		model.addAttribute("modifyView", boardkaja.boardView(boardVO.getBno()) );
		model.addAttribute("scri", scri);
		
		List<Map<String, Object>> fileList = boardkaja.selectFileList(boardVO.getBno());
		model.addAttribute("file", fileList);
		
		return "board/modifyView";
	}
	
	//게시판 수정
	@RequestMapping(value="board/boardModify.do", method = RequestMethod.POST)
	public String boardModify(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr,
			@RequestParam(value="fileNoDel[]") String[] files,
			 @RequestParam(value="fileNameDel[]") String[] fileNames,
			 MultipartHttpServletRequest mpRequest) throws Exception {
		System.out.println("수정하러 왔다 .");
		boardkaja.boardModify(boardVO, files, fileNames, mpRequest);
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardList.do";
	}
	
	//게시판 삭제
	@RequestMapping(value="board/boardDelete.do", method = RequestMethod.POST)
	public String boardDelete(BoardVO boardVO, @ModelAttribute("scri") SearchCriteria scri, RedirectAttributes rttr) throws Exception {
		
		boardkaja.boardDelete(boardVO.getBno());
		
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardList.do";
	}
	
	//댓글 작성
	@RequestMapping(value="board/replyWrite.do", method = RequestMethod.POST)
	public String replyWrite(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr,MemberVO membervo) throws Exception {
		replykaja.writeReply(vo);
		
		rttr.addAttribute("userid", membervo.getUserid());
		System.out.println("댓글 작성2"+"/"+membervo.getUserid());
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardView.do";
		/*return "redirect:/board/boardList.do";*/
	}
	
	//댓글 수정 GET
	@RequestMapping(value="board/replyUpdateView.do", method = RequestMethod.GET)
	public String replyUpdateView(ReplyVO vo, SearchCriteria scri ,Model model) throws Exception {
		
		/*model.addAttribute("userid",membervo.getUserid());
		System.out.println("수정뷰/"+membervo.getUserid());*/
		model.addAttribute("replyUpdate", replykaja.selectReply(vo.getRno()));
		model.addAttribute("scri", scri);
		
		return "board/replyUpdateView";
	}
	
	//댓글 수정 POST
	@RequestMapping(value="/board/replyUpdate.do", method = RequestMethod.POST)
	public String replyUpdate(ReplyVO vo, SearchCriteria scri, RedirectAttributes rttr, MemberVO memberVO) throws Exception {
		
		replykaja.updateReply(vo);
		rttr.addAttribute("userid",memberVO.getUserid());
		System.out.println("댓글 수정"+"/"+memberVO.getUserid());
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardView.do";
		/*return "redirect:/board/boardList.do";*/
	}
	
	//댓글 삭제 GET
	@RequestMapping(value="/board/replyDeleteView.do", method = RequestMethod.GET)
	public String replyDeleteView(ReplyVO vo, SearchCriteria scri, Model model) throws Exception {
		
		model.addAttribute("replyDelete", replykaja.selectReply(vo.getRno()));
		model.addAttribute("scri", scri);
		

		return "board/replyDeleteView";
	}
	
	//댓글 삭제
	@RequestMapping(value="/board/replyDelete.do", method = RequestMethod.POST)
	public String replyDelete(ReplyVO vo, SearchCriteria scri, MemberVO membervo, RedirectAttributes rttr) throws Exception {
		System.out.println("댓글 삭제");
		replykaja.deleteReply(vo);
		
		rttr.addAttribute("userid", membervo.getUserid());
		rttr.addAttribute("bno", vo.getBno());
		rttr.addAttribute("page", scri.getPage());
		rttr.addAttribute("perPageNum", scri.getPerPageNum());
		rttr.addAttribute("searchType", scri.getSearchType());
		rttr.addAttribute("keyword", scri.getKeyword());
		
		return "redirect:/board/boardView.do";
		/*return "redirect:/board/boardList.do";*/
	}
	
	@RequestMapping(value="/board/fileDown.do")
	public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
		Map<String, Object> resultMap = boardkaja.selectFileInfo(map);
		String storedFileName = (String) resultMap.get("STORED_FILE_NAME");
		String originalFileName = (String) resultMap.get("ORG_FILE_NAME");
		
		// 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
		byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File("C:\\gb\\file\\"+storedFileName));
		
		response.setContentType("application/octet-stream");
		response.setContentLength(fileByte.length);
		response.setHeader("Content-Disposition",  "attachment; fileName=\""+URLEncoder.encode(originalFileName, "UTF-8")+"\";");
		response.getOutputStream().write(fileByte);
		response.getOutputStream().flush();
		response.getOutputStream().close();
		
	}
	
	
	
	
	
	
	
	

	
	
	
}
