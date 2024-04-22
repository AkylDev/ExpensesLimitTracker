package kz.junior.task.repositories;

import kz.junior.task.model.MonthlyLimitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimitModel, Long> {

  MonthlyLimitModel findByCreatedDateAndCategory_Id(YearMonth createdDate, Long categoryId);

}
