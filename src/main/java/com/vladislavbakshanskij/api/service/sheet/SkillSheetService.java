package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Skill;
import com.vladislavbakshanskij.api.service.Column;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class SkillSheetService extends AbstractSheetService<Skill> {
    public SkillSheetService() {
        super.converter = Skill::createSkillFromObjectList;
        super.startCol = Column.A.getName();
        super.endCol = Column.C.getName();
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "Skills";
    }

    @Override
    @NotNull
    public SheetType getSheetType() {
        return SheetType.SKILL;
    }
}
