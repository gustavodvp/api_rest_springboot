package br.com.gustavoestudos.forumAPI.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.gustavoestudos.forumAPI.controller.dto.TopicoDTO;
import br.com.gustavoestudos.forumAPI.controller.form.TopicoForm;
import br.com.gustavoestudos.forumAPI.modelo.Topico;
import br.com.gustavoestudos.forumAPI.repository.CursoRepository;
import br.com.gustavoestudos.forumAPI.repository.TopicoRepository;

@RestController
@RequestMapping( "/topicos" )
public class TopicosController {	

	@Autowired
	private TopicoRepository topicoRepository;
	
	@Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<TopicoDTO> lista(String nomeCurso){
		List<Topico> topicos;
		
		if( nomeCurso == null )
		{
			topicos = topicoRepository.findAll();
			return TopicoDTO.convertObjectListToDTO(topicos);
		} else {
			topicos = topicoRepository.findByCursoNome( nomeCurso );
			return TopicoDTO.convertObjectListToDTO(topicos);
		}
	}
	
	@PostMapping
	public ResponseEntity<TopicoDTO> cadastrar(@RequestBody @Valid TopicoForm form, UriComponentsBuilder uriBuilder) {
		Topico topico = form.converter( cursoRepository );
		topicoRepository.save(topico);
		
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand( topico.getId() ).toUri();
		return ResponseEntity.created(uri).body(new TopicoDTO(topico));
	}
}