package kz.junior.task.repositories;

import kz.junior.task.model.ExchangeRateModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends JpaRepository<ExchangeRateModel, Long> {
  ExchangeRateModel findFirstByOrderByIdDesc();

}
