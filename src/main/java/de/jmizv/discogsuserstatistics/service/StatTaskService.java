package de.jmizv.discogsuserstatistics.service;


import de.jmizv.discogsuserstatistics.model.StatTask;
import de.jmizv.discogsuserstatistics.repository.StatTaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatTaskService {

  private final StatTaskRepository _statTaskRepository;

  public StatTaskService(StatTaskRepository statTaskRepository) {
    _statTaskRepository = statTaskRepository;
  }

  public Optional<StatTask> getByUsername(String username) {
    return _statTaskRepository.findByUsername(username);
  }

  public void createForUsername(String username) {
    var task = new StatTask();
    task.setUsername(username);
    _statTaskRepository.save(task);
  }

  public List<StatTask> getAll() {
    return _statTaskRepository.findTop20ByOrderByCdate();
  }
}
