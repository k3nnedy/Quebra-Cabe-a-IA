/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.util.ArrayList;


/**
 *
 * @author Kennedy
 */
public class No implements Comparable<No>{
    private Estado estado; 
    private int profundidade;
    private int pai;
    private int heuristica;
    private int funcaoAvaliacao;
    private int heuristicaManhattan;
    
    

    public No(Estado estado, int profundidade, int pai) {
        this.estado = estado;
        this.profundidade = profundidade;
        this.pai = pai;
        funcaoHeuristica();
        this.funcaoAvaliacao = this.profundidade + this.heuristica;
    }
    

    public No() {
       
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getProfundidade() {
        return profundidade;
    }

    public void setProfundidade(int profundidade) {
        this.profundidade = profundidade;
    }

    public int getPai() {
        return pai;
    }

    public void setPai(int pai) {
        this.pai = pai;
    }

    public int getHeuristica() {
        return heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = heuristica;
    }

    public int getFuncaoAvaliacao() {
        return funcaoAvaliacao;
    }

    public void setFuncaoAvaliacao(int funcaoAvaliacao) {
        this.funcaoAvaliacao = funcaoAvaliacao;
    }
    
    
     public ArrayList<No> GeraSucessores(int pai) {
        ArrayList<No> sucessores = new ArrayList<>();
        Estado e;
        No noSucessor;
       
        e = this.estado.GeraSucessor('d'); 
        if (e != null) {
            noSucessor = new No(e,this.profundidade+1, pai);
            sucessores.add(noSucessor);
        }
       
        e = this.estado.GeraSucessor('e'); 
        if (e != null) {
            noSucessor = new No(e,this.profundidade+1, pai);
            sucessores.add(noSucessor);
        }
        
        e = this.estado.GeraSucessor('c'); 
        if (e != null) {
            noSucessor = new No(e,this.profundidade+1, pai);
            sucessores.add(noSucessor);
        }
        
        e = this.estado.GeraSucessor('b'); 
        if (e != null) {
            noSucessor = new No(e,this.profundidade+1, pai);
            sucessores.add(noSucessor);
        }

        return sucessores;
    }
    public void printNo(){
        System.out.println("Estado: ");
        this.estado.printEstado();
        System.out.println("Pai: " + this.pai);
        System.out.println("Profundidade: " + this.profundidade);
    
    }
    
    @Override
   public int compareTo(No no){
        if(this.getFuncaoAvaliacao()> no.getFuncaoAvaliacao())
            return 1;
        else if(this.getFuncaoAvaliacao() < no.getFuncaoAvaliacao())
            return -1;
        else return 0;
    }
    
     public int funcaoHeuristica() {
        heuristica = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (this.estado.getMatriz()[i][j] != this.estado.objetivo[i][j]) {
                    heuristica++;
                }
            }
        }
        
        return heuristica;
    }
     
   public int funcaoHeuristicaManhattan(No no){
       heuristicaManhattan = 0;
       for(int i=0; i<3; i++){
           for(int j=0; j<3; j++){
               if(no.estado.getMatriz()[i][j]!=this.estado.objetivo[i][j]){
                   for(int m=0; m<3; m++){
                       for(int n=0; n<3; n++){
                           if(no.estado.getMatriz()[i][j]==this.estado.objetivo[m][n])
                               heuristicaManhattan = (Math.abs(i-m)) + (Math.abs(j-n));
                       }
                   }
                   
               }
           }
       }
       
    return heuristicaManhattan;
    }
}

