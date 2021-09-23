package main.model.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NewTransactionRequest {

  @JsonProperty("from_account")
  private long fromAccount;
  @JsonProperty("to_account")
  private long toAccount;
  private double amount;


}
