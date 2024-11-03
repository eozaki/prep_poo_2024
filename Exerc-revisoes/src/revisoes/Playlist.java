package revisoes;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.function.Predicate;


public class Playlist {

	private List<Musica> musicas;
	private final String nome;

	public Playlist(String nome) {
		this.nome = nome;
		musicas = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}
	 
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}

	public String toString() {
		String s = getNome() + ":\n";

		for(Musica m : musicas) {
			s += m.toString() + "\n";
		}

		return s;
	}

	public void lerMusicas(String fileName) throws IOException {
		File f = new File(fileName);

		Scanner sc = new Scanner(f);
		while(sc.hasNextLine()) {
			String[] split = sc.nextLine().split(";");
			String nome = split[0];
			Time t = new Time(split[1]);

			String[] artistas = sc.nextLine().split(";");

			musicas.add(new MusicaComVariosAutores(nome, artistas, t));
		}
	}

	public int tamanhoDaLista() {
		return musicas.size();
	}

	public void ordenarMusicas() {
		musicas.sort(new CriterioMusicas());
	}

	private class CriterioMusicas implements Comparator<Musica> {
		@Override
		public int compare(Musica m1, Musica m2) {
			if(m1.getDuracao().totalSeconds() == m2.getDuracao().totalSeconds())
				return String.CASE_INSENSITIVE_ORDER.compare(m1.getTitulo(), m2.getTitulo());

			return m1.getDuracao().totalSeconds() - m2.getDuracao().totalSeconds();
		}
	}

	public Musica getMusicaAt(int i) {
		return musicas.get(i);
	}

	public Playlist musicasDoAutor(String autor) {
		Playlist p = new Playlist("Só as melhores da(o) artista: " + autor);

		for(Musica m : musicas)
			if(m.contemAutor(autor)) p.addMusica(m);

		return p;
	}

	public void excluirMusicas(Predicate<Musica> pred) {
		List<Musica> aRemover = new LinkedList<>();

		for(Musica m : musicas)
			if(pred.test(m)) aRemover.add(m);

		musicas.removeAll(aRemover);
	}
}
