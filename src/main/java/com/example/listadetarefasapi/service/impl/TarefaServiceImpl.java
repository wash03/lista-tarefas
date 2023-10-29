package com.example.listadetarefasapi.service.impl;

import com.example.listadetarefasapi.model.Tarefa;
import com.example.listadetarefasapi.repository.TarefaRepository;
import com.example.listadetarefasapi.service.ConselhoService;
import com.example.listadetarefasapi.service.TarefaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TarefaServiceImpl implements TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    @Autowired
    private ConselhoService conselhoService;
    @Override
    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setStatus(false);
        tarefa.setConselho(conselhoService.getConselho());

        return tarefaRepository.save(tarefa);
    }

    @Override
    public Tarefa editarTarefa(Long id, Tarefa tarefa) {
        Tarefa tarefaSalva = this.tarefaRepository.findById(id).orElse(null);
        if(tarefaSalva == null) {
            return null;
        }
        BeanUtils.copyProperties(tarefa, tarefaSalva, "id");
        return tarefaRepository.save(tarefaSalva);
    }

    @Override
    public void deletarTarefa(Long id) {
        tarefaRepository.deleteById(id);
    }

    @Override
    public Tarefa buscarPorId(Long id) {
        return this.tarefaRepository.findById(id).orElse(null);
    }

    @Override
    public List<Tarefa> buscarPorTitulo(String titulo) {
        if(titulo == null) return tarefaRepository.findAll();
        else {
            return tarefaRepository.findByTituloIgnoreCaseContains(titulo);
        }
    }
}
