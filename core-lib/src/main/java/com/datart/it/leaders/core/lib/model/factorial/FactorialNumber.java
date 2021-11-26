package com.datart.it.leaders.core.lib.model.factorial;

import java.util.LinkedList;
import java.util.Objects;

public class FactorialNumber {
        final LinkedList<Integer> inNumber;

    public FactorialNumber (LinkedList<Integer> inNumber) {
        //является числом в фк системе
        this.inNumber = inNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FactorialNumber that = (FactorialNumber) o;
        return Objects.equals(inNumber, that.inNumber);
    }
// equals сравнение значений с другим числом
    //инкремент дикремент,
// сложение сложение с другим числом столбиком
// вычитание вычитание с другим числом
    //
    public int getSize() {
        return inNumber.size();
    }
}
