package ru.otus.atm;

import com.google.common.collect.Lists;
import ru.otus.banknotes.Banknotable;
import ru.otus.banknotes.Nominal;
import ru.otus.banknotes.factory.BanknoteFactory;
import ru.otus.exceptions.IncorrectWithdrawalValue;
import ru.otus.exceptions.NoSuchNominalValueExistsException;

import java.util.*;
import java.util.stream.Collectors;

public class ATM implements CashMachinable {
    private final Map<Nominal, Integer> nominalCount;

    public ATM(Map<Nominal, Integer> map) {
        Map<Nominal, Integer> copyOfMap = new HashMap<>();
        for (Nominal key : map.keySet()) {
            copyOfMap.put(key, map.get(key));
        }
        this.nominalCount = copyOfMap;
    }

    @Override
    public void acceptBanknotes(Banknotable banknote) throws NoSuchNominalValueExistsException {
        recalculateCountOfBanknotes(banknote);
    }

    @Override
    public List<Banknotable> makeWithdrawal(int amount) throws NoSuchNominalValueExistsException, IncorrectWithdrawalValue {
        if (amount % getMinNominalLeft() != 0) {
            throw new IncorrectWithdrawalValue(amount);
        }
        BanknoteFactory banknoteFactory = new BanknoteFactory();
        List<Banknotable> listOfBanknotesForGivingAway = Lists.newArrayList();
        List<Nominal> nominalValuesDescendingSorted =
                Arrays.stream(Nominal.values())
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());

        for (Nominal nominal : nominalValuesDescendingSorted) {
            if (amount >= nominal.getValue()
                    && nominalCount.containsKey(nominal)
                    && !isNominalCountEqualsZero(nominal)) {
                final int countOfBankNotes = amount / nominal.getValue();
                amount -= countOfBankNotes * nominal.getValue();
                for (int m = 0; m < countOfBankNotes; m++) {
                    listOfBanknotesForGivingAway.add(banknoteFactory.getBanknote(nominal));
                }
            }
        }
        recalculateBanknotesLeftOversAfterWithdrawal(listOfBanknotesForGivingAway);
        return listOfBanknotesForGivingAway;
    }


    private void recalculateCountOfBanknotes(Banknotable banknote) throws NoSuchNominalValueExistsException {
        Nominal banknoteNV = banknote.getNominalValue();
        if (nominalCount.containsKey(banknoteNV)) {
            int countOfBankNotes = nominalCount.get(banknoteNV);
            int newCount = countOfBankNotes + 1;
            nominalCount.put(banknoteNV, newCount);
        } else {
            throw new NoSuchNominalValueExistsException(banknoteNV.getValue());
        }
    }

    @Override
    public int getCashBalanceLeft() {
        int countOfBanknotes = 0;
        for (Map.Entry<Nominal, Integer> entry : nominalCount.entrySet()) {
            final Nominal nominal = entry.getKey();
            final Integer amount = entry.getValue();
            countOfBanknotes += nominal.getValue() * amount;
        }
        return countOfBanknotes;
    }

    @Override
    public void recalculateBanknotesLeftOversAfterWithdrawal(List<Banknotable> listOfBanknotesForGivingAway) {
        for (Banknotable b : listOfBanknotesForGivingAway) {
            Nominal banknoteNominal = b.getNominalValue();
            for (Map.Entry<Nominal, Integer> entry : nominalCount.entrySet()) {
                final Nominal existsNominal = entry.getKey();
                final Integer existsAmount = entry.getValue();
                if (existsNominal == banknoteNominal) {
                    int newAmount = existsAmount - 1;
                    nominalCount.put(banknoteNominal, newAmount);
                }
            }
        }
    }

    private int getMinNominalLeft() {
        Nominal minNominal = Nominal.getMaxNominal();
        for (Map.Entry<Nominal, Integer> entry : nominalCount.entrySet()) {
            final Nominal existsNominal = entry.getKey();
            final Integer existsCount = entry.getValue();
            if (existsCount != 0 &&
                    existsNominal.getValue() < minNominal.getValue()) {
                minNominal = existsNominal;
            }
        }
        return minNominal.getValue();
    }

    private boolean isNominalCountEqualsZero(Nominal nominal) {
        for (Map.Entry<Nominal, Integer> entry : nominalCount.entrySet()) {
            final Nominal existsNominal = entry.getKey();
            final Integer existsCount = entry.getValue();
            if (existsNominal == nominal) {
                return existsCount == 0;
            }
        }
        return true;
    }
}
