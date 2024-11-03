package stand;

public class Data {
    int dia, mes, ano;

    public Data(int d, int m, int a) {
        this.dia = d;
        this.mes = m;
        this.ano = a;
    }

    public Data(String d) {
        String[] split = d.split("-");
        this.dia = Integer.parseInt(split[0]);
        this.mes = Integer.parseInt(split[1]);
        this.ano = Integer.parseInt(split[2]);
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public String toString() {
        return (getDia() < 10 ? "0" : "") + getDia() + "-" + (getMes() < 10 ? "0" : "") + getMes() + "-" + getAno();
    }
}
