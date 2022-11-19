package ru.netology.oop.and.design;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class RadioTest {

    @Test
    public void shouldSetRadio() { // проверка значения в пределах диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(3);

        int expected = 3;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetMaxRadio() { // проверка значения больше диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(15);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetMinRadio() { // проверка значения меньше диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-5);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetMaxRadio() { // проверка граничных значения на верхней границе диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(9);

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldNotSetRadioMax() { // проверка граничных значений за верхней границей диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(10);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldSetMinRadio() { // проверка граничных значения на нижней границе диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(0);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void souidNotSetRadioMin() { //проверка граничных значений за нижней границей диапазона
        Radio radio = new Radio();

        radio.setCurrentRadioStationNumber(-1);

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioNumberChangeUp() { // Проверка метода NEXT изменение раиостанции на 1 вверх (в границах диапазона)
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(6);

        radio.next();

        int expected = 7;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioNumberChangeUpAbroad() { // Проверка метода NEXT изменение раиостанции на 1 вверх за границу диапазона
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(9);

        radio.next();

        int expected = 0;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioNumberChangeDown() { // Проверка метода PREV изменение раиостанции на 1 вниз (в границах диапазона)
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(4);

        radio.prev();

        int expected = 3;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void radioNumberChangeDownAbroad() {// Проверка метода PREV изменение раиостанции на 1 вниз за границу диапазона
        Radio radio = new Radio();
        radio.setCurrentRadioStationNumber(0);

        radio.prev();

        int expected = 9;
        int actual = radio.getCurrentRadioStationNumber();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheck() { // проверка значения уровня громкости в пределах диапазона
        Radio radio = new Radio();
        radio.setSoundVolume(7);

        int expected = 7;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckMin() { // проверка значения уровня громкости в пределах диапазона нижняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(0);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckNotMin() { // проверка значения уровня громкости за пределами диапазона нижняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(-1);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckMinMin() { // проверка значения уровня громкости за пределами диапазона нижняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(-4);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckMax() { // проверка значения уровня громкости в пределах диапазона вверхняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(10);

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckNotMax() { // проверка граничного значения уровня громкости за пределами диапазона вверхняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(11);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void volumeVolumeCheckMaxMax() { // проверка значения уровня громкости за пределами диапазона вверхняя граница
        Radio radio = new Radio();
        radio.setSoundVolume(16);

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentVolumeMin() { // увеличение громкости на 1 при уровне громкости = 0
        Radio radio = new Radio();
        radio.setSoundVolume(0);

        radio.increaseVolume();

        int expected = 1;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentVolume() { // увеличение громкости на 1 при уровне громкости внутри диапазона
        Radio radio = new Radio();
        radio.setSoundVolume(6);

        radio.increaseVolume();

        int expected = 7;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax() { // увеличение громкости на 1 при уровне громкости = 9 (граничное значениие)
        Radio radio = new Radio();
        radio.setSoundVolume(9);

        radio.increaseVolume();

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax10() { // увеличение громкости на 1 при уровне громкости = 10 (граничное значениие)
        Radio radio = new Radio();
        radio.setSoundVolume(10);

        radio.increaseVolume();

        int expected = 10;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceCurrentVolumeMin() { // уменьшение громкости на 1 при уровне громкости = 0
        Radio radio = new Radio();
        radio.setSoundVolume(0);

        radio.turnDownVolume();

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceCurrentVolumeMax() { // уменьшение громкости на 1 при уровне громкости = 1 (граничное значениие)
        Radio radio = new Radio();
        radio.setSoundVolume(1);

        radio.turnDownVolume();

        int expected = 0;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceCurrentVolume() { // уменьшение громкости на 1 при уровне громкости внутри диапазона
        Radio radio = new Radio();
        radio.setSoundVolume(6);

        radio.turnDownVolume();

        int expected = 5;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReduceCurrentVolumeMax10() { // уменьшение громкости на 1 при уровне громкости = 10 (граничное значениие)
        Radio radio = new Radio();
        radio.setSoundVolume(10);

        radio.turnDownVolume();

        int expected = 9;
        int actual = radio.getSoundVolume();

        Assertions.assertEquals(expected, actual);
    }
}