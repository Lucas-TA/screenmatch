package br.com.alura.screenmatch.calculation;

public class FilterRecomendation {

    public void filter(Classification classification) {
        if (classification.getClassification() >= 4) {
            System.out.println("This title is one of the favourites of the moment!!!");
        } else if (classification.getClassification() >=2) {
            System.out.println("Well rated on this week");
        } else {
            System.out.println("Add to your watch-later playlist.");
        }
    }
}