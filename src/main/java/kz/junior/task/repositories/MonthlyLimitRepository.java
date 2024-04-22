package kz.junior.task.repositories;

import kz.junior.task.model.MonthlyLimitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.YearMonth;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimitModel, Long> {

  MonthlyLimitModel findByCreatedDateAndCategory_Id(YearMonth createdDate, Long categoryId);

  MonthlyLimitModel findFirstByCategory_IdOrderByCreatedDateDesc(Long categoryId);

  @Query("SELECT ml FROM MonthlyLimitModel ml WHERE ml.createdDate = :createdDate AND ml.category.id = :categoryId ORDER BY ml.id DESC")
  MonthlyLimitModel findLastByCreatedDateAndCategoryId(@Param("createdDate") YearMonth createdDate, @Param("categoryId") Long categoryId);
}
