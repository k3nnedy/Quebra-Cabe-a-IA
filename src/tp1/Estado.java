/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp1;

import java.io.IOException;

/**
 *
 * @author Kennedy
 */
public class Estado {
    private int matriz[][];
    private int linhaV;
    private int colunaV;
    public final int objetivo[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 0}};
    
    public Estado(int matriz[][]) {
        this.matriz = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.matriz[i][j] = matriz[i][j];
                if (this.matriz[i][j] == 0) {
                    this.linhaV = i;
                    this.colunaV = j;
                }
            }
        }
    }
    public Estado() {
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int getLinhaV() {
        return linhaV;
    }

    public void setLinhaV(int linhaV) {
        this.linhaV = linhaV;
    }

    public int getColunaV() {
        return colunaV;
    }

    public void setColunaV(int colunaV) {
        this.colunaV = colunaV;
    }

   

    public void imprimir() throws IOException {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println();
      
    }
    
     public boolean EhObjetivo(){
        int objetivo[][] = {{1,2,3},{4,5,6},{7,8,0}};
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++)
                if(this.matriz[i][j] != objetivo[i][j]){
                    return false;
            }
        }
        return true;
    }
     
    public Estado GeraSucessor(char movimento){
        Estado eSucessor = new Estado(this.getMatriz());
        int x,y;
        
        switch(movimento){
            case 'd':
                x=eSucessor.linhaV;
                y=eSucessor.colunaV-1;
                if(y<0) return null;
                eSucessor.matriz[eSucessor.linhaV][eSucessor.colunaV]=
                        eSucessor.matriz[x][y];
                eSucessor.matriz[x][y]= 0;
                eSucessor.colunaV = y;
                return eSucessor;
                
            case 'e':
                x=eSucessor.linhaV;
                y=eSucessor.colunaV+1;
                if(y>2) return null;
                eSucessor.matriz[eSucessor.linhaV][eSucessor.colunaV]=
                        eSucessor.matriz[x][y];
                eSucessor.matriz[x][y]= 0;
                eSucessor.colunaV = y;
                return eSucessor;
            
            case 'c':
                x=eSucessor.linhaV-1;
                y=eSucessor.colunaV;
                if(x<0) return null;
                eSucessor.matriz[eSucessor.linhaV][eSucessor.colunaV]=
                        eSucessor.matriz[x][y];
                eSucessor.matriz[x][y]= 0;
                eSucessor.linhaV = x;
                return eSucessor;
           
            case 'b':
                x=eSucessor.linhaV+1;
                y=eSucessor.colunaV;
                if(x>2) return null;
                eSucessor.matriz[eSucessor.linhaV][eSucessor.colunaV]=
                        eSucessor.matriz[x][y];
                eSucessor.matriz[x][y]= 0;
                eSucessor.linhaV = x;
                return eSucessor;
        }
       
        return null;
        
    }
  
    
    public void printEstado(){
    for(int i=0; i<3; i++){
        for(int j=0; j<3; j++){
        System.out.print(this.matriz[i][j] + " ");
    }
    System.out.println();
    }
    System.out.println("Linha Vazia: " + this.linhaV);
    System.out.println("Coluna Vazia: " + this.colunaV);
}
}

