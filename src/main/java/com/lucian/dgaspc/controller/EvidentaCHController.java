package com.lucian.dgaspc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lucian.dgaspc.model.CopilHandicap;
import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.service.EvidentaCHService;

@RestController
@RequestMapping("/evidenta-ch")
public class EvidentaCHController {
	
	@Autowired
	private EvidentaCHService evidentaCHService;

	@PreAuthorize("hasAnyAuthority('OpEvidentaCH', 'ConsEvidentaCH')")
	@GetMapping("/getEvidentaCH")
	public TableData<CopilHandicap> getEvidentaCH(@RequestParam String filtruDataComisieStart, @RequestParam String filtruDataComisieEnd, @RequestParam String filtruVarstaStart, @RequestParam String filtruVarstaEnd) {
		List<CopilHandicap> evidentaCH = evidentaCHService.getEvidentaCH(filtruDataComisieStart, filtruDataComisieEnd, filtruVarstaStart, filtruVarstaEnd);
		//System.out.println(filtruDataComisieStart);
		TableData<CopilHandicap> tableData = new TableData<CopilHandicap>(evidentaCH.size(), evidentaCH.size(), evidentaCH);
		return tableData;
	}
	
	@PreAuthorize("hasAuthority('OpEvidentaCH')")
	@GetMapping("/getCopilByCNP")
	public CopilHandicap getCopilByCNP(@RequestParam String cnp) {
		CopilHandicap copil = evidentaCHService.getCopilByCNP(cnp);
		return copil;
	}
	
	@PreAuthorize("hasAuthority('OpEvidentaCH')")
	@PostMapping("/postCH")
	public String postCopilHandicap(@RequestBody CopilHandicap copilHandicap) {
		if(copilHandicap.getDataComisie() != null && !copilHandicap.getDataComisie().isEmpty()) {
			evidentaCHService.postCopilHandicap(copilHandicap);
		}
		return "ok";
	}
	
	@PreAuthorize("hasAuthority('OpEvidentaCH')")
	@PostMapping("/putCH")
	public String putCopilHandicap(@RequestBody CopilHandicap copilHandicap) {
		if(copilHandicap.getId() != null && !copilHandicap.getId().isEmpty()) {
			evidentaCHService.putCopilHandicap(copilHandicap);
		}
		return "ok";
	}
	
	@PreAuthorize("hasAuthority('OpEvidentaCH')")
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