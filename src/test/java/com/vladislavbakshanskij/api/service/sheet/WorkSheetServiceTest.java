package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Work;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.vladislavbakshanskij.api.service.SheetType.WORK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class WorkSheetServiceTest {
    @Autowired
    private WorkSheetService workSheetService;

    @Test
    public void getByCount() throws IOException {
        var works = this.workSheetService.getCountData(2);
        assertEquals(works.size(), 2);
    }

    @Test
    public void getById() throws IOException {
        var work = (Work) this.workSheetService.getById(2);
        assertEquals(work.getId(), 2);
    }

    @Test
    public void getAll() throws IOException {
        var allWorks = this.workSheetService.getAll();
        assertTrue(allWorks.size() > 3);
    }

    @Test
    public void getSheetName() {
        assertEquals(this.workSheetService.getSheetName(), "Works");
    }

    @Test
    public void getCodeName() {
        assertEquals(this.workSheetService.getSheetType(), WORK);
    }
}