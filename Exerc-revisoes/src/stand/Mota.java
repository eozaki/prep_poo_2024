package stand;

public class Mota extends Veiculo {
    public Mota(String matricula, int preco, Data compra) {
        super(matricula, preco, compra);
    }

    @Override
    public int getNumRodas() {
        return 2;
    }

    @Override
    public String toString() {
        return "Mota: " + super.toString();
    }
}
