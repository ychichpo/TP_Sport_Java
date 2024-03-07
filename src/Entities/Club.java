package Entities;

import java.util.ArrayList;

public class Club implements Comparable<Club>
{
    private int idClub;
    private String nomClub;
    private int nbPoints;
    private ArrayList<Sport> lesSports;

    public Club(int unId, String unNom,int unNbPoints)
    {
        idClub = unId;
        nomClub = unNom;
        nbPoints = unNbPoints;
        lesSports = new ArrayList();
    }

    public int getIdClub()
    {
        return idClub;
    }

    public String getNomClub()
    {
        return nomClub;
    }

    public ArrayList<Sport> getLesSports()
    {
        return lesSports;
    }

    public int getNbPoints()
    {
        return nbPoints;
    }

    public void AjouterSport(Sport unSport)
    {
        lesSports.add(unSport);
    }

    @Override
    public int compareTo(Club o)
    {
        return Integer.compare( o.nbPoints,this.nbPoints);
    }
}
