
package br.com.codenation;

import java.util.Comparator;



public class MeuComparador implements Comparator<Object>{

    @Override
    public int compare(Object o1, Object o2) {
        Jogador A = (Jogador) o1;
        Jogador B = (Jogador) o2;
        if(A.getNivelHabilidade() > B.getNivelHabilidade())
        {
            return -1;
        }
        else if(A.getNivelHabilidade() < B.getNivelHabilidade())
        {
            return 1;
        }
        else if(A.getNivelHabilidade() == B.getNivelHabilidade())
        {
            if(A.getId() < B.getId())
                return -1;
            else
                return 1;
        }
        
        return 0;
    }
    
}
