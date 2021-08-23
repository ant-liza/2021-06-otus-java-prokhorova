package ru.otus.atm;

import com.google.common.collect.Lists;
import ru.otus.banknotes.Banknotable;
import ru.otus.banknotes.NominalValue;
import ru.otus.banknotes.factory.BanknoteFactory;
import ru.otus.exceptions.IncorrectWithdrawalValue;
import ru.otus.exceptions.NoSuchNominalValueExistsException;

import java.util.*;
import java.util.stream.Collectors;

public class ATM implements CashMachinable {
    Map<NominalValue, Integer> existsCountOfNominalMap;

    public ATM(Map<NominalValue, Integer> map) {
        this.existsCountOfNominalMap = map;
    }

    @Override
    public void acceptBanknotes(Banknotable banknote) throws NoSuchNominalValueExistsException {
        recalculateCountOfBanknotes(banknote);
    }

    @Override
    public List<Banknotable> makeWithdrawal(int amount) throws NoSuchNominalValueExistsException, IncorrectWithdrawalValue {
        if (amount % 100 != 0) {
            throw new IncorrectWithdrawalValue(amount);
        }
        BanknoteFactory banknoteFactory = new BanknoteFactory();
        List<Banknotable> listOfBanknotesForGivingAway = Lists.newArrayList();
        List<NominalValue> nominalValuesDescendingSorted =
                Arrays.stream(NominalValue.values())
                        .sorted(Comparator.reverseOrder())
                        .collect(Collectors.toList());
        for (NominalValue nominal : nominalValuesDescendingSorted) {
            if (amount >= nominal.getValue()) {
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
        NominalValue banknoteNV = banknote.getNominalValue();
        if (existsCountOfNominalMap.containsKey(banknoteNV)) {
            int countOfBankNotes = existsCountOfNominalMap.get(banknoteNV);
            int newCount = countOfBankNotes + 1;
            existsCountOfNominalMap.put(banknoteNV, newCount);
        } else {
            throw new NoSuchNominalValueExistsException(banknoteNV.getValue());
        }
    }

    @Override
    public int getCashBalanceLeft() {
        int countOfBanknotes = 0;
        for (Map.Entry<NominalValue, Integer> entry : existsCountOfNominalMap.entrySet()) {
            final NominalValue nominal = entry.getKey();
            final Integer amount = entry.getValue();
            countOfBanknotes += nominal.getValue() * amount;
        }
        return countOfBanknotes;
    }

    @Override
    public void recalculateBanknotesLeftOversAfterWithdrawal(List<Banknotable> listOfBanknotesForGivingAway) {
        Map<NominalValue, Integer> hf = null;
        for (Banknotable b : listOfBanknotesForGivingAway) {
            NominalValue banknoteNominal = b.getNominalValue();
            for (Map.Entry<NominalValue, Integer> entry : existsCountOfNominalMap.entrySet()) {
                final NominalValue existsNominal = entry.getKey();
                final Integer existsAmount = entry.getValue();
                if (existsNominal == banknoteNominal) {
                    int newAmount = existsAmount - 1;
                    existsCountOfNominalMap.put(banknoteNominal, newAmount);
                }
            }
        }
    }
}
