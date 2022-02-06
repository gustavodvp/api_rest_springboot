package br.com.gustavoestudos.forumAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.gustavoestudos.forumAPI.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

	Curso findByNome(String nome);
	
}
