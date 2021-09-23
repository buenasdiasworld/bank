package main.model.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Response<T> {

  private T data;


  public Response(T data) {
    this.data = data;

  }


}
