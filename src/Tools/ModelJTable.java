package Tools;

import Entities.Club;
import Entities.Sport;
import Entities.SportBallon;
import Entities.SportRelais;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class ModelJTable extends AbstractTableModel
{
    private String[] colonnes;
    private Object[][] lignes;

    @Override
    public int getRowCount() {
        return lignes.length;
    }

    @Override
    public int getColumnCount() {
        return colonnes.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colonnes[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return lignes[rowIndex][columnIndex];
    }

    public void LoadDatasClubs(ArrayList<Club> uneListe)
    {
        colonnes = new String[]{"Numéro","Nom","Nombre de points"};
        lignes = new Object[uneListe.size()][3];
        int i = 0;

        for(Club club : uneListe)
        {
            lignes[i][0] = club.getIdClub();
            lignes[i][1] = club.getNomClub();
            lignes[i][2] = club.getNbPoints();
            i++;
        }
        fireTableChanged(null);
    }

    public void LoadDatasSports(ArrayList<Sport> uneListe)
    {
        colonnes = new String[]{"Nom","Nombre de joueurs","Description","Largeur Terrain","Longueur Terrain","Distance"};
        lignes = new Object[uneListe.size()][6];
        int i = 0;

        for(Sport sport : uneListe)
        {
            lignes[i][0] = sport.GetNomSport();
            lignes[i][1] = sport.GetNbJoueurs();
            if(sport instanceof SportBallon)
            {
                lignes[i][2] =  sport.GetDescription();
                lignes[i][3] =  ((SportBallon) sport).GetLargeur();
                lignes[i][4] =  ((SportBallon) sport).GetLongueur();
            }
            else if(sport instanceof SportRelais)
            {
                lignes[i][2] =  sport.GetDescription();
                lignes[i][3] =  "";
                lignes[i][4] =  "";
                lignes[i][5] =  ((SportRelais) sport).getDistance();
            }
            else
            {
                lignes[i][2] =  sport.GetDescription();
                lignes[i][3] =  "";
                lignes[i][4] =  "";
                lignes[i][5] =  "";
            }

            i++;
        }
        fireTableChanged(null);
    }
}
