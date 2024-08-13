
package com.app.controller;
 
import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.mapper.DevMapper;
 
@Controller
public class DevController {
 
//	@Autowired @Qualifier("sql1")//오토커밋되라고 빈에다가 만들어줬던것임 까먹어ㅠㅠ
//	private SqlSession sql;
	
	@Autowired
	private DevMapper dm;
	
	@GetMapping("/") 
	public String list(Model model) {
		model.addAttribute("list", dm.storeList()); 
		return "home";
	}
	
	@GetMapping("/singUp") 
	public String singUp() {
		return "signUp";
	}
	
	
	
	@GetMapping("/userHome") 
	public String userHome( ) { 
		return "userHome";
	}
	

	@GetMapping("/detail/{StoreNum}")
	public String detail(@PathVariable("StoreNum") int num, Model model) { 
	    model.addAttribute("findOne", dm.findOne(num));
//	    System.out.println(dm.listReview(num));
	    model.addAttribute("listReview", dm.listReview(num));
//	    // 리뷰가 있다면 추가
//	    if (review != null) {
//	        model.addAttribute("review", review);
//	    } 
	    return "detail";
	} 
	
	@PostMapping("/submitReview")
	public String submitReview(@RequestParam("storeNum") int storeNum,
	                           @RequestParam("review") String review,
	                           RedirectAttributes redirectAttributes) {
	    // 파라미터 맵에 storeNum과 review를 저장
	    Map<String, Object> paramMap = new HashMap<>();
	    paramMap.put("storeNum", storeNum);
	    paramMap.put("review", review);

	    // 리뷰를 데이터베이스에 삽입
	    int result = dm.InsertReview(paramMap);
	    System.out.println(result + "");	    
	    // 삽입 성공 여부에 따라 처리 (성공하면 /detail/{storeNum}으로 리다이렉트)
	    if (result > 0) {
	        return "redirect:/detail/" + storeNum;
	    } else {
	        // 실패 시 에러 메시지 전달 및 리다이렉트
	        redirectAttributes.addFlashAttribute("errorMessage", "리뷰 등록에 실패했습니다.");
	        return "redirect:/detail/" + storeNum;
	    }
	}
	
	
	
	}

