package algoritmos;

import java.util.Scanner;

public class WorstFit {

    public static void main(String[] args) {

        System.out.println("---------------WORST FIT---------------");
        System.out.println("");
        
        Scanner in = new Scanner(System.in);
        System.out.println("Números de processos:");
        
        int p = in.nextInt();

        System.out.println("Número de blocos de memória:");
        int m = in.nextInt();

        int parr[] = new int[p],
            marr[] = new int[m],
            marrAux[] = new int[m];

        for (int i = 0; i < p; i++) {
            System.out.println("Tamanho do processo (" + (i + 1) + ") :");
            parr[i] = in.nextInt();
        }

        for (int i = 0; i < m; i++) {
            System.out.println("Tamanho da memória [" + (i + 1) + "] :");
            marr[i] = in.nextInt();
            marrAux[i] = 0;
        }
        
        System.out.println("");
        
        int j, i;
        
         for (i = 0; i < m; i++) {
            for (j = i + 1; j < m; j++) {
                if (marr[i] < marr[j]) {
                    int t = marr[i];
                    marr[i] = marr[j];
                    marr[j] = t;
                }
            }
        }
         j = 0;
         
          for (i = 0; i < m; i++) {                   
            if (marr[i] > parr[j] && marrAux[i] == 0) {
                marr[i] -= parr[j];
                System.out.println("Alocado processo " + (j + 1) + " para memória " + (i + 1) + " tamanho que permaneceu depois de alocar " + marr[i]);                                
                j = j + 1;
                marrAux[i] = 1;
                i = 0;
                if (j == p) {                    
                    i = m;
                }
            }                       
        }
        if (j < p) {                                
            System.out.println("Não há mais memória suficiente!");                                            
        } 

    }
}

