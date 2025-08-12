package com.lucian.base.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.base.model.HotarareCJC;
import com.lucian.base.model.TableData;
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
		System.out.println(hotarariCJC.toString());
		TableData<HotarareCJC> tableData = new TableData<HotarareCJC>(hotarariCJC.size(), hotarariCJC.size(), hotarariCJC);
		return tableData;
	}
	
	@PostMapping("/postHotarareCJC")
	public String postHotarareCJC(@RequestBody HotarareCJC hotarareCJC) {
		System.out.println("debug /postHotarareCJC");
		System.out.println(hotarareCJC.toString());
		if(hotarareCJC.getNrHotarare() != null && !hotarareCJC.getNrHotarare().isEmpty()) {
			hotarariCjcService.postHotarareCJC(hotarareCJC);
		}
		return "ok";
	}
	
	@PostMapping("/putHotarareCJC")
	public String putHotarareCJC(@RequestBody HotarareCJC hotarareCJC) {
		System.out.println("debug /putHotarareCJC");
		System.out.println(hotarareCJC.toString());
		if(hotarareCJC.getId() != null && !hotarareCJC.getId().isEmpty()) {
			hotarariCjcService.putHotarareCJC(hotarareCJC);
		}
		return "ok";
	}
}
