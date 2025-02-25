package testsFactory;

import entities.Account;

// cria uma fabrica e dentro dela posso deixar varios objetos ja criados pra so usa-los na classe de teste
public class AccountFactory {

    /* importa a classe Account para deixar os objetos Account ja criados.
       normalmente esses metodos sao estaticos, porque nao precisa instanciar eles depois é so chamar a classe e o metodo dela.
       nesse exemplo ciramos um construtor que cria a conta com saldo zero
    */
    public static Account createEmptAccount() {
        return new Account(1L, 0.0);
    }

    // cria a conta, porem o saldo é colocado na hora do teste pelo parametro initialBalance
    public static Account createAccount(double initialBalance) {
        return new Account(1L, initialBalance);
    }
}
