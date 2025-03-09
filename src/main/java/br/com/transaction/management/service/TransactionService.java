package br.com.transaction.management.service;

import br.com.transaction.management.model.Transaction;

import java.util.DoubleSummaryStatistics;

public interface TransactionService {

    public void addTransaction(Transaction transaction);
    public void deleteAllTransactions();
    public DoubleSummaryStatistics getStatistics();
}
