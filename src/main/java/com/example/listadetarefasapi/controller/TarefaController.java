package com.example.listadetarefasapi.controller;

import java.util.List;

import com.example.listadetarefasapi.service.TarefaService;
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

import com.example.listadetarefasapi.model.Tarefa;

@CrossOrigin(origins="*")
@RestController
@RequestMapping("/api")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;
	
	@GetMapping("/tarefa/{id}")
	public Tarefa buscarPorId(@PathVariable Long id) {
		return tarefaService.buscarPorId(id);
	}
	
	@GetMapping("/tarefas")
	public List<Tarefa> filtrar(@RequestParam(required=false) String titulo) {
		return tarefaService.buscarPorTitulo(titulo);
	}

	@PostMapping("/tarefa")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Tarefa> criarTarefa(@RequestBody Tarefa tarefa) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tarefaService.criarTarefa(tarefa));
	}
	
	@PutMapping("/tarefa/{id}")
	public ResponseEntity<Tarefa> editarTarefa(@PathVariable Long id, @RequestBody Tarefa tarefa) {
		return ResponseEntity.ok(tarefaService.editarTarefa(id, tarefa));
	}
	
	
	@DeleteMapping("/tarefa/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removerTarefa(@PathVariable Long id) {
		tarefaService.deletarTarefa(id);
	}
	
}
