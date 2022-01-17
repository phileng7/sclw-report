package com.sclw.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sclw.model.Laudo;
import com.sclw.service.LaudoService;

@Controller
@RequestMapping(value = "/laudos")
public class LaudoController {
	
	@Autowired
	LaudoService laudoService;
	
	@GetMapping("/medasnt")
	public ResponseEntity<List<Laudo>> findByCodLaudoMedAsntId(
			@RequestParam(value="codLaudo") String codLaudo,
			@RequestParam(value="medAsntId") Integer medAsntId,
			@RequestParam(value="authority") String authority) {
		List<Laudo> list = laudoService.findByCodLaudoMedAsntId(codLaudo,medAsntId,authority);
		return ResponseEntity.ok(list);
	}
	
	@GetMapping("/id")
	public ResponseEntity<Laudo> findByIdIdAndItem(@RequestParam (value="id") Integer id, @RequestParam (value="item") Integer item) {
		Laudo obj = laudoService.findByIdItem(id,item);
		return ResponseEntity.ok(obj);
	}
}
