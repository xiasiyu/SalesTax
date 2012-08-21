package PurchasedItem;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MusicCdItemTest {
    @Test
    public void should_get_tax_for_non_imported_music_cd() {
        MusicCdItem musicCdItem = new MusicCdItem("music CD", 14.99, 1);

        String sss = musicCdItem.toPrintString();

        assertThat(sss, is("1 music CD: 16.49"));
    }
}
