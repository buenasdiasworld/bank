package main.repository;

import main.model.entity.Holder;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HolderRepository extends JpaRepository<Holder, Integer> {


}
