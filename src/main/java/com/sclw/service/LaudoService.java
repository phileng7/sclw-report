package com.sclw.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sclw.enums.Perfil;
import com.sclw.exception.ObjectNotFoundException;
import com.sclw.model.Laudo;
import com.sclw.model.LaudoPK;
import com.sclw.repository.LaudoRepository;

@Service
public class LaudoService {
	
	private static final Logger LOG = LogManager.getLogger(LaudoService.class);

	@Autowired 
	LaudoRepository laudoRepository;
	
	public List<Laudo> findByCodLaudoMedAsntId(String codLaudo, Integer medAsntId, String authority) {		
		List<Laudo> list = null;
		if (authority.equals(Perfil.MEDICOASSINANTE.getDescricao()))
			list = laudoRepository.findAllByCodSistemaAndMedicoAssinanteId(codLaudo, medAsntId);
		else if (authority.equals(Perfil.GESTOR.getDescricao()))
			return laudoRepository.findAllByCodSistema(codLaudo);
		else if (authority.equals(Perfil.ATENDENTE.getDescricao()))
			return laudoRepository.findAllByCodSistema(codLaudo);		
		if (list==null || list.size()==0)
			throw new ObjectNotFoundException("Object not found! codLaudo: " + codLaudo + ",medAsntId:" + medAsntId.toString() + ", Type: " + Laudo.class.getName());
		return list;
	}
	
	public Laudo findByIdItem(Integer id, Integer item) {
		Optional<Laudo> obj = laudoRepository.findById(new LaudoPK(id, item));
		return obj.orElseThrow(() -> new ObjectNotFoundException("Object not found! Id: " + id + ", Type: " + LaudoService.class.getName()));
	}
}
