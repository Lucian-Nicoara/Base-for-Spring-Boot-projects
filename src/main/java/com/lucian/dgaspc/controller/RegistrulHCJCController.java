package com.lucian.dgaspc.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lucian.dgaspc.model.HotarareCJC;
import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.service.HotarariCjcService;

/*
 * https://blog.stackpuz.com/create-an-api-for-datatables-with-spring-boot/
*/
@RestController
@RequestMapping("/hotarariHCJC")
public class RegistrulHCJCController {
	
	@Autowired
	private HotarariCjcService hotarariCjcService;
	
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
		hotarariCjcService.incarcaFisier(idHotarare, fisierHotarareCJC.getOriginalFilename(), fisierHotarareCJC.getBytes());
		return ResponseEntity.status(HttpStatus.OK).body("ok");
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
	
	@GetMapping("/arataFisier/{idHotarare}")
	public ResponseEntity<Resource> arataFisier(@PathVariable String idHotarare) {
		HotarareCJC hotarare = hotarariCjcService.getHotarareCuFisier(idHotarare);
		if(hotarare.getNumeFisier() != null && hotarare.getFisier() != null && hotarare.getFisier().length > 0) {
			byte[] bytes = hotarare.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			MediaType mediaType = MediaTypeFactory
					.getMediaType(hotarare.getNumeFisier())
					.orElse(MediaType.APPLICATION_OCTET_STREAM);

			if(mediaType.isCompatibleWith(MediaType.APPLICATION_PDF) || mediaType.isCompatibleWith(MediaType.parseMediaType("image/*"))) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(mediaType);
	
				ContentDisposition disposition = ContentDisposition
						.inline()
						.filename(hotarare.getNumeFisier())
						.build();
				headers.setContentDisposition(disposition);
				return ResponseEntity.ok()
					.headers(headers)
					.contentLength(bytes.length)
					.contentType(mediaType)
					.body(resource);
			}else {
				resource = new InputStreamResource(new ByteArrayInputStream("Fișierul nu poate fi afișat în browser, vă rugăm să descărcați fișierul și să-l deschideți în aplicația asociată acestuia.".getBytes()));
				return ResponseEntity.ok().body(resource);
			}			
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
}