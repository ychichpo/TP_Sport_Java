package Vues;

import Entities.Club;
import Entities.Sport;
import Entities.SportBallon;
import Entities.SportRelais;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

public class FrmMenu extends JFrame
{
    private JPanel pnlRoot;
    private JLabel lblClubs;
    private JTable tblClubs;
    private JLabel lblSports;
    private JTable tblSports;

    ArrayList<Club> lesClubs;
    ModelJTable mdl;

    public FrmMenu()
    {
        this.setTitle("TP6 - Héritage - Interface");
        this.setContentPane(pnlRoot);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

        lesClubs = new ArrayList<>();
        LoadDatas();

        Collections.sort(lesClubs);

        mdl = new ModelJTable();
        mdl.LoadDatasClubs(lesClubs);
        tblClubs.setModel(mdl);

        tblClubs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                int numClub = Integer.parseInt(tblClubs.getValueAt(tblClubs.getSelectedRow(),0).toString());
                for(Club club : lesClubs)
                {
                    if(club.getIdClub() == numClub)
                    {
                        mdl = new ModelJTable();
                        mdl.LoadDatasSports(club.getLesSports());
                        tblSports.setModel(mdl);
                        break;
                    }
                }
            }
        });
    }

    public void LoadDatas()
    {
        // Les clubs
        Club c1 = new Club(1, "Dijon",63);
        Club c2 = new Club(2, "PSG",67);
        Club c3 = new Club(3, "Nantes",65);

        // Les sports du Club de DIJON
        SportBallon sb = new SportBallon("Basketball",5,35,45);

        c1.AjouterSport(sb);

        // Les sports du Club du PSG
        Sport s1 = new Sport("Javelot", 1);
        Sport s2 = new Sport("Judo",1);
        SportBallon sb1 = new SportBallon("Football",11,68,105);
        SportBallon sb2 = new SportBallon("Handball",7,35,65);
        SportRelais sr1 = new SportRelais("4 * 100", 400, 4);

        c2.AjouterSport(s1);
        c2.AjouterSport(s2);
        c2.AjouterSport(sb1);
        c2.AjouterSport(sb2);
        c2.AjouterSport(sr1);

        // Les sports du Club de NANTES
        Sport s3 = new Sport("Cyclisme", 1);
        SportBallon sb3 = new SportBallon("Football",11,68,105);
        SportBallon sb4 = new SportBallon("Rugby",15,65,115);
        SportRelais sr2 = new SportRelais("100 mètres", 100, 1);

        c3.AjouterSport(s3);
        c3.AjouterSport(sb3);
        c3.AjouterSport(sb4);
        c3.AjouterSport(sr2);

        lesClubs.add(c1);lesClubs.add(c2);lesClubs.add(c3);
    }
}
