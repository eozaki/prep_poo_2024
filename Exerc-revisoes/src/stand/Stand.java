package stand;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class Stand {
    String nome;
    List<Veiculo> veiculos;

    public Stand(String nome) {
        this.nome = nome;
        veiculos = new LinkedList<Veiculo>();
    }

    public String getNome() {
        return nome;
    }

    public List<Veiculo> getVeiculos() {
        return veiculos;
    }

    public void lerVeiculos (String fileName) throws IOException {
        File f = new File(fileName);
        Scanner sc = new Scanner(f);

        while(sc.hasNextLine()) {
            String[] split = sc.nextLine().split(";");
            if(Integer.parseInt(split[3]) == 4)
                veiculos.add(new Carro(split[0], Integer.parseInt(split[1]), new Data(split[2])));
            else
                veiculos.add(new Carro(split[0], Integer.parseInt(split[1]), new Data(split[2])));
        }

    }

    public int totalValor() {
        int s = 0;
        for(Veiculo v : veiculos)
            s += v.getPreco();

        return s;
    }

    public List<Veiculo> filtrarVeiculos(Predicate<Veiculo> p) {
        LinkedList<Veiculo> l = new LinkedList<>();

        for(Veiculo v : veiculos)
            if(p.test(v)) l.add(v);

        return l;
    }

    @Override
    public String toString() {
        String s = getNome() + "\n"
                + "Veiculos:\n";

        int i = 1;
        for(Veiculo v : veiculos)
            s += "(" + i++ + ") " + v.toString() + "\n";

        s += "Valor total no stand= " + totalValor() + "€";

        return s;
    }
}
