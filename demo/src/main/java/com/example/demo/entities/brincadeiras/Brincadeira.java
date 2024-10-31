package com.example.demo.entities.brincadeiras;
import com.example.demo.entities.itemCultural.ItemCultural;

import jakarta.persistence.*;

@Entity
@DiscriminatorValue("BRINCADEIRA")
public class Brincadeira extends ItemCultural { 
    private int qtdeMinimaJogadores;
    private int qtdeMaximaJogadores;
    private String habilidadePrincipal;
            
    public Brincadeira() {
        super();
    }
     
    public int getQtdeMinimaJogadores() {
        return qtdeMinimaJogadores;
    }
    public void setQtdeMinimaJogadores(int qtdeMinimaJogadores){
        this.qtdeMinimaJogadores=qtdeMinimaJogadores;
    }
    public int getQtdeMaximaJogadores() {
        return qtdeMaximaJogadores;
    }
    public void setQtdeMaximaJogadores(int qtdeMaximaJogadores){
        this.qtdeMaximaJogadores=qtdeMaximaJogadores;
    }
    public String getHabilidadePrincipal() {
        return habilidadePrincipal;
    }
    public void getHabilidadePrincipal(String habilidadePrincipal){
        this.habilidadePrincipal=habilidadePrincipal;
    }
}
