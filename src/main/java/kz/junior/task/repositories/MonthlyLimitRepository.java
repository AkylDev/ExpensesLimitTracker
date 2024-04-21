package kz.junior.task.repositories;

import kz.junior.task.model.MonthlyLimitModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyLimitRepository extends JpaRepository<MonthlyLimitModel, Long> {
}
