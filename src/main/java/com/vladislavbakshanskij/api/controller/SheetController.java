package com.vladislavbakshanskij.api.controller;

import com.vladislavbakshanskij.api.service.sheet.SheetService;
import com.vladislavbakshanskij.api.service.sheet.UnknownSheetService;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class SheetController {
    private final Map<String, SheetService> services = new HashMap<>();

    public SheetController(List<SheetService> services) {
        services.forEach(service -> this.services.put(service.getCodeName().getCode(), service));
    }

    @GetMapping
    @NotNull
    public String index(@NotNull HttpServletResponse httpServletResponse) {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return "{\"isWork\":" + true + "}";
    }

    @NotNull
    private SheetService get(@NotNull String beanClassName) {
        return this.services.getOrDefault(beanClassName, new UnknownSheetService());
    }

    @GetMapping(value = "/all/{type}")
    @NotNull
    public List<Object> getAllByType(
        @NotNull @PathVariable String type,
        @NotNull HttpServletResponse httpServletResponse
    ) throws IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return this.get(type).getAll();
    }

    @GetMapping("{type}")
    @NotNull
    public List<Object> getByTypeAndCount(
        @NotNull @PathVariable String type,
        @RequestParam int count,
        @NotNull HttpServletResponse httpServletResponse
    ) throws IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return this.get(type).getByCount(count);
    }

    @GetMapping("/{type}/{id}")
    @NotNull
    public Object getByTypeAndId(
        @NotNull @PathVariable String type,
        @PathVariable int id,
        @NotNull HttpServletResponse httpServletResponse
    ) throws IOException {
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        return this.get(type).getById(id);
    }
}
