package Entities;

public class Sport implements ISport,ISportCollectif
{
    private String nomSport;
    private int nbJoueurs;

    // Constructeur paramétré
    public Sport(String unNom, int unNbJoueurs)
    {
        nomSport = unNom;
        nbJoueurs = unNbJoueurs;
    }

    @Override
    public String GetNomSport()
    {
        return nomSport;
    }


    @Override
    public String GetDescription()
    {
        return "Sport = " +nomSport + " Nombre de joueurs = "+ nbJoueurs;
    }

    @Override
    public int GetNbJoueurs()
    {
        return nbJoueurs;
    }
}
