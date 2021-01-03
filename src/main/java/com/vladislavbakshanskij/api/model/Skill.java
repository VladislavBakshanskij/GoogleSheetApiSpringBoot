package com.vladislavbakshanskij.api.model;

import lombok.Builder;
import lombok.Data;
import com.vladislavbakshanskij.api.service.Column;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@Builder
@Scope("prototype")
public class Skill {
    /**
     * Skill id.
     */
    private int id;

    /**
     * Skill name.
     */
    private String name;

    /**
     * Level skill.
     */
    private String level;

    Skill() {
    }

    Skill(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    @NotNull
    public static Skill createSkillFromObjectList(@NotNull List<Object> row) {
        var id = Integer.parseInt(row.get(Column.A.getId()).toString().replace(" ", ""));
        var name = row.get(Column.B.getId()).toString().replace(" ", "");
        String level = null;

        if (row.size() > 2) {
            level = row.get(Column.C.getId()).toString();
        }

        return builder().
            id(id).
            level(level).
            name(name).
            build();
    }
}
