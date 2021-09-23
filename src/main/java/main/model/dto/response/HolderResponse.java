package main.model.dto.response;

import lombok.Data;
import main.model.entity.Holder;
@Data
public class HolderResponse {

  private int id;

  private String name;

  public HolderResponse (Holder holder){
    this.id = holder.getId();
    this.name = holder.getName();

  }

}
