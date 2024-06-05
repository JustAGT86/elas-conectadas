package com.joao.os.resorces;

import java.net.URI;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.joao.os.DTOs.TecnicoDTO;
import com.joao.os.domain.Pessoa;
import com.joao.os.domain.Tecnico;
import com.joao.os.repositories.PessoaRepository;
import com.joao.os.repositories.TecnicoRepository;
import com.joao.os.services.TecnicoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

	@Autowired
	private TecnicoRepository service;

	@GetMapping(value = "/")
	public ResponseEntity<List<Tecnico>> findById() {
		List<Tecnico> pessoa1 = service.findAll();
		return ResponseEntity.ok().body(pessoa1);
	}

}
