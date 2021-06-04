package com.vladislavbakshanskij.api.model;

import com.vladislavbakshanskij.api.service.Column;
import lombok.Builder;
import lombok.Data;
import org.jetbrains.annotations.NotNull;

import java.util.List;

@Data
@Builder
public class SocialLink {
    /**
     * Link id.
     */
    private int id;

    /**
     * Ref.
     */
    private String link;

    /**
     * Social name.
     */
    private String name;

    SocialLink() {
    }

    SocialLink(int id, String link, String name) {
        this.id = id;
        this.link = link;
        this.name = name;
    }

    @NotNull
    public static SocialLink createSocialLinkFromObjectList(@NotNull List<Object> row) {
        var id = Integer.parseInt(row.get(Column.A.getId()).toString());
        var link = row.get(Column.B.getId()).toString();
        var name = row.get(Column.C.getId()).toString();

        return builder()
                .id(id)
                .link(link)
                .name(name)
                .build();
    }
}
