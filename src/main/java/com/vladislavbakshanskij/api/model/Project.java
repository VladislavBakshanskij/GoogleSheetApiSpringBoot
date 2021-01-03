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
public class Project {
    /**
     * Project id.
     */
    private int id;

    /**
     * Small description.
     */
    private String title;

    /**
     * Ref on project.
     */
    private String ref;

    /**
     * Tech using in project.
     */
    private String[] tech;

    /**
     * Project name.
     */
    private String name;

    Project() {
    }

    Project(int id, String title, String ref, String[] tech, String name) {
        this.id = id;
        this.title = title;
        this.ref = ref;
        this.tech = tech;
        this.name = name;
    }

    @NotNull
    public static Project createProjectFromObjectList(@NotNull List<Object> row) {
        var id = Integer.parseInt(row.get(Column.A.getId()).toString());
        var title = row.get(Column.B.getId()).toString();
        var ref = row.get(Column.C.getId()).toString();
        var tech = row.get(Column.D.getId()).toString().split(",\\s");
        var name = row.get(Column.E.getId()).toString();

        return builder().
            id(id).
            title(title).
            ref(ref).
            tech(tech).
            name(name).build();
    }
}
