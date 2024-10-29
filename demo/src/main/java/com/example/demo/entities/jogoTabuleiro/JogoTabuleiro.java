package com.example.demo.entities.jogoTabuleiro;

import jakarta.persistence.*;

@Entity
@Table(name="jogos_tabuleiro")
public class JogoTabuleiro {

    @Id @GeneratedValue
	private long id;

    private String nome;
    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private int idadeMinima;
    private int duracaoMediaMinutos;
    private int anoLancamento;

    // Getters e Setters

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

    public int getQtdeMaximaJogadores(){
        return qtdeMaximaJogadores;
    }

    public void setQtdeMaximaJogadores(int qtdeMaximaJogadores){
        this.qtdeMaximaJogadores = qtdeMaximaJogadores;
    }

    public int getIdadeMinima(){
        return idadeMinima;
    }

    public void setIdadeMinima(int idadeMinima){
        this.idadeMinima = idadeMinima;
    }

    public int getDuracaoMediaMinutos(){
        return duracaoMediaMinutos;
    }

    public void setDuracaoMediaMinutos(int duracaoMediaMinutos){
        this.duracaoMediaMinutos = duracaoMediaMinutos;
    }

    public int getAnoLancamento(){
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento){
        this.anoLancamento = anoLancamento;
    }
}
