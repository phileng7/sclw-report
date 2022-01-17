package com.sclw.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sclw.model.Laudo;
import com.sclw.model.LaudoPK;

@Repository
public interface LaudoRepository extends JpaRepository<Laudo, LaudoPK>{

	List<Laudo> findAllByIdId(Integer id);
	List<Laudo> findAllByIdIdAndMedicoAssinanteId(Integer id, Integer medico_assinante_id);
	List<Laudo> findAllByIdIdAndMedicoRequisitanteId(Integer id, Integer medico_requisitante_id);
	List<Laudo> findAllByIdIdAndPacienteId(Integer id, Integer paciente_id);
	List<Laudo> findAllByCodSistemaAndMedicoAssinanteId(String codSistema, Integer medAsntId);
	List<Laudo> findAllByCodSistemaAndMedicoAssinanteIdAndConcluido(String codSistema, Integer medAsntId, String concluido);
	List<Laudo> findAllByCodSistemaAndConcluido(String codSistema, String concluido);
	List<Laudo> findAllByCodSistema(String codSistema);
		
	List<Laudo> findAllByData(LocalDate data);
	List<Laudo> findAllByDataAndMedicoAssinanteIdAndConcluido(String data, Integer medico_assinante_id, String concluido);
	List<Laudo> findAllByDataAndConcluido(String data, String concluido);
	List<Laudo> findAllByDataBetweenAndMedicoAssinanteIdAndConcluido(String dataStart, String dataEnd, Integer medico_assinante_id, String concluido);
	List<Laudo> findAllByDataBetweenAndConcluido(String dataStart, String dataEnd, String concluido);
	List<Laudo> findAllByDataAndMedicoRequisitanteId(String data, Integer medico_requisitante_id);
	List<Laudo> findAllByDataAndPacienteId(LocalDate data, Integer paciente_id);
	
	Laudo findAllByIdIdAndIdItem(Integer id, Integer item);
	
	List<Laudo> findAllMedicoAssinanteById(Integer id);
	
	Laudo findFirstByOrderByIdIdDesc();
}
