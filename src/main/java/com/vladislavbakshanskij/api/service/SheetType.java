package com.vladislavbakshanskij.api.service;

import org.jetbrains.annotations.NotNull;

public enum SheetType {
    PROJECT("project"),
    SKILL("skill"),
    SOCIAL_LINK("socialLink"),
    WORK("work"),
    UNKNOWN("unknown")
    ;
    private final String code;

    SheetType(@NotNull String code) {
        this.code = code;
    }

    @NotNull
    public String getCode() {
        return this.code;
    }

    @NotNull
    public static SheetType getSheetTypeByCode(@NotNull String code) {
        for (SheetType value : values()) {
            if (code.equalsIgnoreCase(value.getCode())) {
                return value;
            }
        }

        return UNKNOWN;
    }
}
