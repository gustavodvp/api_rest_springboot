package br.com.gustavoestudos.forumAPI.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.gustavoestudos.forumAPI.modelo.Curso;
import br.com.gustavoestudos.forumAPI.modelo.Topico;
import br.com.gustavoestudos.forumAPI.repository.CursoRepository;

public class TopicoForm {

	@NotNull @NotEmpty @Length(min = 5)
	private String titulo;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String mensagem;
	
	@NotNull @NotEmpty @Length(min = 5)
	private String nomeCurso;
	
	
	/**
	 * @return the titulo
	 */
	public String getTitulo() {
		return titulo;
	}
	/**
	 * @param titulo the titulo to set
	 */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	/**
	 * @return the mensagem
	 */
	public String getMensagem() {
		return mensagem;
	}
	/**
	 * @param mensagem the mensagem to set
	 */
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	/**
	 * @return the nomeCurso
	 */
	public String getNomeCurso() {
		return nomeCurso;
	}
	/**
	 * @param nomeCurso the nomeCurso to set
	 */
	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}
	public Topico converter( CursoRepository repository ) {
		Curso curso = repository.findByNome( nomeCurso );
		return new Topico( titulo, mensagem, curso );
	}
}
