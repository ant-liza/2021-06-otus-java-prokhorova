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
    private int countOfHundredBanknotes = 100;
    private int countOfTwoHundredBanknotes = 100;
    private int countOfFiveHundredBanknotes = 200;
    private int countOfThousandHundredBanknotes = 100;

    @Override
    public void acceptBanknotes(Banknotable banknote) throws NoSuchNominalValueExistsException {
        recalculateCountOfBanknotes(banknote);
    }

    @Override
    public List<Banknotable> makeWithdrawal(int amount) throws NoSuchNominalValueExistsException, IncorrectWithdrawalValue {
        if (amount % 100 != 0) {
            throw new IncorrectWithdrawalValue();
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
        switch (banknoteNV) {
            case HUNDRED:
                countOfHundredBanknotes++;
                break;
            case TWO_HUNDRED:
                countOfTwoHundredBanknotes++;
                break;
            case FIVE_HUNDRED:
                countOfFiveHundredBanknotes++;
                break;
            case THOUSAND:
                countOfThousandHundredBanknotes++;
                break;
            default:
                throw new NoSuchNominalValueExistsException();
        }
    }

    @Override
    public int getCashBalanceLeft() {
        return countOfHundredBanknotes * 100
                + countOfTwoHundredBanknotes * 200
                + countOfFiveHundredBanknotes * 500
                + countOfThousandHundredBanknotes * 1000;
    }

    @Override
    public void recalculateBanknotesLeftOversAfterWithdrawal(List<Banknotable> listOfBanknotesForGivingAway) {
        for (Banknotable b : listOfBanknotesForGivingAway) {
            NominalValue banknoteNominal = b.getNominalValue();
            if (banknoteNominal == NominalValue.HUNDRED) {
                countOfHundredBanknotes--;
            } else if (banknoteNominal == NominalValue.TWO_HUNDRED) {
                countOfTwoHundredBanknotes--;
            } else if (banknoteNominal == NominalValue.FIVE_HUNDRED) {
                countOfFiveHundredBanknotes--;
            } else if (banknoteNominal == NominalValue.THOUSAND) {
                countOfThousandHundredBanknotes--;
            }
        }
    }
}
