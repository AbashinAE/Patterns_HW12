package ru.gb.Patterns_HW12;

import ru.gb.Patterns_HW12.model.Task;
import ru.gb.Patterns_HW12.model.TaskStatus;
import ru.gb.Patterns_HW12.repositories.TaskRepository;
import ru.gb.Patterns_HW12.services.DataProcessingService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class DataProcessingServiceModuleTests {
    @InjectMocks
    private DataProcessingService dataService;
    @Mock
    private TaskRepository taskRepository;

    @Test
    public void updateTaskStatusWithIdSuccessTest() {
        long id = 1L;
        TaskStatus status = TaskStatus.IN_PROGRESS;
        Task task = new Task();
        task.setId(id);
        task.setStatus(TaskStatus.NOT_STARTED);

        given(taskRepository.getReferenceById(id)).willReturn(task);
        given(taskRepository.saveAndFlush(task)).willReturn(task);

        dataService.updateTaskStatusWithId(id, status);

        assertEquals(dataService.updateTaskStatusWithId(id, status).getStatus(), status);
    }
}