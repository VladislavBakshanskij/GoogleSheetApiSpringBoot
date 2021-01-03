package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.SocialLink;
import com.vladislavbakshanskij.api.service.SheetType;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class SocialLinkSheetService extends AbstractSheetService<SocialLink> {
    public SocialLinkSheetService() {
        super.converter = SocialLink::createSocialLinkFromObjectList;
        super.startCol = "A";
        super.endCol = "C";
    }

    @Override
    @NotNull
    public String getSheetName() {
        return "SocialLinks";
    }

    @Override
    @NotNull
    public SheetType getCodeName() {
        return SheetType.SOCIAL_LINK;
    }
}
