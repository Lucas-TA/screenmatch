package br.com.alura.screenmatch.models;

public class Serie extends Title {
    private int seasons;
    private boolean active;
    private int episodesPerSeason;
    private int minPerEpisode;

    public Serie(String name, int releaseYear, boolean includedOnPlan, int seasons, boolean active) {
        super(name, releaseYear, includedOnPlan);
        this.seasons = seasons;
        this.active = active;
    }

    public int getSeasons() {
        return seasons;
    }
    public void setSeasons(int seasons) {
        this.seasons = seasons;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public int getEpisodesPerSeason() {
        return episodesPerSeason;
    }
    public void setEpisodesPerSeason(int episodesPerSeason) {
        this.episodesPerSeason = episodesPerSeason;
    }

    public int getMinPerEpisode() {
        return minPerEpisode;
    }
    public void setMinPerEpisode(int minPerEpisode) {
        this.minPerEpisode = minPerEpisode;
    }

    @Override
    public int getMinDuration() {
        return seasons * episodesPerSeason * minPerEpisode;
    }

    @Override
    public void showInfo() {
        System.out.println("Serie title: " + getName());
        System.out.println("Release year: " + getReleaseYear());
        System.out.println("Seasons: " + seasons);
        System.out.println("Duration: " + getMinDuration() + "min");
    }
    @Override
    public String toString() {
        return "Serie: " + this.getName() + " (" + this.getReleaseYear() + "), Seasons: " + this.getSeasons();
    }

}