package com.joao.os.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joao.os.DTOs.TecnicoDTO;
import com.joao.os.domain.Tecnico;
import com.joao.os.repositories.TecnicoRepository;
import com.joao.os.services.exceptions.DataIntegratyViolationException;
import com.joao.os.services.exceptions.ObjectNotFoundException;

import jakarta.validation.Valid;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository; 
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(()-> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo:" + Tecnico.class.getName()));
	}
	
	public List<Tecnico> findAll() {
		return repository.findAll();
	}
	
	public Tecnico create(TecnicoDTO objDTO) {
		
		if(findByCPF(objDTO) != null) {
			throw new DataIntegratyViolationException("CPf ja cadastrado na base de dados");
		}
		return repository.save(new Tecnico(null, objDTO.getNome(), objDTO.getCpf(), objDTO.getTelefone()));
	}
	
	public Object update(Integer id, @Valid TecnicoDTO objDTO) {
		Tecnico oldObj = findById(id);
		if(findByCPF(objDTO) != null && findByCPF(objDTO).getId() != id){
			throw new DataIntegratyViolationException("CPf ja cadastrado na base de dados");
		}

		oldObj.setNome(objDTO.getNome());
		oldObj.setCpf(objDTO.getCpf());
		oldObj.setTelefone(objDTO.getTelefone());
		
		return repository.save(oldObj);
	}
	
	private Tecnico findByCPF(TecnicoDTO objDTO) {
		Tecnico obj = repository.findByCPF(objDTO.getCpf());
		if(obj != null) {
			return obj;
		}
		return null;
	}
	
}
