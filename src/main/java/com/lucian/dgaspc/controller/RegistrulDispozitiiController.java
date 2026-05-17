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

import com.lucian.dgaspc.model.Dispozitie;
import com.lucian.dgaspc.model.TableData;
import com.lucian.dgaspc.service.DispozitiiService;

/*
 * https://blog.stackpuz.com/create-an-api-for-datatables-with-spring-boot/
*/
@RestController
@PreAuthorize("hasAuthority('OpRegDispozitii')")
@RequestMapping("/registrul-dispozitii")
public class RegistrulDispozitiiController {
	
	@Autowired
	private DispozitiiService dispozitiiService;
	
	@GetMapping("/getDispozitii")
	public TableData<Dispozitie> getDispozitii() {
		List<Dispozitie> dispozitii = dispozitiiService.getDispozitii();
		TableData<Dispozitie> tableData = new TableData<Dispozitie>(dispozitii.size(), dispozitii.size(), dispozitii);
		return tableData;
	}
	
	@PostMapping("/postDispozitie")
	public String postDispozitie(@RequestBody Dispozitie dispozitie) {
		if(dispozitie.getNrDispozitie() != null && !dispozitie.getNrDispozitie().isEmpty()) {
			dispozitiiService.postDispozitie(dispozitie);
		}
		return "ok";
	}
	
	@PostMapping("/putDispozitie")
	public String putDispozitie(@RequestBody Dispozitie dispozitie) {
		if(dispozitie.getId() != null && !dispozitie.getId().isEmpty()) {
			dispozitiiService.putDispozitie(dispozitie);
		}
		return "ok";
	}
	
	@PostMapping("/stergeDispozitie")
	public String stergeDispozitie(@RequestBody String id) {
		if(id != null && !id.isEmpty()) {
			dispozitiiService.stergeDispozitie(id);
			return "ok";
		}else {
			return "error";
		}
	}
	
	@PostMapping("/incarcaFisier")
	public ResponseEntity<String> uploadFile(@RequestParam() MultipartFile fisierDispozitie, @RequestParam() String idDispozitie) throws IOException {
		dispozitiiService.incarcaFisier(idDispozitie, fisierDispozitie.getOriginalFilename(), fisierDispozitie.getBytes());
		return ResponseEntity.status(HttpStatus.OK).body("ok");
	}
	
	@GetMapping("/downloadFisier/{idDispozitie}")
	public ResponseEntity<Resource> downloadFisier(@PathVariable String idDispozitie) {
		Dispozitie dispozitie = dispozitiiService.getDispozitieCuFisier(idDispozitie);
		if(dispozitie.getNumeFisier() != null && dispozitie.getFisier() != null && dispozitie.getFisier().length > 0) {
			byte[] bytes = dispozitie.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			HttpHeaders headers = new HttpHeaders();
			headers.set("Content-Disposition", String.format("attachment; filename=" + dispozitie.getNumeFisier()));
			return ResponseEntity.ok()
				.headers(headers)
				.contentLength(bytes.length)
				.contentType(MediaType.APPLICATION_OCTET_STREAM)
				.body(resource);
		}else {
			return ResponseEntity.badRequest().body(null);
		}
	}
	
	@GetMapping("/arataFisier/{idDispozitie}")
	public ResponseEntity<Resource> arataFisier(@PathVariable String idDispozitie) {
		Dispozitie dispozitie = dispozitiiService.getDispozitieCuFisier(idDispozitie);
		if(dispozitie.getNumeFisier() != null && dispozitie.getFisier() != null && dispozitie.getFisier().length > 0) {
			byte[] bytes = dispozitie.getFisier();
			InputStreamResource resource = new InputStreamResource(new ByteArrayInputStream(bytes));
			MediaType mediaType = MediaTypeFactory
					.getMediaType(dispozitie.getNumeFisier())
					.orElse(MediaType.APPLICATION_OCTET_STREAM);

			if(mediaType.isCompatibleWith(MediaType.APPLICATION_PDF) || mediaType.isCompatibleWith(MediaType.parseMediaType("image/*"))) {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(mediaType);
	
				ContentDisposition disposition = ContentDisposition
						.inline()
						.filename(dispozitie.getNumeFisier())
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