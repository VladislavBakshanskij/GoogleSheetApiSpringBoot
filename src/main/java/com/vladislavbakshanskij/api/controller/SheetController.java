package com.vladislavbakshanskij.api.controller;

import com.vladislavbakshanskij.api.service.SheetType;
import com.vladislavbakshanskij.api.service.sheet.SheetService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SheetController {
    private final Map<String, SheetService> services = new HashMap<>();

    public SheetController(List<SheetService> services) {
        services.forEach(service -> this.services.put(service.getSheetType().getCodeName(), service));
    }

    @GetMapping
    @CrossOrigin(origins = "*")
    @NotNull
    public String index() {
        return "{\"isWork\":" + true + "}";
    }

    @NotNull
    private SheetService getSheetServiceByCodeName(@NotNull String codeName) {
        var sheetService = this.services.get(codeName);
        if (sheetService != null) {
            return sheetService;
        }

        return this.services.get(SheetType.UNKNOWN.getCodeName());
    }

    @GetMapping(value = "/all/{type}")
    @CrossOrigin(origins = "*")
    @NotNull
    public List<Object> getAllByType(@NotNull @PathVariable String type) throws IOException {
        return this.getSheetServiceByCodeName(type).getAll();
    }

    @GetMapping("{type}")
    @CrossOrigin(origins = "*")
    @NotNull
    public List<Object> getByTypeAndCount(@NotNull @PathVariable String type, @RequestParam int count) throws IOException {
        return this.getSheetServiceByCodeName(type).getCountData(count);
    }

    @GetMapping("/{type}/{id}")
    @CrossOrigin(origins = "*")
    @NotNull
    public Object getByTypeAndId(@NotNull @PathVariable String type, @PathVariable int id) throws IOException {
        return this.getSheetServiceByCodeName(type).getById(id);
    }
}
