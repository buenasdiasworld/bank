package main.model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "holders")
@Data
public class Holder {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private String name;

  @OneToMany(mappedBy = "holder", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Account> accounts; // у клиента много счетов у счета 1 клиент

}
