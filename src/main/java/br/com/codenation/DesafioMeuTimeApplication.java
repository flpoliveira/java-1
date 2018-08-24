package br.com.codenation;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.codenation.desafio.annotation.Desafio;
import br.com.codenation.desafio.app.MeuTimeInterface;

public class DesafioMeuTimeApplication implements MeuTimeInterface {
	
	private ArrayList<Time> times = new ArrayList<Time>();
	private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();

	@Desafio("incluirTime")
	public void incluirTime(Long id, String nome, LocalDate dataCriacao, String corUniformePrincipal, String corUniformeSecundario) {
		 for(Time aux : times)
	        {
	            if(aux.getId().compareTo(id) == 0)
	            {
	                throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();
	            }
	        }
	        times.add(new Time(id, nome, dataCriacao, corUniformePrincipal, corUniformeSecundario));
		

	}

	@Desafio("incluirJogador")
	public void incluirJogador(Long id, Long idTime, String nome, LocalDate dataNascimento, Integer nivelHabilidade, BigDecimal salario) {
		for(Jogador aux : jogadores)
	    {
			if(aux.getId().compareTo(id) == 0)
	        {
				// System.out.println("Exceção de Identificador utilizado");
	            throw new br.com.codenation.desafio.exceptions.IdentificadorUtilizadoException();
	            //throw new UnsupportedOperationException("Identificador ja utilizado.");
	        }
	    }
	    for(Time aux : times)
	    {
	    	if(aux.getId().compareTo(idTime) == 0)
	        {
	    		jogadores.add(new Jogador(id, idTime, nome, dataNascimento, nivelHabilidade, salario));
	            return;
	        }
	   }
	   //throw new UnsupportedOperationException("Time nao existe.");
	   throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
		

		
	}

	@Desafio("definirCapitao")
	public void definirCapitao(Long idJogador) {
		for(Jogador aux : jogadores)
        {
            if(aux.getId().compareTo(idJogador) == 0)
            {
                for(Time time: times)
                {
                    if(time.getId().compareTo(aux.getIdTime()) == 0)
                    {
                         time.setCapitao(aux.getId());
                         //System.out.println(time.getNome());
                         return;
                    }
                       
                }
            }
        }
        throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
       // throw new UnsupportedOperationException("Jogador não existe."); //To change body of generated methods, choose Tools | Templates.
	}

	@Desafio("buscarCapitaoDoTime")
	public Long buscarCapitaoDoTime(Long idTime) {
		for(Time aux : times)
        {
            if(aux.getId().compareTo(idTime) == 0)
            {
                if(aux.getCapitao() ==  null)
                {
                	throw new br.com.codenation.desafio.exceptions.CapitaoNaoInformadoException();
                    //throw new UnsupportedOperationException("Time Sem Capitao.");
                }
                else
                {
                    return aux.getCapitao();
                }
                    
            }
        }
        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
        //throw new UnsupportedOperationException("Time nao encontrado."); 
	}

	@Desafio("buscarNomeJogador")
	public String buscarNomeJogador(Long idJogador) {
		 for(Jogador aux : jogadores)
	        {
	            if(aux.getId().compareTo(idJogador) == 0)
	            {
	                return aux.getNome();
	            } 
	        }
	        
	        throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
	        //throw new UnsupportedOperationException("Jogador não encontrado.");
	}

	@Desafio("buscarNomeTime")
	public String buscarNomeTime(Long idTime) {
		 for(Time aux : times)
	        {
	            if(aux.getId().compareTo(idTime) == 0)
	            {
	                return aux.getNome();
	            }
	        }
	        
	       	throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
	        //throw new UnsupportedOperationException("Time nao encontrado.");
		
	}

	@Desafio("buscarJogadoresDoTime")
	public List<Long> buscarJogadoresDoTime(Long idTime) {
		   for(Time aux : times)
	        {
	            if(aux.getId().compareTo(idTime) == 0)
	            {
	                List<Long> lista = new ArrayList<Long>();
	                for(Jogador jogador : jogadores)
	                {
	                    
	                    if(jogador.getIdTime().compareTo(aux.getId()) == 0)
	                    {
	                        lista.add(jogador.getId());
	                    }
	                }
	                Collections.sort(lista);
	                return lista;
	            }
	        }
	        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
	        //throw new UnsupportedOperationException("Time não encontrado."); 
	}

	@Desafio("buscarMelhorJogadorDoTime")
	public Long buscarMelhorJogadorDoTime(Long idTime) {
		 for(Time aux : times)
	        {
	            if(aux.getId().compareTo(idTime) == 0)
	            {
	                Integer max = 0;
	                Long id = null;
	                for(Jogador jogador : jogadores)
	                {
	                    if(jogador.getIdTime().compareTo(idTime) == 0)
	                    {
	                        if(id == null )
	                        {
	                            id = jogador.getId();
	                            max = jogador.getNivelHabilidade();
	                        }
	                        else if(jogador.getNivelHabilidade() > max )
	                        {
	                           id = jogador.getId();
	                           max = jogador.getNivelHabilidade();
	                        }
	                    }
	                  
	                }
	                return id;
	            }
	        }
	        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
	        //throw new UnsupportedOperationException("Time não encontrado."); 
	}

