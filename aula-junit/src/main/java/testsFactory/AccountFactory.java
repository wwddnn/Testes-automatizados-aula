package testsFactory;

import entities.Account;

public class AccountFactory { //criar uma fabrica e dentro dela posso deixar varios objetos ja criados pra so usa-los na classe de teste

    public static Account createEmptAccount() { //importou a classe Account para deixar objetos Account ja criados //normalmente sao estaticos //cria conta com saldo zero
        return new Account(1L, 0.0);
    }

    public static Account createAccount(double initialBalance) { // cria conta mas o saldo é colocado na hora do teste, por isso initialBalance
        return new Account(1L, initialBalance);
    }
}
