package com.example.listadetarefasapi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.listadetarefasapi.model.Tarefas;

public interface TarefasRepository extends JpaRepository<Tarefas, Long>{

	List<Tarefas> findByTituloIgnoreCaseContains(String titulo);
}
