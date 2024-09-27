package com.example.demo.Esportes;

import jakarta.persistence.*;

@Entity
@Table(name="esportes")
public class Esporte {

    @Id @GeneratedValue
	private long id;

    private String nome;
    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private String tipo;

    public long getId(){
        return id;
    }
    public void setId(long id){
        this.id = id;
    }
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public int getQtdeMinimaJogadores(){
        return qtdeMinimaJogadores;
    }
    public void setQtdeMinimaJogadores(int qtdeMinimaJogadores){
        this.qtdeMinimaJogadores = qtdeMinimaJogadores;
    }
    public int getQtdeMaximainimaJogadores(){
        return qtdeMaximaJogadores;
    }
    public void setQtdeMaximaJogadores(int qtdeMaximaJogadores){
        this.qtdeMaximaJogadores = qtdeMaximaJogadores;
    }
    public String getTipo(){
        return tipo;
    }
    public void setTipo(String tipo){
        this.tipo = tipo;
    }
}