	@Desafio("buscarJogadorMaisVelho")
	public Long buscarJogadorMaisVelho(Long idTime) {
		for(Time aux : times)
        {
            if(aux.getId().compareTo(idTime) == 0)
            {
                Integer max = 0;
                Jogador neymar = null;
                for(Jogador jogador : jogadores)
                {
                    
                    if(jogador.getIdTime().compareTo(idTime) == 0)
                    {
                        if(neymar == null )
                        {
                            
                            neymar = jogador;
                            max = Math.abs(jogador.getDataNascimento().compareTo(LocalDate.now()));
                        }
                        else if(Math.abs(jogador.getDataNascimento().compareTo(LocalDate.now())) > max )
                        {
                            
                           neymar = jogador;
                           max = jogador.getDataNascimento().compareTo(LocalDate.now());
                        }
                        else if(Math.abs(jogador.getDataNascimento().compareTo(LocalDate.now())) == max)
                        {
                            
                            if(neymar.getId() > jogador.getId())
                            {
                                neymar = jogador;
                            }
                        }

                    }
                  
                }
                return neymar.getId();
            }
        }
        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
        //throw new UnsupportedOperationException("Time não encontrado."); 
	}

	@Desafio("buscarTimes")
	public List<Long> buscarTimes() {
		List<Long> lista = new ArrayList<Long>();
	       for(Time time : times)
	       {
	           lista.add(time.getId());
	       }
	       Collections.sort(lista);
	       return lista;

	}

	@Desafio("buscarJogadorMaiorSalario")
	public Long buscarJogadorMaiorSalario(Long idTime) {
		 for(Time aux : times)
	        {
	            if(aux.getId().compareTo(idTime) == 0)
	            {
	                BigDecimal max = new BigDecimal(0);
	                Jogador neymar = null;
	                for(Jogador jogador : jogadores)
	                {
	                    if(jogador.getIdTime().compareTo(idTime) == 0)
	                    {
	                        if(neymar == null )
	                        {
	                            neymar = jogador;
	                            max = jogador.getSalario();
	                        }
	                        else if(jogador.getSalario().compareTo(max) > 0 )
	                        {
	                            neymar = jogador;
	                            max = jogador.getSalario();
	                        }
	                        else if(jogador.getSalario().compareTo(max) == 0)
	                        {
	                             if(neymar.getId() > jogador.getId())
	                            {
	                                neymar = jogador;
	                            }
	                        }
	                    }
	                  
	                }
	                return neymar.getId();
	            }
	        }
	        throw new br.com.codenation.desafio.exceptions.TimeNaoEncontradoException();
	        //throw new UnsupportedOperationException("Time não encontrado.");
	}

	@Desafio("buscarSalarioDoJogador")
	public BigDecimal buscarSalarioDoJogador(Long idJogador) {
		 for(Jogador aux : jogadores)
	        {
	            if(aux.getId().compareTo(idJogador) == 0)
	            {
	                return aux.getSalario();
	            }
	        }
	        throw new br.com.codenation.desafio.exceptions.JogadorNaoEncontradoException();
	        //throw new UnsupportedOperationException("Jogador não existe.");
	}
	
	


	@Desafio("buscarTopJogadores")
	public List<Long> buscarTopJogadores(Integer top) {
		List<Long> lista = new ArrayList<Long>();
        List<Jogador> topJogadores = new ArrayList<Jogador>();
        
        for(Jogador jogador : jogadores)
        {
            if(topJogadores.size() == 0)
                topJogadores.add(jogador);
            else
            {
                for(Jogador neymar : topJogadores)
                {
                    if(jogador.getId().compareTo(neymar.getId()) != 0)
                    {
                        if(jogador.getNivelHabilidade() >= neymar.getNivelHabilidade())
                        {
                            topJogadores.add(jogador);
                            break;
                        }
                    }

                }
            }
         
            Collections.sort(topJogadores, new MeuComparador());
          
            if(topJogadores.size() > top)
            {
               
                topJogadores.remove(((int) top));
            }
                
      
        }
        
        for(Jogador jogador : topJogadores)
        {

            lista.add(jogador.getId());
        }
       
        return lista;
	}

	@Desafio("buscarCorCamisaTimeDeFora")
	public String buscarCorCamisaTimeDeFora(Long timeDaCasa, Long timeDeFora) {
		Time time_timeDaCasa = null;
	    Time time_timeDeFora = null;
		for(Time aux : times)
		{
	            if(aux.getId().compareTo(timeDaCasa) == 0)
	                time_timeDaCasa = aux;
	            if(aux.getId().compareTo(timeDeFora) == 0)
	                time_timeDeFora = aux;
		}
		if(time_timeDaCasa.getCorUniformePrincipal().equals(time_timeDeFora.getCorUniformePrincipal()))
		{
	            return time_timeDeFora.getCorUniformeSecundario();
		}
		else
		{
	            return time_timeDeFora.getCorUniformePrincipal();
		}
	}

	public ArrayList<Time> getTimes() {
		return times;
	}

	public void setTimes(ArrayList<Time> times) {
		this.times = times;
	}

	public ArrayList<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(ArrayList<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	
	
}
