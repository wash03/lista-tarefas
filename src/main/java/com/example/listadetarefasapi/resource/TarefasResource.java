package com.example.listadetarefasapi.resource;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.listadetarefasapi.model.Tarefas;
import com.example.listadetarefasapi.repository.TarefasRepository;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class TarefasResource {

	@Autowired
	private TarefasRepository tarefasRepository;
	
	@GetMapping("/tarefas/{id}")
	public Tarefas buscarPorId(@PathVariable Long id) {
		return this.tarefasRepository.findById(id).orElse(null);
	}
	
	@GetMapping("/tarefas")
	public List<Tarefas> buscarPorTitulo(@RequestParam(required=false) String titulo) {
		if(titulo==null) {
				return tarefasRepository.findAll();
			}else {
				return tarefasRepository.findByTituloIgnoreCaseContains(titulo);
			}
	}
	
	@PostMapping("/tarefas")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tarefas> criarTarefa(@RequestBody Tarefas tarefas) {
		tarefas.setStatus(false);
		Tarefas t = tarefasRepository.save(tarefas);
		return ResponseEntity.ok(t);
	}
	
	@PutMapping("/tarefas/{id}")
	public ResponseEntity<Tarefas> editarTarefa(@PathVariable Long id, @RequestBody Tarefas tarefa) {
		Tarefas tarefaSalva = this.tarefasRepository.findById(id).orElse(null);
		if(tarefaSalva == null) {
			return ResponseEntity.notFound().build();
		}
		BeanUtils.copyProperties(tarefa, tarefaSalva, "id");
		Tarefas t =  tarefasRepository.save(tarefaSalva);
		return ResponseEntity.ok(t);
	}
	
	
	@DeleteMapping("/tarefas/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerTarefa(@PathVariable Long id) {
		tarefasRepository.deleteById(id);
	}
	
}
