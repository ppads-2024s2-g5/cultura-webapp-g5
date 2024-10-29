package com.example.demo.entities.jogoTabuleiro;

import com.example.demo.entities.itemCultural.ItemCultural;

import jakarta.persistence.*;

@Entity
public class JogoTabuleiro extends ItemCultural{

    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private int idadeMinima;
    private int duracaoMediaMinutos;

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
}
