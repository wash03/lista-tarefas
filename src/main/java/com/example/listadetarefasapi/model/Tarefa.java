package com.example.listadetarefasapi.model;

import java.util.Objects;

import javax.persistence.*;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Tarefa {
	
	@Id
	@GeneratedValue(generator = "increment")
	@GenericGenerator(name = "increment", strategy = "increment")
	private Long id;
	private String titulo;
	private String descricao;
	private String conselho;
	private boolean status;
}
