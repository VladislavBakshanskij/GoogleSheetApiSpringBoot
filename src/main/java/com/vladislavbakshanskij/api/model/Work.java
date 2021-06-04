package com.vladislavbakshanskij.api.model;

import com.vladislavbakshanskij.api.service.Column;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Builder
public class Work {
    /**
     * Id work.
     */
    private int id;

    /**
     * Organization name.
     */
    private String organization;

    /**
     * Position name.
     */
    private String position;

    /**
     * Date start working.
     */
    private String dateStart;

    /**
     * Date end working
     */
    private String dateEnd;

    /**
     * Responsibilities on work.
     */
    private String[] responsibilities;

    Work() {
    }

    Work(int id, String organization, String position, String dateStart, String dateEnd, String[] responsibilities) {
        this.id = id;
        this.organization = organization;
        this.position = position;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.responsibilities = responsibilities;
    }

    @NotNull
    public static Work createFromObjectList(@NotNull List<Object> row) {
        var id = Integer.parseInt(row.get(Column.A.getId()).toString());
        var organization = row.get(Column.B.getId()).toString();
        var position = row.get(Column.C.getId()).toString();
        var dateStart = row.get(Column.D.getId()).toString();
        var dateEnd = row.get(Column.E.getId()).toString();
        var responsibilities = row.get(Column.F.getId()).toString().split(",\\s");

        return builder()
                .id(id)
                .organization(organization)
                .position(position)
                .dateStart(dateStart)
                .dateEnd(dateEnd)
                .responsibilities(responsibilities)
                .build();
    }
}
