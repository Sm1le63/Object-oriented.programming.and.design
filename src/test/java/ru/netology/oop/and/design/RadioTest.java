package ru.netology.oop.and.design;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RadioTest {
    Radio radio = new Radio();

    @Test
    public void shouldDefaultSettings() {     //Проверка значений по умолчанию

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
        Assertions.assertEquals(0, radio.getSoundVolume());
        Assertions.assertEquals(10, radio.getNumberOfStations());
        Assertions.assertEquals(0, radio.getMinSoundVolume());
        Assertions.assertEquals(100, radio.getMaxSoundVolume());
    }


    @Test
    public void shouldSetNumberOfStationsIf10() {  // Проверка установки количества радиостанций
        radio.setNumberOfStations(25);

        Assertions.assertEquals(25, radio.getNumberOfStations());
    }


    @Test
    public void shouldSetNumberOfStations() {    // Проверка номера станции (в пределах диапазона)
        radio.setNumberOfStations(5);

        Assertions.assertEquals(5, radio.getNumberOfStations());
    }

    @Test
    public void shouldSetRadio() { // проверка значения в пределах диапазона
        radio.setCurrentRadioStationNumber(3);

        Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetMaxRadio() { // проверка значения больше диапазона
        radio.setCurrentRadioStationNumber(15);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetMinRadio() { // проверка значения меньше диапазона
        radio.setCurrentRadioStationNumber(-5);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMaxRadio() { // проверка граничных значений на верхней границе диапазона
        radio.setCurrentRadioStationNumber(9);

        Assertions.assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetRadioMax() { // проверка граничных значений за верхней границей диапазона
        radio.setCurrentRadioStationNumber(10);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldSetMinRadio() { // проверка граничных значения на нижней границе диапазона
        radio.setCurrentRadioStationNumber(0);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void shouldNotSetRadioMin() { //проверка граничных значений за нижней границей диапазона
        radio.setCurrentRadioStationNumber(-1);

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUp() { // Проверка метода NEXT изменение радиостанции на 1 вверх (в границах диапазона)
        radio.setCurrentRadioStationNumber(6);
        radio.next();

        Assertions.assertEquals(7, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeUpAbroad() { // Проверка метода NEXT изменение радиостанции на 1 вверх за границу диапазона
        radio.setCurrentRadioStationNumber(9);
        radio.next();

        Assertions.assertEquals(0, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDown() { // Проверка метода PREV изменение радиостанции на 1 вниз (в границах диапазона)
        radio.setCurrentRadioStationNumber(4);
        radio.prev();

        Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void radioNumberChangeDownAbroad() {// Проверка метода PREV изменение радиостанции на 1 вниз за границу диапазона
        radio.setCurrentRadioStationNumber(0);
        radio.prev();

        Assertions.assertEquals(9, radio.getCurrentRadioStationNumber());
    }

    @Test
    public void volumeVolumeCheck() { // проверка значения уровня громкости в пределах диапазона
        radio.setSoundVolume(7);

        Assertions.assertEquals(7, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMin() { // проверка значения уровня громкости в пределах диапазона нижняя граница
        radio.setSoundVolume(0);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckNotMin() { // проверка значения уровня громкости за пределами диапазона нижняя граница
        radio.setSoundVolume(-1000);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMinMin() { // проверка значения уровня громкости за пределами диапазона нижняя граница
        radio.setSoundVolume(-4000);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMax() { // проверка значения уровня громкости в пределах диапазона вверхняя граница
        radio.setSoundVolume(100);

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckNotMax() { // проверка граничного значения уровня громкости за пределами диапазона нижняя граница
        radio.setSoundVolume(-1);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void volumeVolumeCheckMaxMax() { // проверка значения уровня громкости за пределами диапазона вверхняя граница
        radio.setSoundVolume(101);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMin() { // увеличение громкости на 1 при уровне громкости = 0
        radio.setSoundVolume(0);
        radio.increaseVolume();

        Assertions.assertEquals(1, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolume() { // увеличение громкости на 1 при уровне громкости внутри диапазона
        radio.setSoundVolume(50);
        radio.increaseVolume();

        Assertions.assertEquals(51, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax() { // увеличение громкости на 1 при уровне громкости = 99 (граничное значениие)
        radio.setSoundVolume(99);
        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void shouldIncreaseCurrentVolumeMax10() { // увеличение громкости на 1 при уровне громкости = 100
        radio.setSoundVolume(100);
        radio.increaseVolume();

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMin() { // уменьшение громкости на 1 при уровне громкости = 0
        radio.setSoundVolume(0);
        radio.turnDownVolume();

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMax() { // уменьшение громкости на 1 при уровне громкости = 1 (граничное значениие)
        radio.setSoundVolume(1);
        radio.turnDownVolume();

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolume() { // уменьшение громкости на 1 при уровне громкости внутри диапазона
        radio.setSoundVolume(6);
        radio.turnDownVolume();

        Assertions.assertEquals(5, radio.getSoundVolume());
    }

    @Test
    public void shouldReduceCurrentVolumeMax100() { // уменьшение громкости на 1 при уровне громкости = 100
        radio.setSoundVolume(100);
        radio.turnDownVolume();

        Assertions.assertEquals(99, radio.getSoundVolume());
    }

    @Test
    public void shouldTheVolumeLevel() {       //Установка макс громкости (гранич значение)
        radio.setSoundVolume(100);

        Assertions.assertEquals(100, radio.getSoundVolume());
    }

    @Test
    public void shouldTheVolumeLevelAboveMax() {   // Установка громкости выше допустимой
        radio.setSoundVolume(101);

        Assertions.assertEquals(0, radio.getSoundVolume());
    }

    @Test
    public void shouldTheVolumeMax() {  //Установка макс допустимой громкости
        radio.setMaxSoundVolume(100);

        Assertions.assertEquals(100, radio.getMaxSoundVolume());
    }
    @Test
    public void shouldTheVolumeMin() { //Установка мин допустимой громкости
        radio.setMinSoundVolume(0);

        Assertions.assertEquals(0, radio.getMinSoundVolume());
    }
    @Test
    public void shouldNumberOfStationsMax() { //Установка максимальной станции
        radio.setNumberOfStations(9);

        Assertions.assertEquals(9,radio.getNumberOfStations());
    }
    @Test
    public void shouldNumberOfStationsAverage() { //Установка станции в пределах допустимого диапазона
        radio.setNumberOfStations(6);

        Assertions.assertEquals(6,radio.getNumberOfStations());
    }

        @Test
        public void NumberOfStations() { // проверка значения в пределах диапазона (при выстановленом количестве радиостанций)
            Radio radio = new Radio(6);

            radio.setCurrentRadioStationNumber(3);


            Assertions.assertEquals(3, radio.getCurrentRadioStationNumber());
    }
    @Test
    public void shouldNotSetMaxRadioDefault() {  //Проверка значения больше диапазона (при количестве радиостанций по умолчанию)
        radio.setCurrentRadioStationNumber(20);

        Assertions.assertEquals(0,radio.getCurrentRadioStationNumber());
    }
    @Test
    public void shouldNotSetMaxRadioIfStationSetManually() {             //значения больше диапазона (при количестве радиостанций по умолчанию)
            Radio radio = new Radio(10);

            radio.setCurrentRadioStationNumber(15);

            Assertions.assertEquals(0,radio.getCurrentRadioStationNumber());
    }


}