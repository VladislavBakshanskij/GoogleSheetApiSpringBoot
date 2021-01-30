package com.vladislavbakshanskij.api.service;

import lombok.Getter;
import org.jetbrains.annotations.NotNull;

public enum SheetType {
    PROJECT("project"),
    SKILL("skill"),
    SOCIAL_LINK("socialLink"),
    WORK("work"),
    UNKNOWN("unknown")
    ;

    @Getter
    private final String codeName;

    SheetType(@NotNull String codeName) {
        this.codeName = codeName;
    }

    @NotNull
    public static SheetType getSheetTypeByCodeName(@NotNull String codeName) {
        for (SheetType value : values()) {
            if (codeName.equalsIgnoreCase(value.getCodeName())) {
                return value;
            }
        }

        return UNKNOWN;
    }
}
