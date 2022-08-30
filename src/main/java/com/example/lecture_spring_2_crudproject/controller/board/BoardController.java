package com.example.lecture_spring_2_crudproject.controller.board;

import com.example.lecture_spring_2_crudproject.entity.account.Member;
import com.example.lecture_spring_2_crudproject.entity.board.Board;
import com.example.lecture_spring_2_crudproject.entity.board.Comments;
import com.example.lecture_spring_2_crudproject.entity.board.FileEntity;
import com.example.lecture_spring_2_crudproject.entity.customDto.CustomDtoSortPages;
import com.example.lecture_spring_2_crudproject.service.board.BoardService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.http.HttpHeaders;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import static com.google.common.io.ByteStreams.toByteArray;
import static org.apache.tomcat.util.http.fileupload.IOUtils.*;

/**
 * @description : 게시판 컨트롤러
 **/

@Controller
@Slf4j
@RequestMapping(path = "/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    protected BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/insertComments")
    public String insertComments(Board board, Model model) {
        System.out.println(board.getTitle());
        model.addAttribute("board", board);
        return "/board/insertComments";
    }

    @GetMapping("/music")
    public String getMusicPage(Model model) {

        return "/board/music";
    }

    @PostMapping("/insertComments")
    public String insertComments(@RequestParam("board_title")String boardTitle, Comments comments, Model model) {

        System.out.println("------inertComments---------");
        System.out.println(comments.getBoard_title());
        System.out.println(comments.getComments_content());
        boardService.insertComment(comments);
        return "redirect:/board/getBoardList";
    }

    //board Seq전달하면 전체 comments를 불러오는 controller method
    @GetMapping("/getCommentsList")
    public String getCommentsList(Comments comments, Model model) {
        System.out.println("-------getCommentsList-------");
        System.out.println(comments.getBoard_title());
        List<Comments> checkCommentsList = boardService.getAllComments(comments);

        model.addAttribute("commentsList", checkCommentsList);
        return "/board/getCommentsList";
    }

    @GetMapping("/getBoardList")
    public String getBoardList(Model model, Board board) {
        System.out.println("-------------------");
        List<Board> boardList = boardService.getBoardList(board);
        model.addAttribute("boardList", boardList);
        return "/board/getBoardList";
    }

    @GetMapping("/insertBoard")
    public String insertBoard() {
        System.out.println("------insertBoard_get-------------");
        return "/board/insertBoard";
    }

    @PostMapping("/insertBoard")
    public String insertBoard(Board board) {
        System.out.println("--------insertBoard_post-----------");
        System.out.println(board.getCreateDate());
        System.out.println(board.getUpdateDate());
        board.setCreateDate(new Date());
        board.setUpdateDate(new Date());
        System.out.println(board.getCreateDate());
        System.out.println(board.getUpdateDate());
        boardService.insertBoard(board);
        return "redirect:/board/getBoardList";
    }

    @GetMapping("/getBoard")
    public String getBoard(Board board, Model model) {
        System.out.println("-------------------");
        System.out.println(board.getSeq());
        model.addAttribute("board", boardService.getBoard(board));
        model.addAttribute("boardPrv", boardService.getPagesSortIndex(board));
        return "/board/getBoard";
    }

    @PostMapping ("/updateBoard")
    public String updateBoard(Board board) {
        System.out.println("----------updateBoard---------");
        System.out.println(board.getContent());
        System.out.println(board.getSeq());
        boardService.updateBoard(board);
        return "redirect:/board/getBoard?seq="+board.getSeq();
    }

    @GetMapping("/updateBoard")
    public String updateBoardView(Board board, Model model) {
        System.out.println("-------------------");
        model.addAttribute("board", boardService.getBoard(board));
        return "/board/insertBoard";
    }

    @GetMapping("/deleteBoard")
    public String deleteBoard(Board board) {
        System.out.println("--------boarde delete-----------");
        System.out.println(board.getSeq());
        boardService.deleteBoard(board);
        return "redirect:/board/getBoardList";
    }


    @GetMapping("/viewUserWriteBoard")
    public String viewUserWriteBoard(Member member, Model model) {
        System.out.println("-------view-------");
        System.out.println(member.getId());
        model.addAttribute("boardList",
                boardService.getBoardListAllBoardListByMemberId(member));
        return "/board/getBoardList";
    }

    @GetMapping("/getAllUserBoardList")
    public String AllUsersBoard(Model model) {

//        List<Board> board = null;
//        List<Member> member = null;

//        for(List<Object> result : boardService.getBoardAndMemberUsersBoard()) {
//            board = (List<Board>) result.get(0);
//            member = (List<Member>) result.get(1);
//        }

        System.out.println(boardService.getBoardAndMemberUsersBoard().size());

//            board = (List<Board>) boardService.getBoardAndMemberUsersBoard().get(0);
//            member = (List<Member>) boardService.getBoardAndMemberUsersBoard().get(1);

        return "index";
    }

    @GetMapping("/sortTest")
    public String sortTest(Board board, Model model) {

        CustomDtoSortPages customDtoSortPages = boardService.getPagesSortIndex(board);
        System.out.println(customDtoSortPages.getNEXT_SUBJECT());
        System.out.println(customDtoSortPages.getNEXTID());
        System.out.println(customDtoSortPages.getPREV_SUBJECT());
        System.out.println(customDtoSortPages.getPREVID());

//        model.addAttribute("sortBoard", customDtoSortPages);
        return "/board/getBoardList";
    }

//    application/x-www-form-urlencoded
//    multipart/form-data
    @PostMapping("/updateImage")
    public String updateImage(@RequestParam("uploadfile")MultipartFile[] uploadfile, Model model) throws IOException {
        log.info("dawda");
        List<FileEntity> list = new ArrayList<>();
        for(MultipartFile file : uploadfile) {
            if(!file.isEmpty()) {
                FileEntity dto = new FileEntity(null, UUID.randomUUID().toString(), file.getContentType(), file.getName(),file.getOriginalFilename());
                list.add(dto);
                File newFileName = new File(dto.getUuid()+"_"+dto.getName()+".png");
                file.transferTo(newFileName);
            }
        }
        return "/board/getBoardList";
    }

    @GetMapping(value = "/image/{imagename}", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> userSearch(@PathVariable("imagename") String imagename) throws IOException {
        InputStream imageStream = new FileInputStream("/Users/js/Cleancode/lecture_spring_2_crudProject/src/main/resources/static/upload/" + imagename);
        byte[] imageByteArray = toByteArray(imageStream);
        imageStream.close();
        return new ResponseEntity<byte[]>(imageByteArray, HttpStatus.OK);
    }

//    @GetMapping("/display")
//    public ResponseEntity<Resource> display(@RequestParam("filename") String filename) {
//        String path = "C:\\Temp\\upload\\";
//        String folder = "";
//        Resource resource = new FileSystemResource(path + folder + filename);
//        if(!resource.exists())
//            return new ResponseEntity<Resource>(HttpStatus.NOT_FOUND);
//        HttpHeaders header = new HttpHeaders();
//        Path filePath = null;
//        try{
//            filePath = Paths.get(path + folder + filename);
//            header.add("Content-type", Files.probeContentType(filePath));
//        }catch(IOException e) {
//            e.printStackTrace();
//        }
//        return new ResponseEntity<Resource>(resource, header, HttpStatus.OK);

}
