package main.model.dto.response;

import lombok.Data;
import main.model.entity.Account;

@Data
public class AccountResponse {

  private int id;
  private double balance;
  private long number;
  private HolderResponse holder;
  private boolean isBlocked;

  public AccountResponse(Account account) {
    this.id = account.getId();
    this.balance = account.getBalance();
    this.number = account.getNumber();
    this.holder = new HolderResponse(account.getHolder());
    this.isBlocked = account.isBlocked();
  }

}
