package main.controller;

import lombok.RequiredArgsConstructor;
import main.model.dto.request.NewTransactionRequest;
import main.model.dto.response.ListResponse;
import main.model.dto.response.ResultResponse;
import main.model.dto.response.TransactionResponse;
import main.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

  private final TransactionService transactionService;

  @GetMapping
  public ResponseEntity<ListResponse<TransactionResponse>> getTransactions() {

    return ResponseEntity.ok(transactionService.getAllTransactions());

  }

  @GetMapping("/{id}")
  public ResponseEntity<TransactionResponse> getAccountById(
      @PathVariable int id) {

    return ResponseEntity.ok(transactionService.getTransactionById(id));

  }

  @PostMapping
  public ResponseEntity<ResultResponse> addPost(@RequestBody NewTransactionRequest newTransaction ) {

    return ResponseEntity.ok(transactionService.makeTransaction(newTransaction));

  }

}
