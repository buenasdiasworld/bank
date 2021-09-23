package main.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "transactions")
@Data
public class Transaction {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "from_account_id", referencedColumnName = "id", nullable = false)
  private Account fromAccount;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "to_account_id", referencedColumnName = "id", nullable = false)
  private Account toAccount;

  private double amount;

  @Column(name = "is_accepted", nullable = false, columnDefinition = "TINYINT")
  private boolean isAccepted;

}
