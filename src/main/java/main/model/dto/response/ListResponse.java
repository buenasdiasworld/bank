package main.model.dto.response;

import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ListResponse<T> {

  private List<T> data;

  public ListResponse(List<T> data) {
    this.data = data;
  }

}
