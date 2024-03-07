package Entities;

public class SportRelais extends Sport
{
    private int distance;

    public SportRelais(String unNom, int uneDistance, int unNbDeJoueurs)
    {
        super(unNom,unNbDeJoueurs);
        distance = uneDistance;
    }

    @Override
    public String GetDescription()
    {
        return super.GetDescription()+ " Distance = " + getDistance();
    }
    public int getDistance()
    {
        return distance;
    }
}
