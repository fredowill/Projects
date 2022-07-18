import static org.junit.Assert.assertEquals;

import org.junit.Test;

import components.map.Map;
import components.map.Map1L;
import components.set.Set;
import components.set.Set1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;

/**
 * @author Ephratah Meskel
 *
 */
public class GlossaryIndexTest {

    @Test
    public void getWordsAndDefinitions_spacedOut_testFile() {
        SimpleReader textInput = new SimpleReader1L("test/testfile.txt");
        Map<String, String> map = new Map1L<String, String>();
        GlossaryIndex.getWordsAndDefinitions(textInput, map);

        Map<String, String> mapExpected = new Map1L<String, String>();
        mapExpected.add("OSU", "ohio state university");
        mapExpected.add("TTUN", "the team up north");
        assertEquals(map, mapExpected);
    }

    @Test
    public void getWordsAndDefinitions_blankDef_testfile1() {
        SimpleReader textInput = new SimpleReader1L("test/testfile1.txt");
        Map<String, String> map = new Map1L<String, String>();
        GlossaryIndex.getWordsAndDefinitions(textInput, map);
        Map<String, String> mapExpected = new Map1L<String, String>();
        mapExpected.add("abcd", " ");
        mapExpected.add("efgh", " ");
        assertEquals(map, mapExpected);
    }

    @Test
    public void generateElements_withSep() {

        final String separatorStr = " \t,";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);
        Set<Character> expected = new Set1L<>();
        expected.add(' ');
        expected.add('\t');
        expected.add(',');
        System.out.print(expected);
        System.out.print(separatorSet);
        assertEquals(separatorSet, expected);
    }

    @Test
    public void generateElements_routineCase() {

        final String separatorStr = "abcdef";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);
        Set<Character> expected = new Set1L<>();
        expected.add('a');
        expected.add('b');
        expected.add('c');
        expected.add('d');
        expected.add('e');
        expected.add('f');
        assertEquals(separatorSet, expected);
    }

    @Test
    public void generateElements_multipleSameChar() {

        final String separatorStr = ",,,,,,,,";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);
        Set<Character> expected = new Set1L<>();
        expected.add(',');
        assertEquals(separatorSet, expected);
    }

    @Test
    public void nextWordOrSeparator_word() {

        final String separatorStr = " \t,";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);

        String test = "wordwordword space wordwordword";
        String str = GlossaryIndex.nextWordOrSeparator(test, 0, separatorSet);
        assertEquals(str, "wordwordword");

    }

    @Test
    public void nextWordOrSeparator_separator() {

        final String separatorStr = " \t,";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);

        String test = " space wordwordword";
        String str = GlossaryIndex.nextWordOrSeparator(test, 0, separatorSet);
        assertEquals(str, " ");

    }

    @Test
    public void nextWordOrSeparator_differentPosition() {

        final String separatorStr = " \t,";
        Set<Character> separatorSet = new Set1L<>();
        GlossaryIndex.generateElements(separatorStr, separatorSet);

        String test = "mid dle";
        final int three = 3;
        String str = GlossaryIndex.nextWordOrSeparator(test, three,
                separatorSet);
        assertEquals(str, " ");

    }

}
