package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface SheetService {
    @NotNull
    List<Object> getAll() throws IOException;

    @NotNull
    List<Object> getCountData(int count) throws IOException;

    @NotNull
    Object getById(int id) throws IOException;

    @NotNull
    String getSheetName();

    @NotNull
    SheetType getSheetType();

    @NotNull
    default String createRange(@NotNull String sheetName, @NotNull String startCol, @NotNull String endCol) {
        return sheetName + "!" + startCol + ":" + endCol;
    }

    @NotNull
    default String createRange(@NotNull String startCol, @NotNull String endCol) {
        return this.createRange(this.getSheetName(), startCol, endCol);
    }
}
