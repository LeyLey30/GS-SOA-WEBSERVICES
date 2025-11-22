package com.conciliar.backend.service;

import com.conciliar.backend.dto.TaskDto;
import com.conciliar.backend.domain.TaskItem;
import com.conciliar.backend.domain.TaskStatus;
import com.conciliar.backend.domain.PriorityLevel;
import com.conciliar.backend.repository.TaskRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) { this.repo = repo; }

    public List<TaskDto> findAll() {
        return repo.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    public TaskDto findById(Long id) {
        return repo.findById(id).map(this::toDto).orElse(null);
    }

    public TaskDto create(TaskDto dto) {
        TaskItem e = new TaskItem();
        e.setTitle(dto.getTitle());
        e.setDescription(dto.getDescription());
        e.setStatus(TaskStatus.valueOf(dto.getStatus()));
        e.setPriority(PriorityLevel.valueOf(dto.getPriority()));
        e.setDueDate(dto.getDueDate());
        e.setOwnerEmail(dto.getOwnerEmail());
        e.setOwnerPhone(dto.getOwnerPhone());
        var saved = repo.save(e);
        return toDto(saved);
    }

    public TaskDto update(Long id, TaskDto dto) {
        return repo.findById(id).map(e -> {
            e.setTitle(dto.getTitle());
            e.setDescription(dto.getDescription());
            e.setStatus(TaskStatus.valueOf(dto.getStatus()));
            e.setPriority(PriorityLevel.valueOf(dto.getPriority()));
            e.setDueDate(dto.getDueDate());
            e.setOwnerEmail(dto.getOwnerEmail());
            e.setOwnerPhone(dto.getOwnerPhone());
            return toDto(repo.save(e));
        }).orElse(null);
    }

    public boolean delete(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }

    private TaskDto toDto(TaskItem e) {
        TaskDto d = new TaskDto();
        d.setId(e.getId());
        d.setTitle(e.getTitle());
        d.setDescription(e.getDescription());
        d.setStatus(e.getStatus().name());
        d.setPriority(e.getPriority().name());
        d.setDueDate(e.getDueDate());
        d.setOwnerEmail(e.getOwnerEmail());
        d.setOwnerPhone(e.getOwnerPhone());
        return d;
    }
}
