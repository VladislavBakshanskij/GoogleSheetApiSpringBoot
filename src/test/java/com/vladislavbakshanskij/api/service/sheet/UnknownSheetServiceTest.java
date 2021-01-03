package com.vladislavbakshanskij.api.service.sheet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UnknownSheetServiceTest {
    @Autowired
    private UnknownSheetService unknownSheetService;

    @Test
    public void getAll() throws IOException {
        assertThat(this.unknownSheetService.getAll())
            .contains(false, "this is type not supported");
    }

    @Test
    public void getByCount() throws IOException {
        assertThat(this.unknownSheetService.getByCount(2))
            .contains(false, "this is type not supported");
    }

    @Test
    public void getById() throws IOException {
        var obj = (Map<String, Object>) this.unknownSheetService.getById(2);

        assertThat(obj)
            .containsEntry("status", false)
            .containsEntry("message", "this is type not supported");
    }

    @Test
    public void getSheetName() throws IOException {
        assertEquals(this.unknownSheetService.getSheetName(), "");
    }

    @Test
    public void getCodeName() throws IOException {
        assertEquals(this.unknownSheetService.getSheetName(), "");
    }
}