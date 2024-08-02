
package com.pjt.project01.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.pjt.project01.mapper.DevMapper;

@Controller
public class DevController {
 
	@Autowired @Qualifier("sql1")//오토커밋되라고 빈에다가 만들어줬던것임 까먹어ㅠㅠ
	private SqlSession sql;
	
	@Autowired
	private DevMapper dm;
	
	@GetMapping("/list") 
	public String home(Model model) {
		model.addAttribute("list", dm.signup());
		
		return "home1";
	}
	@GetMapping("/") 
	public String list(Model model) {
		model.addAttribute("list", dm.storeList());
		model.addAttribute("list1", dm.list1());
		return "home";
	}
	
	@GetMapping("/insert")
	public String insert() {
		Map<String, Object> map = new HashMap<>();
		map.put("storeNum", 3);
		map.put("review", "미역");
		dm.review(map);
//		sql.insert("sql.Review", new HashMap<String, Object>() {{
//			put("StoreNum", "미역");
//			put("Review", false); 
//		}});
		return "redirect:/list";
	}
	
	
	
	
	
	
}
