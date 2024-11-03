package revisoes;

import java.io.IOException;
import java.util.function.Predicate;

import static Utils.Test.assertEquals;

public class Teste {

	public static void main(String[] args) throws IOException {
		
		Musica m1 = new Musica("Jolas e Bola", "Serafim", new Time("3:35"));
		Musica m2 = new Musica("Amor de Mae", "Rubi", new Time("4:35"));
		
		String[] autores_m3 = {"Quim da Bairrada", "Nando"};
		Musica m3 = new MusicaComVariosAutores("De Burrico para Lisboa", autores_m3, new Time("6:05"));
		
		Playlist p1 = new Playlist("Pimbalhada");
		
		// Testar o codigo desenvolvido em todas as questoes
		
		// Exerc 1
		assertEquals(p1.toString(), "Pimbalhada:\n");
		p1.addMusica(m1);
		p1.addMusica(m2);
		assertEquals(p1.toString(), "Pimbalhada:\nJolas e Bola, 3:35, Serafim\nAmor de Mae, 4:35, Rubi\n");

		// Exerc 2
		assertEquals(m3.getAutor(), "Quim da Bairrada et al.");
		
		// Exerc 3
		assertEquals(p1.tamanhoDaLista(), 2);
		p1.lerMusicas("musicas.txt");
		assertEquals(p1.tamanhoDaLista(), 13);
		
		// Exerc 4
		assertEquals(p1.getMusicaAt(0).getDuracao().toString(), new Time("3:35").toString()); // Primeira musica adicionada à lista
		p1.ordenarMusicas();
		assertEquals(p1.getMusicaAt(0).getDuracao().toString(), new Time("3:20").toString()); // Musica mais curta do ficheiro 'musicas.txt'

		// Exerc 5
		Playlist p2 = p1.musicasDoAutor("Quim da Bairrada");
		assertEquals(p2.tamanhoDaLista(), 4);

		// Exerc 6
		assertEquals(p1.tamanhoDaLista(), 13);
		Predicate<Musica> musicasMuitoLongas = (Musica m) -> m.getDuracao().totalSeconds() > 360;
		p1.excluirMusicas(musicasMuitoLongas);
		assertEquals(p1.tamanhoDaLista(), 10);

		Predicate<Musica> musicasComEmNoTitulo = (Musica m) -> m.getTitulo().contains("em");
		p1.excluirMusicas(musicasComEmNoTitulo);
		assertEquals(p1.tamanhoDaLista(), 8);
	}
}
