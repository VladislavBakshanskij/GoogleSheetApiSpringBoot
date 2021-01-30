package com.vladislavbakshanskij.api.service.sheet;

import com.google.api.services.sheets.v4.Sheets;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.util.List;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class AbstractSheetService<T> implements SheetService {
    @Value("${google.sheet.id}")
    @Getter
    private String sheetId;

    @Autowired
    @Getter
    private Sheets sheets;

    protected String startCol;
    protected String endCol;
    protected Function<List<Object>, T> converter;

    @Override
    @NotNull
    public List<Object> getCountData(int count) throws IOException {
        var response = this.getValuesByRange(this.createRange(startCol, endCol));

        if (response == null || response.isEmpty()) {
            throw new IOException();
        }

        return this.collect(count + 1, response::get);
    }

    @Override
    @NotNull
    public Object getById(int id) throws IOException {
        var rowId = id + 1;
        var range = this.createRange(this.startCol + rowId, this.endCol + rowId);
        return converter.apply(this.getRowByRange(range));
    }

    @Override
    @NotNull
    public List<Object> getAll() throws IOException {
        var range = this.createRange(this.getSheetName(), this.startCol, this.endCol);
        var response = this.getValuesByRange(range);

        if (response == null || response.isEmpty()) {
            throw new IOException();
        }

        return this.collect(response.size(), response::get);
    }

    @Nullable
    protected List<List<Object>> getValuesByRange(@NotNull String range) throws IOException {
        return this.getSheets()
            .spreadsheets()
            .values()
            .get(this.getSheetId(), range)
            .execute()
            .getValues();
    }

    @NotNull
    protected List<Object> getRowByRange(@NotNull String range) throws IOException {
        var response = this.getValuesByRange(range);

        if (response == null || response.isEmpty()) {
            throw new IOException();
        }

        return response.get(0);
    }

    @NotNull
    protected List<Object> collect(int end, @NotNull IntFunction<List<Object>> function) {
        return IntStream.range(1, end)
            .mapToObj(function)
            .map(converter)
            .collect(Collectors.toList());
    }
}
