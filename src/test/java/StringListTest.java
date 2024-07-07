import Exceptions.incorrectIndexException;
import Lists.StringList;
import Lists.StringListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringListTest {
    private final StringList stringList = new StringListImpl();

    @BeforeEach
    public void beforeEach() {
        stringList.add(0, "item1");
        stringList.add(1, "item2");
        stringList.add(2, "item3");
    }

    @AfterEach
    public void afterEach() {
        stringList.clear();
    }

    @Test
    public void addTest() {
        String actual = stringList.add("item4");
        StringListImpl expected = new StringListImpl(4);
        assertThat(actual).isEqualTo(expected);
        assertThat(stringList.contains("item4")).isEqualTo("item4");
    }

    @Test
    public void addTest(int index, String item) {
        String actual = stringList.add(3, "item4");
        StringListImpl expected = new StringListImpl(4);
        assertThat(actual).isEqualTo(expected);
        assertThat(actual).contains("item4");
    }

    @Test
    public void addNegativeTest(int index, String item) {
        stringList.add(3, "item4");
        assertThatExceptionOfType(incorrectIndexException.class)
                .isThrownBy(() -> stringList.add(3, "item 4"));
    }

    @Test
    String set(int index, String item) {
        return null;
    }

    String remove(String item) {
        return null;
    }

    @Test
    String remove(int index) {
        return null;
    }

    boolean contains(String item) {
        return false;
    }

    int indexOf(String item) {
        return 0;
    }

    int lastIndexOf(String item) {
        return 0;
    }

    String get(int index) {
        return null;
    }

    boolean equals(StringList otherList) {
        return false;
    }

    int size() {
        return 0;
    }

    boolean isEmpty() {
        return false;
    }

    void clear() {

    }

    String[] toArray() {
        return new String[0];
    }

}

