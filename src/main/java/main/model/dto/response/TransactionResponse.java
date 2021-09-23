package main.model.dto.response;

import lombok.Data;
import main.model.entity.Account;
import main.model.entity.Transaction;

@Data
public class TransactionResponse {

  private int id;
  private AccountResponse fromAccount;
  private AccountResponse toAccount;
  private double amount;
  private boolean isAccepted;

  public TransactionResponse(Transaction transaction) {
    this.id = transaction.getId();
    this.amount = transaction.getAmount();
    this.isAccepted = transaction.isAccepted();
    this.fromAccount = new AccountResponse(transaction.getFromAccount());
    this.toAccount = new AccountResponse(transaction.getToAccount());
  }

}
