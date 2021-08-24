package ru.otus;

import ru.otus.atm.ATM;
import ru.otus.banknotes.Nominal;
import ru.otus.banknotes.factory.BanknoteFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATMMain {

    public static void main(String[] args) throws Exception {
        BanknoteFactory banknoteFactory = new BanknoteFactory();
        Map<Nominal, Integer> countOfNominal = new HashMap<>();
        countOfNominal.put(Nominal.HUNDRED, 100);
        countOfNominal.put(Nominal.THOUSAND, 50);
        countOfNominal.put(Nominal.TWO_HUNDRED, 50);
        countOfNominal.put(Nominal.FIVE_HUNDRED, 20);
        ATM atm = new ATM(countOfNominal);
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
