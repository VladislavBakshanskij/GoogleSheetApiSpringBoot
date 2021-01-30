package com.vladislavbakshanskij.api.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public enum Column {
    A(0, "A"),
    B(1, "B"),
    C(2, "C"),
    D(3, "D"),
    E(4, "E"),
    F(5, "F");
    /**
     * Index column in array.
     */
    @Getter
    private final int id;

    /**
     * Name col.
     */
    @Getter
    private final String name;

    /**
     * @param id - Index column in array.
     * @param name - col name.
     */
    Column(int id, @NotNull String name) {
        this.id = id;
        this.name = name;
    }
}
