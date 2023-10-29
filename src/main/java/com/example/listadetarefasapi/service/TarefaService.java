package com.example.listadetarefasapi.service;

import com.example.listadetarefasapi.model.Tarefa;
import org.springframework.stereotype.Service;

import java.util.List;

public interface TarefaService {
    Tarefa criarTarefa(Tarefa tarefa);

    Tarefa editarTarefa(Long id, Tarefa tarefa);

    void deletarTarefa(Long id);

    Tarefa buscarPorId(Long id);

    List<Tarefa> buscarPorTitulo(String titulo);

}
