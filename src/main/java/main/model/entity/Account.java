package main.model.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "accounts")
@Data
public class Account {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  private double balance;

  private long number;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "holder_id", referencedColumnName = "id", nullable = false)
  private Holder holder;

  @Column(name = "is_blocked", nullable = false, columnDefinition = "TINYINT")
  private boolean isBlocked;

  @OneToMany(mappedBy = "fromAccount", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Transaction> outgoingTransactions; // перевод с этого счета

  @OneToMany(mappedBy = "toAccount", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Transaction> incomingTransactions; // перевод на этот счет

}
