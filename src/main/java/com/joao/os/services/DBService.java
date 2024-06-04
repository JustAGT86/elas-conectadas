package com.joao.os.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.os.domain.Cliente;
import com.joao.os.domain.OS;
import com.joao.os.domain.Tecnico;
import com.joao.os.domain.enuns.Prioridade;
import com.joao.os.domain.enuns.Status;
import com.joao.os.repositories.ClienteRepository;
import com.joao.os.repositories.OSRepository;
import com.joao.os.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private OSRepository osRepository;

	public void instanciaDB() {
		
		Tecnico t1 = new Tecnico(null, "Placeholder 1", "245.787.600-14","(43) 99912-3456");
		Cliente c1 = new Cliente(null, "Placeholder 2", "455.613.920-18", "(43) 99912-6543");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1 );
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		

	}
	
}
