package br.com.tokiomarine.seguradora.avaliacao.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Estudante {
	// TODO Implementar a entidade Estudante conforme solicitado
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull(message = "Nome é obrigatório")
    @NotEmpty(message = "Nome é obrigatório")
    @Column(nullable = false)
    private String nome;

    @NotNull(message = "Email é obrigatório")
    @NotEmpty(message = "Email é obrigatório")
    @Column(nullable = false)
    private String email;

    @Column()
    private String telefone;

    @NotNull(message = "Matrícula é obrigatória")
    @NotEmpty(message = "Matrícula é obrigatória")
    @Column(nullable = false)
    private String matricula;

    @Column()
    private String curso;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
}
