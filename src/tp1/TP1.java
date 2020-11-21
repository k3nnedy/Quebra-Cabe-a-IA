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
public class TP1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int estadoInicial [][]={{1,2,3},{4,0,5},{7,8,6}};
        Estado e = new Estado(estadoInicial);
        e.printEstado();
        
        No noInicial = new No(e,0,-1);
        //Profundidade prof = new Profundidade();
        //prof.busca(noInicial);
        
        Largura larg = new Largura();
        larg.busca(noInicial);
        
        //A_Estrela estrela = new A_Estrela();
        //estrela.busca(noInicial);
       
    }
    
}
