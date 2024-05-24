package kz.junior.task.repositories;

import kz.junior.task.model.ExchangeRateModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRateRepository extends MongoRepository<ExchangeRateModel, String> {
  ExchangeRateModel findFirstByOrderByIdDesc();

}
