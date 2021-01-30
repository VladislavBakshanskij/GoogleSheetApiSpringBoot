package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.Work;
import com.vladislavbakshanskij.api.service.Column;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class WorkSheetService extends AbstractSheetService<Work> {
    public WorkSheetService() {
        super.converter = Work::createFromObjectList;
        super.startCol = Column.A.getName();
        super.endCol = Column.F.getName();
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "Works";
    }

    @Override
    @NotNull
    public SheetType getSheetType() {
        return SheetType.WORK;
    }
}
