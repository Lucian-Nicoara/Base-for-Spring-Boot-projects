package com.lucian.base.controller;

import java.io.IOException;
import java.util.List;
import java.io.ByteArrayInputStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
	
	@PostMapping("/incarcaFisier")
	public ResponseEntity<String> uploadFile(@RequestParam() MultipartFile fisierHotarareCJC, @RequestParam() String idHotarare) throws IOException {
		System.out.println("debug fisierHotarareCJC = " + fisierHotarareCJC.getOriginalFilename());
		System.out.println("debug fisierHotarareCJC size = " + fisierHotarareCJC.getSize());
		System.out.println("debug idHotarare = " + idHotarare);
		String message = "";
		hotarariCjcService.incarcaFisier(idHotarare, fisierHotarareCJC.getOriginalFilename(), fisierHotarareCJC.getBytes());
		message = "ok";
		return ResponseEntity.status(HttpStatus.OK).body(message);
		
		/*try {
			hotarariCjcService.incarcaFisier(fisierHotarareCJC.getBytes(), idHotarare);		
			message = "ok";
			return ResponseEntity.status(HttpStatus.OK).body(message);
		} catch (Exception e) {
			message = "eroare";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		}*/
	}
	
	@GetMapping("/downloadFisier/{idHotarare}")
	public ResponseEntity<Resource> downloadFisier(@PathVariable String idHotarare) {
		HotarareCJC hotarare = hotarariCjcService.getHotarareCuFisier(idHotarare);
		if(hotarare.getNumeFisier() != null && hotarare.getFisier() != null && hotarare.getFisier().length > 0) {
			byte[] bytes = hotarare.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Disposition", String.format("attachment; filename=" + hotarare.getNumeFisier()));
			return ResponseEntity.ok()
				.headers(headers)
				.contentLength(bytes.length)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
}