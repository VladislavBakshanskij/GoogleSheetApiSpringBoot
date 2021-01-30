package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Project;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.vladislavbakshanskij.api.service.SheetType.PROJECT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class ProjectSheetServiceTest {
    @Autowired
    private ProjectSheetService projectSheetService;

    @Test
    public void getByCount() throws IOException {
        var projects = this.projectSheetService.getCountData(2);
        assertEquals(projects.size(), 2);
    }

    @Test
    public void getById() throws IOException {
        var project = (Project) this.projectSheetService.getById(2);
        assertEquals(project.getId(), 2);
    }

    @Test
    public void getAll() throws IOException {
        var allProjects = this.projectSheetService.getAll();
        assertTrue(allProjects.size() > 5);
    }

    @Test
    public void getSheetName() {
        assertEquals(this.projectSheetService.getSheetName(), "Projects");
    }

    @Test
    public void getCodeName() {
        assertEquals(this.projectSheetService.getSheetType(), PROJECT);
    }
}