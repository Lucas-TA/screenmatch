package br.com.alura.screenmatch.models;

import br.com.alura.screenmatch.calculation.Classification;
import br.com.alura.screenmatch.exceptions.InvalidYearFormat;

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

    public Title(TitleOmdb titleOmdb) {
        this.name = titleOmdb.title();
        if (titleOmdb.year().length() > 4) {
            throw new InvalidYearFormat("Invalid year. Year contains more than 4 characters");
        }
        this.releaseYear = Integer.parseInt(titleOmdb.year());
        this.minDuration = Integer.parseInt(titleOmdb.runtime().substring(0, 3));
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

    @Override
    public String toString() {
        return  "(Title: '" + name + '\'' +
                ", Released: " + releaseYear +
                ", Duration: " + minDuration +
                ")";
    }
}