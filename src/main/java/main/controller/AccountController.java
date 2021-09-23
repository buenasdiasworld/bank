package main.controller;

import lombok.RequiredArgsConstructor;
import main.model.dto.response.AccountResponse;
import main.model.dto.response.ListResponse;
import main.model.dto.response.ResultResponse;
import main.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

  private final AccountService accountService;

  @GetMapping
  public ResponseEntity<ListResponse<AccountResponse>> getAccounts() {

    return ResponseEntity.ok(accountService.getAllAccounts());

  }

  @GetMapping("/{id}")
  public ResponseEntity<AccountResponse> getAccountById(
      @PathVariable int id) {

    return ResponseEntity.ok(accountService.getAccountById(id));

  }

  @DeleteMapping("/{id}")
  public ResponseEntity <ResultResponse> deleteAccount(@PathVariable int id)
  {
    return ResponseEntity.ok(accountService.deleteAccount(id));
  }

}
