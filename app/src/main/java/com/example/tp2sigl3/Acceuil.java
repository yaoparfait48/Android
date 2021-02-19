package com.example.tp2sigl3;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Acceuil extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    //le drawer
    private  DrawerLayout drawer;
    private ArrayList<DataModel> listV;
    private ArrayList<DataModel> listM;
    private ArrayList<ListModel> listVModels;
    private  ArrayList<DataModel> listU;

    DBHelper dbHelper = new DBHelper(Acceuil.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.accueil);


        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toogle);
        toogle.syncState();

        if(savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new AccueilFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_acceuil);
        }



        listV = dbHelper.recupererTout();
        listM =dbHelper.recupereMacth(1);
        listU = dbHelper.recupereUrgence();

        if(listV.isEmpty()) {
            /**
             * Rencontres
             */
            dbHelper.ajouterSite(new DataModel(-1, "Stade d'Ebimpé Abidjan", "Rencontre", 5.480741, -4.075182, "https://youtu.be/pP-0lSfZyZU", R.drawable.stade_ebinp_, "Le stade olympique d'Ebimpé, surnommé \"Stade Alassane Ouattara\"1, est un stade polyvalent, pouvant accueillir football, rugby et athlétisme, à Ebimpé et Anyama, au nord d'Abidjan en Côte d'Ivoire. C’est le stade national de l'équipe nationale de football de Côte d'Ivoire. , il est situé dans la commune de Yopougon, avec une capacite de 60.000 places."));
            dbHelper.ajouterSite(new DataModel(-1, "Stade de la paix Bouaké", "Rencontre", 7.683241, -5.044869, "https://youtu.be/JeugjmhqNJU", R.drawable.stade_bouake, "Le stade municipal de Bouaké ou stade de la Paix (depuis la cérémonie de la Flamme de la paix de 2007) est un stade de football de Côte d'Ivoire qui se situe dans la ville de Bouaké. Il peut accueillir 50 000 spectateurs assis. Il a été spécialement construit pour accueillir, avec le Stade Félix Houphouët-Boigny, les matchs de la Coupe d'Afrique des nations de football 1984."));
            dbHelper.ajouterSite(new DataModel(-1, "Stade de Yamoussoukro", "Rencontre", 6.829375, -5.246302, "https://youtu.be/jVpmgUma2To", R.drawable.stade_yakro, "Le contrat de conception-construction du stade de Yamoussoukro, en Côte d’Ivoire, a été confié à un groupement emmené par Sogea-Satom (filiale de Vinci Construction), Egis, Baudin-Chateauneuf et Alcor. Avec une piste d’athlétisme en revêtement synthétique viendra entourer l’aire de jeux, en complément d’aires de saut et de lancer. Le stade doit accueillir 20 000 spectateurs dans l’optique de la Coupe d’Afrique des Nations (CAN) organisée en 2021 en Côte d’Ivoire."));
            dbHelper.ajouterSite(new DataModel(-1, "Stade de Korhogo", "Rencontre", 9.52730, -5.63672, "https://youtu.be/3youFIgva5o", R.drawable.stade_korhogo, "D'un coût global estimé à environ 77 M EUR, ce stade ultra-moderne de 20 000 places sera bâti par la China National Building Material sur une superficie de 50 hectares. A côté de cette infrastructure, seront construits 4 terrains d’entraînement et la cité CAN qui comprendra 32 villas et un hôtel 4 étoiles. "));
            dbHelper.ajouterSite(new DataModel(-1, "Stade FHB Abidjan", "Rencontre", 5.32899, -4.01867, "https://youtu.be/Fqw9hHxotEM", R.drawable.stade_fhb, "Le Stade Félix-Houphouët-Boigny, surnommé « Le Félicia », est le stade national multifonctionnel (football, rugby, athlétisme) de Côte d'Ivoire, du nom du fondateur de la nation ivoirienne Félix Houphouët-Boigny. Situé dans la commune du Plateau d'Abidjan, il a une capacité d'environ 35 000 spectateurs1. Il accueille les matchs de l'Équipe Ivoirienne de football, ainsi que certains matchs du championnat national de football. Après la rénovation en cours, à partir de 2020, le Félicia sera étendu à une capacité de 40,000 places assises, mais perdra son statut de stade national au profit du Stade olympique Ebimpé à Anyama. Les travaux d'extension sont entrepris par Mota Engil dans le cadre de l'organisation de la Can 2023."));
            dbHelper.ajouterSite(new DataModel(-1, "Stade de San-Pedro", "Rencontre", 4.85335, -6.48247, "https://youtu.be/czpV8Wdn6sk", R.drawable.stade_korhogo, "Situé au Sud-Ouest de la Côte d'Ivoire, San Pedro est une ville balnéaire regorgeant d'énormes potentialités touristique. La ville accueillera dans 3 ans certaines rencontres de la CAN 2023. Pour ce fait, un stade de 20000 places va sortir de terre, une cité CAN constitué de 32 villas de 5 pièces et 4 terrains d'entrainement pour un montant estimé à hauteur de 60 milliards de francs CFA"));
            /**
             * Evenement
             */
            dbHelper.ajouterSite(new DataModel(-1, "Cérémonie d'ouverture", "Evenement", 5.481046, -4.074318, "video de presentation", R.drawable.ouveture, "La cérénomie d'ouverture de la CAN 2023 ce deroulera le 20 Juin 2023 avec un spectacle à coupé le soufle elle aura lieu au stade de Ebimpé"));
            dbHelper.ajouterSite(new DataModel(-1, "Bal detente à Assini", "Evenement", 5.145870028884082, -3.32190530246319, "video de presentation", R.drawable.soiree_assini, "Assinie est une station balnéaire au Sud-Est de la Côte d’Ivoire"));

            /**
             * Site touristiques
             * ,
             */
            //Culture
            dbHelper.ajouterSite(new DataModel(-1, "Pont de lianne", "Culture", 7.407279, -7.556150, "video de presentation", R.drawable.man_pont_lianne, "Chez les Yacouba, les ponts de lianes constituent un véritable patrimoine culturel spécifique qui joue un rôle essentiel dans la relation et la communication entre les communautés. On identifie une dizaine de ponts de lianes dans cette région en bon état dont le plus célèbre est celui de Lieupleu un village de la région. Il traverse le fleuve Cavally à 80km à  l’ouest de Man. Leur traversée se fait à pieds nus par respect pour les vieux initiés, aussi au risque de s’exposer à des accidents, qui selon les croyances  des communautés concernées, sont souvent d’origine mystique."));
            dbHelper.ajouterSite(new DataModel(-1, "La cascade de Man", "Culture", 7.41160, -7.58610, "video de presentation", R.drawable.soiree_assini, "Assinie est une station balnéaire au Sud-Est de la Côte d’Ivoire"));
            dbHelper.ajouterSite(new DataModel(-1, "Musée des civilistions de Côte d'Ivoire", "Culture", 5.33360, -4.02422, "video de presentation", R.drawable.muse_nat, "Créé en 1942 par l’admission coloniale, le musée des civilisations de Côte d’Ivoire, est un musée d’État, situé à Abidjan la capitale économique, plus précisément dans la commune du Plateau. Il s’étend sur une superficie de 2 hectares"));
            dbHelper.ajouterSite(new DataModel(-1, "Musée national des costumes de Grand Bassam", "Culture", 5.19615, -3.73688, "video de presentation", R.drawable.grand_bassam_musee_costume, "Le musée national du costume de Grand-Bassam (MNCGB) est un musée d’État situé à Grand-Bassam, en Côte d'Ivoire. Le musée national du costume de Grand-Bassam (MNCGB) est un musée d’État situé à Grand-Bassam, en Côte d'Ivoire."));
            dbHelper.ajouterSite(new DataModel(-1, "Musée Péléféro Gbon Coulibaly Korhogo", "Culture", 9.45580, -5.62740, "video de presentation", R.drawable.peleforoo, "Le musée Péléféro Gbon Coulibaly est un musee localisé en Côte d'ivoire plus précisement à Korhogo dans la région des savanes"));
            //Religion
            dbHelper.ajouterSite(new DataModel(-1, "Cathédrale Saint-Paul d'Abidjan", "Religion", 5.33273, -4.02004, "video de presentation", R.drawable.cathedrale_plateu, "Cette cathédrale a été bâtie par l'architecte italien Aldo Spirito, à Abidjan à l'initiative du président Félix Houphouët-Boigny. La première pierre de cette cathédrale a été bénie le 11 mai 1980 par le pape Jean-Paul II à l'occasion de sa première visite pastorale en Côte d'Ivoire"));
            dbHelper.ajouterSite(new DataModel(-1, "Mosqué du plateau", "Religion", 5.31935, -4.01569, "video de presentation", R.drawable.mosque_plateau, "Une mosque très jolie et très vaste, très bien fréquentée surtout le vendredi , placée au centre du plateau, elle très accessible."));
            dbHelper.ajouterSite(new DataModel(-1, "Basilique Notre-Dame-de-la-Paix de Yamoussoukro", "Religion", 6.81123, -5.29639, "video de presentation", R.drawable.basilique, "La basilique Notre-Dame-de-la-Paix de Yamoussoukro est l’édifice religieux catholique le plus grand au monde. Son apparence rappelle celle de la basilique Saint-Pierre à Rome. Située à Yamoussoukro, capitale de la Côte d'Ivoire, son emplacement a été choisi par le premier président du pays, Félix Houphouët-Boigny, en 1983. Le livre Guinness des records l'a reconnu en 1989 comme l'édifice religieux chrétien le plus large au monde (150 m de largeur contre 115 m pour la basilique Saint-Pierre)1. La basilique est un lieu fervent de la foi catholique en Afrique"));
            dbHelper.ajouterSite(new DataModel(-1, "Mosquée de Kong", "Religion", 9.14918, -4.60949, "video de presentation", R.drawable.mosquee_kong, "La mosquée de Kong ou Grande mosquée de Kong est un édifice religieux islamique situé dans la ville de Kong au nord de la Côte d'Ivoire. En 1741 il a été noté que la ville de Kong possédait déjà plusieurs mosquées dont la Grande mosquée (Missiriba) détruite par Samory Touré vers 1897 et rebâtie à l'aube du XXe siècle."));
            //hotel
            dbHelper.ajouterSite(new DataModel(-1, "Hôtel Ivoire", "Hotel", 5.32719,-4.00494, "video de presentation", R.drawable.sofitel_hotelivoire, "L'hôtel Ivoire est un gratte-ciel et un complexe hôtelier de luxe situé au bord de la lagune Ébrié à Abidjan en Côte d'Ivoire. Haute de vingt-cinq étages (100 mètres), elle offre une vue sur l'ensemble de la ville et abrite 429 chambres et suites. Le complexe abrite également plusieurs piscines et jardins et comporte un palais des congrès. Construit en trois tranches à partir de 1963, l'Hôtel Ivoire est devenu le témoin malheureux des crises qu'a traversé le pays, et renvoyait une image de déliquescence avant sa remise à neuf complète et la réouverture de la tour Ivoire le 25 novembre 20111 et du bâtiment central le 15 mai 2015. "));
            dbHelper.ajouterSite(new DataModel(-1, "Hotel novotel", "Hotel", 5.31600, -4.01647, "video de presentation", R.drawable.hotel_novotel, "Au Novotel Abidjan tout est source de découverte et de détente : du design sophistiqué au jardin relaxant, en passant par les services modernes, nous vous souhaitons un agréable séjour."));
            dbHelper.ajouterSite(new DataModel(-1, "Hotel Akwa Beach", "Hotel", 5.15189, -3.39294, "video de presentation", R.drawable.assini_beaches, "Niché dans un jardin paradisiaque, notre complexe hôtelier situé au kilomètre 9,5 Route d’Assinie-Mafia vous offre 35 chambres de luxe dont 15 suites avec jacuzzi et 3 chambres familiales aves 2 lits supplémentaires. Vous pourrez vous détendre autour de notre grande piscine ou sur notre plage côté lagune, et profiter de la cuisine raffinée de notre restaurant avec vue imprenable sur la lagune. Nos salles de conférences vous accueillent pour vos séminaires et notre salle de fitness attend les sportifs. Pour les amoureux de sports nautiques, nos jetskis sont à votre disposition ainsi que nos hors-bords pour le ski nautique ou la bouée tractée. Nous vous souhaitons un séjour inoubliable à Akwa Beach "));
            dbHelper.ajouterSite(new DataModel(-1, "Hotel President", "Hotel", 6.80288, -5.25204, "video de presentation", R.drawable.stade_fhb, "L'hôtel Président de Yamoussoukro est un hôtel 5 étoiles situé dans la capitale administrative de la Côte d'Ivoire, en Afrique de l'Ouest. Il est bâti dans un parc fleuri de 25 hectares, à 1 km du centre ville et à 14 km de l’aéroport. "));
            dbHelper.ajouterSite(new DataModel(-1, "Ran Hotel", "Hotel", 7.68377, -5.04652, "video de presentation", R.drawable.stade_fhb, "L'hôtel Président de Yamoussoukro est un hôtel 5 étoiles situé dans la capitale administrative de la Côte d'Ivoire, en Afrique de l'Ouest. Il est bâti dans un parc fleuri de 25 hectares, à 1 km du centre ville et à 14 km de l’aéroport. "));

        }

        if(listM.isEmpty()){
            dbHelper.ajouterMatch(new DataModel(-1, 1, "Afrique du sud - Namibi", "Eliminatoire", "21 Juin 2023", "19h00", "video_du_match", R.drawable.afrsud_nam, "Groupe A"));
            dbHelper.ajouterMatch(new DataModel(-1, 1, "Tunisie - Angola", "Eliminatoire", "24 Juin 2023", "15h00", "video_du_match", R.drawable.tun_ang, "Groupe A"));
            dbHelper.ajouterMatch(new DataModel(-1, 1, "Mauritanie - Guinnée", "Eliminatoire", "24 Juin 2023", "19h00", "video_du_match", R.drawable.maur_guin, "Groupe A"));
            dbHelper.ajouterMatch(new DataModel(-1, 2, "Nigeria - Madagascar", "Eliminatoire", "22 Juin 2023", "15h00", "video_du_match", R.drawable.nig_madg, "Groupe B"));
            dbHelper.ajouterMatch(new DataModel(-1, 2, "Guinnée - Burundi", "Eliminatoire", "22 Juin 2023", "19h00", "video_du_match", R.drawable.guin_burun, "Groupe B"));
            dbHelper.ajouterMatch(new DataModel(-1, 2, "Ghana - Benin", "Eliminatoire", "23 Juin 2023", "19h00", "video_du_match", R.drawable.ghan_benin, "Groupe B"));
            dbHelper.ajouterMatch(new DataModel(-1, 3, "Senegale - Algerie", "Eliminatoire", "23 Juin 2023", "19h00", "video_du_match", R.drawable.seg_alg, "Groupe C"));
            dbHelper.ajouterMatch(new DataModel(-1, 3, "Kenya - Tanzanie", "Eliminatoire", "21 Juin 2023", "19h00", "video_du_match", R.drawable.ken_tanz, "Groupe C"));
            dbHelper.ajouterMatch(new DataModel(-1, 4, "Maroc - Côte d'Ivoire", "Eliminatoire", "23 Juin 2023", "17h00", "video_du_match", R.drawable.mar_civ, "Groupe D"));
            dbHelper.ajouterMatch(new DataModel(-1, 4, "Benin - Guinnée Bissau", "Eliminatoire", "24 Juin 2023", "17h00", "video_du_match", R.drawable.egt_zimbw, "Groupe D"));
            dbHelper.ajouterMatch(new DataModel(-1, 5, "Benin - Guinnée Bissau", "Eliminatoire", "23 Juin 2023", "19h00", "video_du_match", R.drawable.ben_guinbissau, "Groupe E"));
            dbHelper.ajouterMatch(new DataModel(-1, 5, "Angola - Maureitanie", "Eliminatoire", "23 Juin 2023", "19h00", "video_du_match", R.drawable.ang_maur, "Groupe E"));
            dbHelper.ajouterMatch(new DataModel(-1, 5, "Madagascar - Guinnée", "Eliminatoire", "21 Juin 2023", "19h00", "video_du_match", R.drawable.madg_guin, "Groupe E"));
            dbHelper.ajouterMatch(new DataModel(-1, 6, "Cameroun - Ghana", "Eliminatoire", "25 Juin 2023", "15h00", "video_du_match", R.drawable.cam_ghan, "Groupe F"));
            dbHelper.ajouterMatch(new DataModel(-1, 6, "RDC Congo - Ouganda", "Eliminatoire", "25 Juin 2023", "19h00", "video_du_match", R.drawable.rdc_oug, "Groupe F"));

        }

        if(listU.isEmpty()){
            dbHelper.ajouterUrgence(new DataModel(-1, R.drawable.ic_copte_user, "SAMU", "109"));
            dbHelper.ajouterUrgence(new DataModel(-1, R.drawable.ic_copte_user, "Pompier", "15"));
            dbHelper.ajouterUrgence(new DataModel(-1, R.drawable.ic_copte_user, "Police", "17"));
        }

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.nav_compte:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new CompteFragment()).commit();
                break;
            case R.id.nav_acceuil:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AccueilFragment()).commit();
                break;
            case R.id.nav_renc:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new RencontreFragment()).commit();
                break;
            case R.id.nav_event:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new EvenementFragment()).commit();
                break;
            case R.id.nav_tour:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new TourismeFragment()).commit();
                break;
            case R.id.nav_urg:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new UrgencesFragment()).commit();
                break;
        }



        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }
}