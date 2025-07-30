package com.lucian.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.base.mapper.UserDataMapper;
import com.lucian.base.model.HotarareCJC;
import com.lucian.base.model.TableData;
import com.lucian.base.model.UserData;
import com.lucian.base.service.HotarariCjcService;

/*
 * https://blog.stackpuz.com/create-an-api-for-datatables-with-spring-boot/
*/
@RestController
public class DataController {
	
	@Autowired
	HotarariCjcService hotarariCjcService;
	
	@GetMapping("/getHotarariCJC")
	public TableData<HotarareCJC> getHotarariCJC() {
		List<HotarareCJC> hotarariCJC = hotarariCjcService.getHotarariCJC();
		TableData<HotarareCJC> tableData = new TableData<HotarareCJC>(1, hotarariCJC.size(), hotarariCJC.size(), hotarariCJC);
		//tableData.setData(hotarariCJC);
		return tableData;
	}
	
	@PostMapping("/postData")
	public String postData(@RequestBody UserData postData) {
		System.out.println(postData.toString());
		return "ok";
	}
}
