package com.example.listadetarefasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.listadetarefasapi.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Long>{

	List<Tarefa> findByTituloIgnoreCaseContains(String titulo);
}
