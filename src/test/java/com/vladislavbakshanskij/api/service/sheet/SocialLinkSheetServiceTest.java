package com.vladislavbakshanskij.api.service.sheet;

import com.vladislavbakshanskij.api.model.SocialLink;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static com.vladislavbakshanskij.api.service.SheetType.SOCIAL_LINK;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("/application-test.properties")
public class SocialLinkSheetServiceTest {
    @Autowired
    private SocialLinkSheetService socialLinkSheetService;

    @Test
    public void getByCount() throws IOException {
        var socialLinks = this.socialLinkSheetService.getCountData(2);
        assertEquals(socialLinks.size(), 2);
    }

    @Test
    public void getById() throws IOException {
        var socialLink = (SocialLink) this.socialLinkSheetService.getById(2);
        assertEquals(socialLink.getId(), 2);
    }

    @Test
    public void getAll() throws IOException {
        var allSocialLinks = this.socialLinkSheetService.getAll();
        assertTrue(allSocialLinks.size() > 5);
    }

    @Test
    public void getSheetName() {
        assertEquals(this.socialLinkSheetService.getSheetName(), "SocialLinks");
    }

    @Test
    public void getCodeName() {
        assertEquals(this.socialLinkSheetService.getSheetType(), SOCIAL_LINK);
    }
}