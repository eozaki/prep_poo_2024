package stand;

public abstract class Veiculo {
    String matricula;
    int preco;
    Data dataCompra;

    public Veiculo(String matricula, int preco, Data compra) {
        this.matricula = matricula;
        this.preco = preco;
        this.dataCompra = compra;
    }

    public String getMatricula() {
        return matricula;
    }

    public int getPreco() {
        return preco;
    }

    public Data getDataCompra() {
        return dataCompra;
    }

    public abstract int getNumRodas();

    @Override
    public String toString() {
        return  "matricula=" + getMatricula() + ", "
                + "preco=" + getPreco() + "€, "
                + "data de compra=" + getDataCompra() + ", "
                + "numero de rodas=" + getNumRodas();
    }
}
