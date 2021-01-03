package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class UnknownSheetService implements SheetService {
    private static final String EMPTY = "";

    @Override
    @NotNull
    public List<Object> getAll() throws IOException {
        return new ArrayList<>() {{
            add(false);
            add("this is type not supported");
        }};
    }

    @Override
    @NotNull
    public List<Object> getByCount(int count) throws IOException {
        return getAll();
    }

    @Override
    @NotNull
    public Object getById(int id) throws IOException {
        return new HashMap<>() {{
            put("status", false);
            put("message", "this is type not supported");
        }};
    }

    @Override
    @NotNull
    public String getSheetName() {
        return EMPTY;
    }

    @Override
    @NotNull
    public SheetType getCodeName() {
        return SheetType.UNKNOWN;
    }

    @Override
    @NotNull
    public String createRange(@NotNull String sheetName, @NotNull String startCol, @NotNull String endCol) {
        return EMPTY;
    }

    @Override
    @NotNull
    public String createRange(@NotNull String startCol, @NotNull String endCol) {
        return EMPTY;
    }
}
