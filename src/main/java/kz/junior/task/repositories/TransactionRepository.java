package kz.junior.task.repositories;

import kz.junior.task.model.TransactionModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<TransactionModel, Long> {
  List<TransactionModel> getAllByLimitExceededTrue();
}
