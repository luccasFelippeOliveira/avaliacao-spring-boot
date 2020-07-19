package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import org.springframework.stereotype.Service;

public interface EstudanteService {

	List<Estudante> buscarEstudantes();

	Estudante cadastrarEstudante(@Valid Estudante estudante);

	Estudante buscarEstudante(long id);

	void atualizarEstudante(@Valid Estudante estudante);

	void removerEstudante(long id);
}
