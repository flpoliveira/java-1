package br.com.codenation;

import java.util.Comparator;

public class ComparaIdade implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Jogador A = (Jogador) o1;
		Jogador B = (Jogador) o2;
		if(A.getDataNascimento().compareTo(B.getDataNascimento()) == 0)
			return A.getId().compareTo(B.getId());
		else
			return A.getDataNascimento().compareTo(B.getDataNascimento());
	}

}
