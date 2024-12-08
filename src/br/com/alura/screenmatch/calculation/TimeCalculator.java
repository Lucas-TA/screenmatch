package br.com.alura.screenmatch.calculation;

import br.com.alura.screenmatch.models.Title;

public class TimeCalculator {
    private int totalTimeInMinutes;

    public int getTotalTimeInMinutes() {
        return this.totalTimeInMinutes;
    }

    public void include(Title t) {
        System.out.println("Adding time duration of " + t.getName());
        this.totalTimeInMinutes += t.getMinDuration();
    }
}