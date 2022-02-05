package br.com.gustavoestudos.forumAPI.controller;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gustavoestudos.forumAPI.controller.dto.TopicoDTO;
import br.com.gustavoestudos.forumAPI.modelo.Curso;
import br.com.gustavoestudos.forumAPI.modelo.Topico;

@RestController
public class TopicosController {	

	@RequestMapping("/topicos")
	public List<TopicoDTO> lista(){
		Topico topico = new Topico("Dúvida", "Duvida relativa a Spring", new Curso("Spring", "Programação"));
		
	
		return TopicoDTO.convertObjectListToDTO( Arrays.asList(topico) );
	}
}