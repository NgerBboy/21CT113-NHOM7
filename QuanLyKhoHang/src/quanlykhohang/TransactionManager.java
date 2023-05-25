/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlykhohang;

import java.util.ArrayList;

public class TransactionManager {
    private ArrayList<Transaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<Transaction>();
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public Transaction getTransactionById(String id) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getId().equals(id)) {
                return transactions.get(i);
            }
        }
        return null;
    }

   public ArrayList<Transaction> getTransactionsByDate(String date) {
    ArrayList<Transaction> transactionsByDate = new ArrayList<Transaction>();
    for (int i = 0; i < transactions.size(); i++) {
        if (transactions.get(i).getDate().equals(date)) {
            transactionsByDate.add(transactions.get(i));
        }
    }
    return transactionsByDate;
}
}