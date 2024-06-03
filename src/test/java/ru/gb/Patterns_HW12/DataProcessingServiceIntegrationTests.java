package ru.gb.Patterns_HW12;

import ru.gb.Patterns_HW12.model.Task;
import ru.gb.Patterns_HW12.model.TaskStatus;
import ru.gb.Patterns_HW12.services.DataProcessingService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class DataProcessingServiceIntegrationTests {
    @Autowired
    private DataProcessingService dataService;

    @Test
    @Transactional
    public void updateTaskStatusWithIdNotFoundTest() {
        long id = 1L;
        TaskStatus status = TaskStatus.IN_PROGRESS;
        Task task = new Task();
        task.setId(2L);
        task.setStatus(TaskStatus.NOT_STARTED);

        assertThrows(EntityNotFoundException.class,() -> dataService.updateTaskStatusWithId(id, status));
    }
}
