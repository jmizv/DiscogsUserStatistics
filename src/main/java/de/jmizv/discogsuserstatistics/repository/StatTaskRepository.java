package de.jmizv.discogsuserstatistics.repository;


import de.jmizv.discogsuserstatistics.model.StatTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StatTaskRepository extends JpaRepository<StatTask, Integer> {

  Optional<StatTask> findByUsername(String username);

  List<StatTask> findTop20ByOrderByCdate();
}
