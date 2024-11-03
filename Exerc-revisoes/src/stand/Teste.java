package stand;

import java.io.IOException;
import java.util.List;

import static Utils.Test.assertEquals;

public class Teste {
    public static void main(String[] args) throws IOException {
        Carro c = new Carro("79-JE-21", 8500, new Data(1, 9, 2023));
        assertEquals(c.toString().contains("Carro"), true);
        assertEquals(c.toString().contains("79-JE-21"), true);
        assertEquals(c.toString().contains("8500"), true);
        assertEquals(c.toString().contains("numero de rodas=4"), true);

        Stand stand = new Stand("Stand Maravilhoso");
        stand.lerVeiculos("veiculos.txt");
        assertEquals(stand.toString().contains("Carro: matricula=AA-10-BB"), true);
        assertEquals(stand.toString().contains("Carro: matricula=23-CC-45"), true);
        assertEquals(stand.toString().contains("Carro: matricula=10-FD-22"), true);
        assertEquals(stand.toString().contains("Valor total no stand= 13300€"), true);

        System.out.println("\nApenas os veiculos com preco inferior a 1000 €:");
        List<Veiculo> veiculosBaratos = stand.filtrarVeiculos((Veiculo v) -> v.getPreco() < 1000);
        assertEquals(veiculosBaratos.size(), 1);
        assertEquals(veiculosBaratos.get(0).getMatricula(), "10-FD-22");
        veiculosBaratos.forEach(v-> System.out.println(v));
    }
}
