package ru.netology.oop.and.design;

public class Radio {

    //Объявление переменных (поля)
    private int currentRadioStationNumber;
    private int soundVolume;
    private int numberOfStations = 10;
    private int minSoundVolume = 0;
    private int maxSoundVolume = 100;

    // Геттеры и Сеттеры
    public int getNumberOfStations() {
        return numberOfStations;
    }

    public void setNumberOfStations(int numberOfStations) {
        this.numberOfStations = numberOfStations;
    }

    public int getMinSoundVolume() {
        return minSoundVolume;
    }

    public void setMinSoundVolume(int minSoundVolume) {
        this.minSoundVolume = minSoundVolume;
    }

    public int getMaxSoundVolume() {
        return maxSoundVolume;
    }
    public void setMaxSoundVolume(int maxSoundVolume) {
        this.maxSoundVolume = maxSoundVolume;
    }

    public int getCurrentRadioStationNumber() {
        return currentRadioStationNumber;
    }

    public int getSoundVolume() {
        return soundVolume;
    }

    public void setCurrentRadioStationNumber(int CurrentRadioStationNumber) {
        if (CurrentRadioStationNumber < 0) {
            return;
        }
        if (CurrentRadioStationNumber > (numberOfStations - 1)) {
            return;
        }
        currentRadioStationNumber = CurrentRadioStationNumber;
    }

    public void setSoundVolume(int newSoundVolume) {
        if (newSoundVolume > maxSoundVolume) {
            return;
        } else if (newSoundVolume < minSoundVolume) {
            return;
        } else {
            soundVolume = newSoundVolume;
        }
    }
            //Конструкторы
    public Radio() {
    }

    public Radio (int numberOfStations) {
        this.numberOfStations = numberOfStations;
    }

    // Методы
    public void next() {
        if (currentRadioStationNumber < (numberOfStations - 1)) {
            currentRadioStationNumber = currentRadioStationNumber + 1;
        } else {
            currentRadioStationNumber = 0;
        }
    }

    public void prev() {
        if (currentRadioStationNumber > 0) {
            currentRadioStationNumber = currentRadioStationNumber - 1;
        } else currentRadioStationNumber = numberOfStations - 1;
    }

    public void increaseVolume() {
        if (soundVolume < maxSoundVolume) {
            soundVolume = soundVolume + 1;
        }
    }

    public void turnDownVolume() {
        if (soundVolume > minSoundVolume) {
            soundVolume = soundVolume - 1;
        }
    }
}
