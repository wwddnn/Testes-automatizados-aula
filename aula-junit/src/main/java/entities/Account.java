package entities;

public class Account {

    public static double DEPOSIT_FEE_PERCENTAGE = 0.02; //é uma constante que desconta 0.02 //public para ficar disponivel //

    private Long id;
    private Double balance; //saldo da conta

    public Account() {
    }

    public Account(Long id, Double balance) {
        this.id = id;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBalance() { //consula o valor do saldo
        return balance;
    }

    public void deposit(double amount) { //deposita um valor //tem que ser um valor maior que 0
        if (amount > 0) { //no caso de valor depositado maior que zero
            amount = amount - amount * DEPOSIT_FEE_PERCENTAGE; //diminui o 0.02 do ammount que esta chegando como argumento
            balance += amount; //adiciona o amount ja descontado, la no balance que é o saldo
        }
    }

    public void withdraw (double amount){ //saca um valor
        if (amount > balance) { //se a quantia que pediu pra sacar for maior do que o balance, entao nao tem esse valor pra sacar
            throw new IllegalArgumentException(); //excecao que tem no java por padrao
        }
            balance -= amount;
    }

    public double fullWithdraw() { //saca tudo que tem na conta
        double aux = balance;
        balance = 0.0;
        return aux;
    }
}
