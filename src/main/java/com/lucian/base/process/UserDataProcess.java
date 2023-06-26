package com.lucian.base.process;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.base.mapper.UserDataMapper;
import com.lucian.base.model.UserData;

@Service
public class UserDataProcess {
	
	@Autowired
	UserDataMapper userDataMapper;
	
	public List<UserData> getUserData(){
		//do some funky code here and then
		System.out.println("getUserData");
		return userDataMapper.selectAll();
	}
}
