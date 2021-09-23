package main.service;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import main.model.dto.response.AccountResponse;
import main.model.dto.response.ListResponse;
import main.model.dto.response.ResultResponse;
import main.model.entity.Account;
import main.repository.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AccountService {

  private final AccountRepository accountRepository;

  public ListResponse<AccountResponse> getAllAccounts() {

    List<Account> all = accountRepository.findAll();
    List<AccountResponse> accountResponses = new ArrayList<>();
    all.forEach(a -> accountResponses.add(new AccountResponse(a)));
    ListResponse<AccountResponse> response = new ListResponse(accountResponses);

    return response;
  }


  public AccountResponse getAccountById(int id) {

    Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"));

    return new AccountResponse(account);
  }

  public ResultResponse deleteAccount(int id) {
    Account account = accountRepository.findById(id).orElseThrow(() -> new ResponseStatusException(
        HttpStatus.NOT_FOUND, "entity not found"));
    accountRepository.delete(account);
    ResultResponse response = new ResultResponse();
    response.setResult(true);
    return response;
    // удаляются все транзакции
  }
}
