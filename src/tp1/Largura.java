/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author Kennedy
 */
public class Largura {
    private Queue<No> fronteira = new LinkedList<No>();
    private ArrayList<No> removidosFronteira = new ArrayList<>();
    private int limite = 7;
 

    public Largura() {
        
    }
    
    public void busca(No noInicial){
        //Inserir no inicial na fronteira;
        fronteira.add(noInicial);
        No no = new No();
        ArrayList<No> sucessores = new ArrayList();
        int indice;
        
        //Enquanto a fronteira não estiver vazia
        while(!fronteira.isEmpty()){
            //no = remover na fronteira
            no = fronteira.poll();
            
            this.removidosFronteira.add(no);
            indice = this.removidosFronteira.size()-1;
            
            
            
            //testar se no é objetivo
            if(no.getEstado().EhObjetivo()){
                imprimeCaminho(no);
                return;
            }
            
            if (no.getProfundidade()<limite) {
                
            //Gerar sucessores do no
            sucessores = no.GeraSucessores(indice);
            
            //Inserir sucessores na fronteira;
            fronteira.addAll(sucessores);
            }
        }
    
    }
    
    private void imprimeCaminho(No objetivo){
        if(objetivo.getPai()!= -1)
            imprimeCaminho(removidosFronteira.get(objetivo.getPai()));
        objetivo.getEstado().printEstado();
    }
    
    public void caminho(No no){
        No aux = new No();
        aux.printNo();
        
        while (aux.getPai()!= -1) {            
            aux = removidosFronteira.get(aux.getPai());
            aux.printNo();
        }
    
    }
    
    public Queue<No> getFronteira() {
        return fronteira;
    }

    public void setFronteira(Queue<No> fronteira) {
        this.fronteira = fronteira;
    }

    public ArrayList<No> getRemovidosFronteira() {
        return removidosFronteira;
    }

    public void setRemovidosFronteira(ArrayList<No> removidosFronteira) {
        this.removidosFronteira = removidosFronteira;
    }
}
