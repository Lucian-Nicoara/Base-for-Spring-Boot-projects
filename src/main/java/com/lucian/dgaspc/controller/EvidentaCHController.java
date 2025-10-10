package com.lucian.dgaspc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.model.CopilHandicap;
import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.service.EvidentaCHService;

@RestController
@PreAuthorize("hasAuthority('OpEvidentaCH')")
@RequestMapping("/evidenta-ch")
public class EvidentaCHController {
	
	@Autowired
	private EvidentaCHService evidentaCHService;
	
	@GetMapping("/getEvidentaCH")
	public TableData<CopilHandicap> getEvidentaCH() {
		List<CopilHandicap> evidentaCH = evidentaCHService.getEvidentaCH();
		TableData<CopilHandicap> tableData = new TableData<CopilHandicap>(evidentaCH.size(), evidentaCH.size(), evidentaCH);
		return tableData;
	}
	
	@PostMapping("/postCH")
	public String postCopilHandicap(@RequestBody CopilHandicap copilHandicap) {
		if(copilHandicap.getDataComisie() != null && !copilHandicap.getDataComisie().isEmpty()) {
			evidentaCHService.postCopilHandicap(copilHandicap);
		}
		return "ok";
	}
	
	@PostMapping("/putCH")
	public String putCopilHandicap(@RequestBody CopilHandicap copilHandicap) {
		if(copilHandicap.getId() != null && !copilHandicap.getId().isEmpty()) {
			evidentaCHService.putCopilHandicap(copilHandicap);
		}
		return "ok";
	}
	
	@PostMapping("/stergeCH")
	public String stergeCopilHandicap(@RequestBody String id) {
		if(id != null && !id.isEmpty()) {
			evidentaCHService.stergeCopilHandicap(id);
			return "ok";
		}else {
			return "error";
		}
	}
}