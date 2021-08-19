package ru.otus;

import ru.otus.atm.ATM;
import ru.otus.banknotes.NominalValue;
import ru.otus.banknotes.factory.BanknoteFactory;

import java.util.Scanner;

public class ATMMain {

    public static void main(String[] args) throws Exception {
        BanknoteFactory banknoteFactory = new BanknoteFactory();
        ATM atm = new ATM();
        System.out.println("Вносим 100");
        atm.acceptBanknotes(banknoteFactory.getBanknote(NominalValue.HUNDRED));
        System.out.println("Вносим 1000");
        atm.acceptBanknotes(banknoteFactory.getBanknote(NominalValue.THOUSAND));
        System.out.println("Сумма денег в банкомате:\n" + atm.getCashBalanceLeft());
        //вводим сумму для снятия
        System.out.println("---Введите сумму для снятия---");
        Scanner scan = new Scanner(System.in);
        int userWithdrawal = scan.nextInt();

        System.out.println("Список выданных банкнот:");
        atm.makeWithdrawal(userWithdrawal).forEach(System.out::println);
        System.out.println("Сумма денег в банкомате после выдачи наличных:\n" + atm.getCashBalanceLeft());
    }
}
