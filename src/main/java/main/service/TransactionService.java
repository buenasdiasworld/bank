package main.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import main.model.dto.request.NewTransactionRequest;
import main.model.dto.response.ListResponse;
import main.model.dto.response.ResultResponse;
import main.model.dto.response.TransactionResponse;
import main.model.entity.Account;
import main.model.entity.Transaction;
import main.repository.AccountRepository;
import main.repository.TransactionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class TransactionService {

  private final TransactionRepository transactionRepository;
  private final AccountRepository accountRepository;

  public ListResponse<TransactionResponse> getAllTransactions() {

    List<Transaction> all = transactionRepository.findAll();
    List<TransactionResponse> transactionResponses = new ArrayList<>();
    all.forEach(t -> transactionResponses.add(new TransactionResponse(t)));
    ListResponse<TransactionResponse> response = new ListResponse(transactionResponses);

    return response;
  }

  public TransactionResponse getTransactionById(int id) {

    Transaction transaction = transactionRepository.findById(id)
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"));

    return new TransactionResponse(transaction);
  }

  public ResultResponse makeTransaction(NewTransactionRequest newTransaction) {

    ResultResponse result = new ResultResponse();

// проверить существование счетов, блокировки отправителя, баланс отправителя, блокировку получателя

    Account from = accountRepository.findAccountByNumber(newTransaction.getFromAccount())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"));

    if(from.isBlocked()) {
      result.setResult(false);
      result.setMessage("your account is blocked");
      return result;
    }

    if( from.getBalance() < newTransaction.getAmount()) {
      result.setResult(false);
      result.setMessage("balance is not enough");
      return result;
    }

    Account to = accountRepository.findAccountByNumber(newTransaction.getToAccount())
        .orElseThrow(() -> new ResponseStatusException(
            HttpStatus.NOT_FOUND, "entity not found"));

    if(to.isBlocked()) {
      result.setResult(false);
      result.setMessage("destination account is blocked");
      return result;
    }

    Transaction transaction = new Transaction();

    transaction.setAccepted(true);
    transaction.setAmount(newTransaction.getAmount());
    transaction.setFromAccount(from);
    transaction.setToAccount(to);

    from.setBalance(from.getBalance()-newTransaction.getAmount());
    to.setBalance(to.getBalance()+newTransaction.getAmount());

    // ---- сохранять только все вместе (?)

    transactionRepository.save(transaction);
    accountRepository.save(from);
    accountRepository.save(to);

    result.setResult(true);

    return result;
  }
}
