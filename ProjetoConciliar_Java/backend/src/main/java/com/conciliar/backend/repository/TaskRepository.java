package com.conciliar.backend.repository;

import com.conciliar.backend.domain.TaskItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<TaskItem, Long> { }
