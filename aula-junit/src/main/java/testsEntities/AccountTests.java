package testsEntities;

import entities.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import testsFactory.AccountFactory;

public class AccountTests { //nome da classe com sufixo tests

    @Test
    public void depositShouldIncreaseBalanceAndDiscountFeeWhenPositiveAmount() { //acao should efeito(when necessario)
        // Padrao AAA Arrange(instanciar objetos), Act(executar), Assert(resultado esperado)

        double amount = 200.0; //as 3 linhas sao o Arrange do AAA//essa variavel amount ja existe dentro da calsse Account
        double expectedValue = 196.0; //crio uma variavel com o valor esperado
        Account acc = AccountFactory.createEmptAccount(); //Arrange(instanciar objetos) //vai na classe fabrica e tras de la o metodo ja com new de criar a conta com saldo zero

        acc.deposit(200.0); //Act do AAA //Act (executar o metodo)

        Assertions.assertEquals(expectedValue, acc.getBalance()); //é o Assert do AAA //Assert //usar biblioteca do junit chamada Assertions que tem varios metodos estaticos
    }

    @Test
    public void DepositShouldDoNothingWhenNegativeAmount() {

        double expectedValue = 100.0; //aproveito a variavel para usa-la depois ao criar a conta
        Account acc = AccountFactory.createAccount(expectedValue); //vai na classe fabrica e tras o metodo ja com new de criar a conta mas o saldo escolhe o valor na hora
        double amount = -200.0; //valor depositado é negativo

        acc.deposit(amount); //executo o medoto deposit com valor negativo

        Assertions.assertEquals(expectedValue, acc.getBalance() ); //valor esperado tem que ser os mesmos 100 de quando criei a conta
    }

    @Test
    public void fullWithdrawShouldClearBalanceAndReturnFullBalance() {

        double expectedValue = 0.0;
        double initialBalance = 800.0; //usamos variavel quando escrevemos o mesmo valor em varios lugares
        Account acc = AccountFactory.createAccount(initialBalance);

        double result = acc.fullWithdraw();

        Assertions.assertTrue(expectedValue == acc.getBalance()); //varias formas de fazer sua asserçao, sua declaracao
        Assertions.assertTrue(result == initialBalance); //pode ter quantas assertions quiser
    }

    @Test
    public void withdrawShouldDecreaseBalanceWhenSufficientBalace() {

        Account acc = AccountFactory.createAccount(800.00);

        acc.withdraw(500.0);

        Assertions.assertEquals(300.0, acc.getBalance() );
    }

    @Test
    public void withdrawShouldThrowExceptionWhenInsufficientBalance() { //é uma exceção, é diferente dos casos anteriores

        Assertions.assertThrows(IllegalArgumentException.class, () -> { //coloca o tipo da exceção e o class
            Account acc = AccountFactory.createAccount(800.00);
            acc.withdraw(801.0);
        });

    }

}
