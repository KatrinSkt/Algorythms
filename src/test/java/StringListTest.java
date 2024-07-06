import Exceptions.incorrectIndexException;
import Lists.StringList;
import Lists.StringListImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class StringListTest {
    private final StringListImpl stringList = new StringListImpl();

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

    // Добавление элемента
    // на определенную позицию списка.
    // Если выходит за пределы фактического
    // количества элементов или массива,
    // выбросить исключение.
    // Вернуть добавленный элемент
    // в качестве результата выполнения.
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


    // Установить элемент
    // на определенную позицию,
    // затерев существующий.
    // Выбросить исключение,
    // если индекс больше
    // фактического количества элементов
    // или выходит за пределы массива.
    @Test
    String set(int index, String item) {
        return null;
    }

    // Удаление элемента.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    String remove(String item) {
        return null;
    }

    // Удаление элемента по индексу.
    // Вернуть удаленный элемент
    // или исключение, если подобный
    // элемент отсутствует в списке.
    @Test
    String remove(int index) {
        return null;
    }

    // Проверка на существование элемента.
    // Вернуть true/false;
    boolean contains(String item) {
        return false;
    }

    // Поиск элемента.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int indexOf(String item) {
        return 0;
    }

    // Поиск элемента с конца.
    // Вернуть индекс элемента
    // или -1 в случае отсутствия.
    int lastIndexOf(String item) {
        return 0;
    }

    // Получить элемент по индексу.
    // Вернуть элемент или исключение,
    // если выходит за рамки фактического
    // количества элементов.
    String get(int index) {
        return null;
    }

    // Сравнить текущий список с другим.
    // Вернуть true/false или исключение,
    // если передан null.
    boolean equals(StringList otherList) {
        return false;
    }

    // Вернуть фактическое количество элементов.
    int size() {
        return 0;
    }

    // Вернуть true,
    // если элементов в списке нет,
    // иначе false.
    boolean isEmpty() {
        return false;
    }

    // Удалить все элементы из списка.
    void clear() {

    }

    // Создать новый массив
    // из строк в списке
    // и вернуть его.
    String[] toArray() {
        return new String[0];
    }

}

