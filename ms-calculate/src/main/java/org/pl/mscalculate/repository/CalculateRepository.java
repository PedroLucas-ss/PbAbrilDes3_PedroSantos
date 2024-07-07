package org.pl.mscalculate.repository;

import org.pl.mscalculate.entities.Calculate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;


public interface CalculateRepository extends JpaRepository<Calculate, Long> {

    @Transactional
    @Modifying
    @Query("update Calculate c set c.category = ?1, c.parity = ?2 where c.id = ?3")
    int updateCategoryAndParityById(@NonNull String category, @NonNull Integer parity, Long id);
}
