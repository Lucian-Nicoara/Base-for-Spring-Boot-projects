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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lucian.dgaspc.model.SedintaCD;
import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.service.SedinteCDService;

@RestController
@PreAuthorize("hasAuthority('OpRegConsDir')")
@RequestMapping("/sedinteCD")
public class SedinteCDController {
	
	@Autowired
	private SedinteCDService sedinteCDService;
	
	@GetMapping("/getSedinteCD")
	public TableData<SedintaCD> getSedinteCD() {
		List<SedintaCD> hotarariCJC = sedinteCDService.getSedinteCD();
		TableData<SedintaCD> tableData = new TableData<SedintaCD>(hotarariCJC.size(), hotarariCJC.size(), hotarariCJC);
		return tableData;
	}
	
	@PostMapping("/postSedintaCD")
	public String postSedintaCD(@RequestBody SedintaCD sedintaCD) {
		if(sedintaCD.getSedinta() != null && !sedintaCD.getSedinta().isEmpty()) {
			sedinteCDService.postSedintaCD(sedintaCD);
		}
		return "ok";
	}
	
	@PostMapping("/putSedintaCD")
	public String putSedintaCD(@RequestBody SedintaCD sedintaCD) {
		if(sedintaCD.getId() != null && !sedintaCD.getId().isEmpty()) {
			sedinteCDService.putSedintaCD(sedintaCD);
		}
		return "ok";
	}
	
	@PostMapping("/stergeSedintaCD")
	public String stergeSedintaCD(@RequestBody String id) {
		if(id != null && !id.isEmpty()) {
			sedinteCDService.stergeSedintaCD(id);
			return "ok";
		}else {
			return "error";
		}
	}
	
	@PostMapping("/incarcaFisier")
	public ResponseEntity<String> uploadFile(@RequestParam() MultipartFile fisierSedintaCD, @RequestParam() String idSedintaCD) throws IOException {
		sedinteCDService.incarcaFisier(idSedintaCD, fisierSedintaCD.getOriginalFilename(), fisierSedintaCD.getBytes());
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	
	@GetMapping("/downloadFisier/{idHotarare}")
	public ResponseEntity<Resource> downloadFisier(@PathVariable String idSedintaCD) {
		SedintaCD sedintaCD = sedinteCDService.getHotarareCuFisier(idSedintaCD);
		if(sedintaCD.getNumeFisier() != null && sedintaCD.getFisier() != null && sedintaCD.getFisier().length > 0) {
			byte[] bytes = sedintaCD.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Disposition", String.format("attachment; filename=" + sedintaCD.getNumeFisier()));
			return ResponseEntity.ok()
				.headers(headers)
				.contentLength(bytes.length)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping("/arataFisier/{idSedintaCD}")
	public ResponseEntity<Resource> arataFisier(@PathVariable String idSedintaCD) {
		SedintaCD sedintaCD = sedinteCDService.getHotarareCuFisier(idSedintaCD);
		if(sedintaCD.getNumeFisier() != null && sedintaCD.getFisier() != null && sedintaCD.getFisier().length > 0) {
			byte[] bytes = sedintaCD.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			MediaType mediaType = MediaTypeFactory
					.getMediaType(sedintaCD.getNumeFisier())
					.orElse(MediaType.APPLICATION_OCTET_STREAM);

			if(mediaType.isCompatibleWith(MediaType.APPLICATION_PDF) || mediaType.isCompatibleWith(MediaType.parseMediaType("image/*"))) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(mediaType);
	
				ContentDisposition disposition = ContentDisposition
						.inline()
						.filename(sedintaCD.getNumeFisier())
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