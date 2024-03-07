package Entities;

public class SportBallon extends Sport implements ITerrain
{
    private int largeur;
    private int longueur;

    public SportBallon(String unNom, int unNbJoueurs, int uneLargeur, int uneLongeur)
    {
        super(unNom,unNbJoueurs);
        largeur = uneLargeur;
        longueur = uneLongeur;
    }

    @Override
    public int GetLargeur()
    {
        return largeur;
    }

    @Override
    public int GetLongueur()
    {
        return longueur;
    }

    @Override
    public String GetDescription()
    {
        return super.GetDescription()+ " Terrain = "+ largeur +" * "+ longueur;
    }
}
