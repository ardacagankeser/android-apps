package com.ardacagankeser.landmarkbook;

public class Singleton {
    private Landmark selectedLandmark;
    private static Singleton singleton;
    private Singleton() {

    }

    public Landmark getSelectedLandmark() {
        return selectedLandmark;
    }

    public void setSelectedLandmark(Landmark landmark) {
        this.selectedLandmark = landmark;
    }

    public static Singleton getInstance() {
        if(singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
}
