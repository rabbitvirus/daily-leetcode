package problem966;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


public class VowelSpellcheckerTest {

    private VowelSpellchecker solution = new VowelSpellchecker();

    @Test
    public void shouldPerformSpellCheck() {
        final String[] words = new String[]{"KiTe", "kite", "hare", "Hare"};

        final String[] queries = new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"};

        final String[] output = solution.spellchecker(words, queries);

        assertThat(output, is(new String[]{"kite", "KiTe", "KiTe", "Hare", "hare", "", "", "KiTe", "", "KiTe"}));
    }

}
