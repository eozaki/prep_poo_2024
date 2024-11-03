package stand;

public class Carro extends Veiculo {
    public Carro(String matricula, int preco, Data compra) {
        super(matricula, preco, compra);
    }

    @Override
    public int getNumRodas() {
        return 4;
    }

    @Override
    public String toString() {
        return "Carro: " + super.toString();
    }
}
