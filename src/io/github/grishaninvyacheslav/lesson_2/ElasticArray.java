package io.github.grishaninvyacheslav.lesson_2;

import static io.github.grishaninvyacheslav.utils.loopers.Range.*;

/**
 * Контейнер на основе массива в который
 * можно добалять производное колличество элементов и
 * из котрого можно удалять произвольный элемент
 * @param <E> - тип элемента контейнера
 */

public class ElasticArray<E> {
    /**
     * Начальный размер elementData по умолчанию
     */
    private static final int DEFAULT_CAPACITY = 10;
    /**
     * Буффер в котором хранятся элементы ElasticArray.
     */
    protected Object[] elementData;
    /**
     * Колличество элементов в ElasticArray
     */
    protected int size;
    /**
     * Значение на которое увеличивается вместительность ElasticArray (размер elementData)
     */
    private static final int GROWTH = 10;

    public ElasticArray(E... initialValues) {
        this(initialValues.length);
        System.arraycopy(initialValues, 0, elementData, 0, initialValues.length);
        size = initialValues.length;
    }

    public ElasticArray() {
        this(0);
    }

    public ElasticArray(int size) {
        if (size < DEFAULT_CAPACITY) {
            elementData = new Object[DEFAULT_CAPACITY];
        } else {
            elementData = new Object[size + GROWTH];
        }
        this.size = 0;
    }

    public E get(int index) {
        checkOutOfBounds(index);
        return (E) elementData[index];
    }

    public void add(E value) {
        add(value, size);
    }

    public void add(E value, int index) {
        checkOutOfBounds(index);
        if (size + 1 == elementData.length) {
            growCapacity();
        }
        for (int i : range(size, index)) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    public void removeByIndex(int index) {
        checkOutOfBounds(index);
        for (int i : range(index, size - 1)) {
            elementData[i] = elementData[i + 1];
        }
        elementData[size - 1] = null;
        size--;
        if (elementData.length - size > GROWTH * 2) {
            shrinkCapacity();
        }
    }

    public boolean removeByValue(E value) {
        for (int i : range(0, size)) {
            if (elementData[i] == value) {
                removeByIndex(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeByValues(E... values) {
        boolean isAtLeastOneValueRemoved = false;
        for (int i = 0; i < size; i++) {
            for (E value : values) {
                if (elementData[i] == value) {
                    removeByIndex(i);
                    isAtLeastOneValueRemoved = true;
                    i--;
                    break;
                }
            }
        }
        return isAtLeastOneValueRemoved;
    }

    public boolean clear() {
        if (size == 0) {
            return false;
        } else {
            elementData = new Object[DEFAULT_CAPACITY];
            size = 0;
            return true;
        }
    }

    /**
     * Метод growCapacity должен увеличевать вместительность ElasticArray как
     * минимум на один элемент - этот факт используется в
     * методе public void add(E value, int index)
     */
    protected void growCapacity() {
        Object[] newElementData = new Object[elementData.length + GROWTH];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    protected void shrinkCapacity() {
        Object[] newElementData = new Object[size + GROWTH];
        System.arraycopy(elementData, 0, newElementData, 0, size);
        elementData = newElementData;
    }

    @Override
    public String toString() {
        if (elementData == null) {
            return "null";
        }

        if (size == 0) {
            return "[]";
        }

        StringBuilder resultString = new StringBuilder();
        resultString.append('[');
        for (int i = 0; ; i++) {
            resultString.append(elementData[i]);
            if (i == size - 1)
                return resultString.append(']').toString();
            resultString.append(", ");
        }
    }

    private void checkOutOfBounds(int index) {
        if (index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException(String.format("Индекс %s выходит за грницы диапазона длинной в %s", index, size));
        }
    }
}
