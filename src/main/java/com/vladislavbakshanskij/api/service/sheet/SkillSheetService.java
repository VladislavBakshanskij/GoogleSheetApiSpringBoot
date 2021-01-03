package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Skill;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class SkillSheetService extends AbstractSheetService<Skill> {
    public SkillSheetService() {
        super.converter = Skill::createSkillFromObjectList;
        super.startCol = "A";
        super.endCol = "C";
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "Skills";
    }

    @Override
    @NotNull
    public SheetType getCodeName() {
        return SheetType.SKILL;
    }
}
