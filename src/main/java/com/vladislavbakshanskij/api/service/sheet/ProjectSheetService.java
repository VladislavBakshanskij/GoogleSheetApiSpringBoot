package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Project;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class ProjectSheetService extends AbstractSheetService<Project> {
    public ProjectSheetService() {
        super.converter = Project::createProjectFromObjectList;
        super.startCol = "A";
        super.endCol = "E";
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "Projects";
    }

    @Override
    @NotNull
    public SheetType getCodeName() {
        return SheetType.PROJECT;
    }
}
