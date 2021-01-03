package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Work;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class WorkSheetService extends AbstractSheetService<Work> {
    public WorkSheetService() {
        super.converter = Work::createFromObjectList;
        super.startCol = "A";
        super.endCol = "F";
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "Works";
    }

    @Override
    @NotNull
    public SheetType getCodeName() {
        return SheetType.WORK;
    }
}
