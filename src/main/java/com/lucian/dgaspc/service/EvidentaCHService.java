package com.lucian.dgaspc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucian.dgaspc.mapper.EvidentaCHMapper;
import com.lucian.dgaspc.model.CopilHandicap;

@Service
public class EvidentaCHService{
	
	@Autowired
	EvidentaCHMapper evidentaCHMapper;
	
	public List<CopilHandicap> getEvidentaCH() {
		return evidentaCHMapper.getEvidentaCH();
	}
	
	public CopilHandicap getCopilHandicapById(String id) {
		return evidentaCHMapper.getCopilHandicapById(id);
	}
	
	public Integer postCopilHandicap(CopilHandicap copilHandicap) {
		return evidentaCHMapper.postCopilHandicap(copilHandicap);
	}
	
	public void stergeCopilHandicap(String id) {
		evidentaCHMapper.stergeCopilHandicap(id);
	}
	
	public void putCopilHandicap(CopilHandicap copilHandicap) {
		evidentaCHMapper.putCopilHandicap(copilHandicap);
	}
}
