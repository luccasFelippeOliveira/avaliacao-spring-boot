package br.com.tokiomarine.seguradora.avaliacao.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;
import br.com.tokiomarine.seguradora.avaliacao.repository.EstudanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServiceImpl implements EstudanteService {

	@Autowired
	private EstudanteRepository repository;

	@Override
	public Estudante cadastrarEstudante(@Valid Estudante estudante) {
		return this.repository.save(estudante);
	}

	@Override
	public void atualizarEstudante(@Valid Estudante estudante) {
		this.repository.save(estudante);
	}

	@Override
	public List<Estudante> buscarEstudantes() {
		return (List<Estudante>) this.repository.findAll();
	}

	@Override
	public Estudante buscarEstudante(long id) {
		Optional<Estudante> optional = this.repository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			throw new RuntimeException("Estudante não encontrado com o id: " + id);
		}
	}

	@Override
	public void removerEstudante(long id) {
		this.repository.deleteById(id);
	}

}
