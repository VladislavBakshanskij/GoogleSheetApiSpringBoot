package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Skill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.vladislavbakshanskij.api.service.SheetType.SKILL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class SkillSheetServiceTest {
    @Autowired
    private SkillSheetService skillSheetService;

    @Test
    public void getByCount() throws IOException {
        var skills = this.skillSheetService.getCountData(2);
        assertEquals(skills.size(), 2);
    }

    @Test
    public void getById() throws IOException {
        var skill = (Skill) this.skillSheetService.getById(3);
        assertEquals(skill.getId(), 3);
    }

    @Test
    public void getAll() throws IOException {
        var allSkills = this.skillSheetService.getAll();
        assertTrue(allSkills.size() > 5);
    }

    @Test
    public void getSheetName() {
        assertEquals(this.skillSheetService.getSheetName(), "Skills");
    }

    @Test
    public void getCodeName() {
        assertEquals(this.skillSheetService.getSheetType(), SKILL);
    }
}