package revisoes;

import java.util.Objects;

// Acrescentar o que for necessario, incluindo atributos e codigo no construtor
//
public class MusicaComVariosAutores extends Musica {
	
	String[] autores;
	
	public MusicaComVariosAutores(String titulo, String[] autores, Time duracao) {
		super(titulo, autores[0], duracao);
		this.autores = autores;
	}

	@Override
	public String getAutor() {
		return super.getAutor() + " et al.";
	}

	@Override
	public boolean contemAutor(String autor) {
		for(String a : autores)
			if(Objects.equals(a, autor)) return true;

		return false;
	}
}
