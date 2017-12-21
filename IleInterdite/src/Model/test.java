package Model;

public class test {

    public static void main(String[] args){

        Tuile[][] tuiles = new Tuile[6][6];


        Grille grille = new Grille();

        for(int i = 0; i < grille.getTuiles().length ; i++) { // Lignes
            for (int j = 0; j < grille.getTuiles().length; j++) { // Colonnes
                System.out.print(grille.getTuiles()[i][j]);System.out.print("|");
            }
            System.out.println();
        }





    }
}