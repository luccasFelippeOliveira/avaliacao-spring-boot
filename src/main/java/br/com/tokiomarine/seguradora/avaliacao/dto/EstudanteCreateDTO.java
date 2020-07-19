package br.com.tokiomarine.seguradora.avaliacao.dto;

import br.com.tokiomarine.seguradora.avaliacao.entidade.Estudante;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EstudanteCreateDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;

    @NotBlank(message = "Email é obrigatório")
    private String email;

    private String telefone;

    @NotBlank(message = "Matrícula é obrigatória")
    private String matricula;

    private String curso;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public Estudante toEstudante() {
        Estudante e = new Estudante();
        e.setNome(this.nome);
        e.setEmail(this.email);
        e.setMatricula(this.matricula);
        e.setCurso(this.curso);

        return e;
    }
}
