package com.socialprotection.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialprotection.entity.Budget;

public interface BudgetRepository extends JpaRepository<Budget, Long> {

	List<Budget> findByBudgetNameLike(String string);
	
//	List<Budget> find;
//	@Query("SELECT p FROM budgets p WHERE " +
//            "p.budget_name LIKE CONCAT('%', ?1 , '%')")
//    List<Budget> searchBudget(String query);
//	
//	@Query(value = "SELECT * FROM budgets p WHERE " +
//            "p.budget_name LIKE CONCAT('%', ?1, '%')", nativeQuery = true)
//    List<Budget> searchBudgetSQL(String query);
}
