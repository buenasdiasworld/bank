package main.repository;

import java.util.Optional;
import main.model.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {

Optional<Account> findAccountByNumber(long number);

}
