package com.lucian.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.base.mapper.UserDataMapper;
import com.lucian.base.model.TableData;
import com.lucian.base.model.UserData;

/*
 * https://blog.stackpuz.com/create-an-api-for-datatables-with-spring-boot/
*/
@RestController
public class DataController {
	
	@Autowired
	UserDataMapper userDataMapper;
	
	@GetMapping("/getUserData")
	public TableData<UserData> datatableData(Model model) {
		List<UserData> users = userDataMapper.selectAll();
		TableData<UserData> tableData = new TableData<UserData>(1, users.size(), users.size(), users);
		tableData.setData(users);
		return tableData;
	}
	
	@PostMapping("/postData")
	public String postData(@RequestBody UserData postData) {
		System.out.println(postData.toString());
		return "ok";
	}
}
