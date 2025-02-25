package testsEntities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testsFactory.AccountFactory;

// nome da classe com sufixo tests
public class AccountTests {

    /*
    acao should efeito(when necessario)
    Padrao AAA Arrange(instanciar objetos), Act(executar), Assert(resultado esperado)
    */
    @Test
    public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {


        // as 3 linhas sao o Arrange do AAA. essa variavel amount ja existe dentro da calsse Account

        double amount = 200.0;
        // variavel com o valor esperado
        double expectedValue = 196.0;

        // Arrange(instancia objetos). vai na classe fabrica e tras o metodo ja com new de criar a conta com saldo zero
        Account acc = AccountFactory.createEmptAccount();

        // Act do AAA (executa o metodo)
        acc.deposit(200.0);


        // é o Assert do AAA. usa a biblioteca do junit chamada Assertions que tem varios metodos estaticos
        Assertions.assertEquals(expectedValue, acc.getBalance());
    }

    @Test
    public void DepositShouldDoNothingWhenNegativeAmount() {

        // aproveito a variavel para usa-la depois ao criar a conta
        double expectedValue = 100.0;
        // vai na classe fabrica e tras o metodo ja com new de criar a conta mas o saldo escolhe o valor na hora
        Account acc = AccountFactory.createAccount(expectedValue);
        // valor depositado é negativo ou seja não tem que acontecer nada com a conta
        double amount = -200.0;

        // executa o medoto deposit com valor negativo, e nao acontece nada com a conta, porque o valor é negativo de deposito
        acc.deposit(amount);

        // valor esperado tem que ser os mesmos 100 de quando criei a conta
        Assertions.assertEquals(expectedValue, acc.getBalance() );
    }

    // só tem 1 cenário por isso nao usamos o WHEN no nome do metodo
    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

        double expectedValue = 0.0;
        // usamos a variavel quando escrevemos o mesmo valor em varios lugares
        double initialBalance = 800.0;
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        // varias formas de fazer sua asserçao, sua declaracao
        Assertions.assertTrue(expectedValue == acc.getBalance());
        // pode ter quantas assertions quiser
        Assertions.assertTrue(result == initialBalance);
        // outra forma de fazer o assertion
        Assertions.assertEquals(expectedValue, acc.fullWithdraw());
    }

    // cada cenario é um teste diferente.
    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalance() {

        // cria uma conta ocm 800 de saldo
        Account acc = AccountFactory.createAccount(800.00);

        // executo a minha ação, vou sacar 500
        acc.withdraw(500.0);

        Assertions.assertEquals(300.0, acc.getBalance() );
    }

    // é uma exceção, é diferente dos casos anteriores, nesse caso a quantia é maior do que o saldo disponivel
    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() {

        // uma Assertion de excecao
        // coloca o tipo da exceção e o class, e depois o codigo executado dentro da expressao lambda
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            // crio uma conta com 800 de saldo
            Account acc = AccountFactory.createAccount(800.00);
            // vou sacar um valor maior do que o disponivel
            acc.withdraw(801.0);
        });
    }
}
