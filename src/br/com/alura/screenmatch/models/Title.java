package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculation.Classification;

public class Title implements Classification {
    private String name;
    private int releaseYear;
    private boolean includedOnPlan;
    private double ratingSum;
    private int ratingTotal;
    private int minDuration;

    public Title(String name, int releaseYear, boolean includedOnPlan) {
        super();
        this.name = name;
        this.releaseYear = releaseYear;
        this.includedOnPlan = includedOnPlan;
    }

    public void showInfo() {
        System.out.println("Movie title: " + name);
        System.out.println("Release year: " + releaseYear);
        System.out.println("Duration: " + minDuration);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getReleaseYear() {
        return releaseYear;
    }
    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public int getMinDuration() {
        return minDuration;
    }
    public void setMinDuration(int minDuration) {
        this.minDuration = minDuration;
    }

    public boolean isIncludedOnPlan() {
        return includedOnPlan;
    }
    public void setIncludedOnPlan(boolean includedOnPlan) {
        this.includedOnPlan = includedOnPlan;
    }

    public double getRatingSum() {
        return ratingSum;
    }

    public int getRatingTotal() {
        return ratingTotal;
    }

    public void rate(double rate) {
        ratingSum += rate;
        ratingTotal++;
    }

    public double getAverage() {
        return ratingSum / ratingTotal;
    }

    @Override
    public int getClassification() {
        return (int) getAverage() / 2;
    }

}