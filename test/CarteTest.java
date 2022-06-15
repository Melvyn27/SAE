package SAE.test;

import SAE.action.VoisinDe;
import SAE.map.Carte;
import SAE.map.Site;
import org.junit.*;

import static org.junit.Assert.*;

public class CarteTest{

    @Test
    public void ajoutSiteTest(){
        Carte carte = new Carte();
        carte.ajouterSite('V',"Lyon");
        assertEquals(1,carte.getSites().size());
        assertEquals("Lyon",carte.getSites().get(0).getNom());
        assertEquals("Lyon",carte.sites.get("Lyon").getNom());
    }
    @Test
    public void ajoutRouteTest(){
        Carte carte = new Carte();
        Site s1 = new Site("Grenoble",'V');
        Site s2 = new Site("Lyon",'V');

        s1.ajouterRoute('A',80,"Lyon");
        s2.ajouterRoute('A',80,"Grenoble");
        carte.ajouterSite(s1);
        carte.ajouterSite(s2);

        assertEquals("Lyon",s1.getVoisin().get(0));
        assertEquals("Grenoble",s2.getVoisin().get(0));

    }
    @Test
    public void voisinDeTest(){
        Carte carte = new Carte();
        Site grenoble = new Site("Grenoble",'V');
        Site lyon = new Site("Lyon",'V');
        Site clermon = new Site("Clermon",'V');

        grenoble.ajouterRoute('A',80,"Lyon");
        lyon.ajouterRoute('A',80,"Grenoble");

        clermon.ajouterRoute('A',100,"Lyon");
        lyon.ajouterRoute('A',100,"Clermon");

        clermon.ajouterRoute('A',150,"Grenoble");
        grenoble.ajouterRoute('A',150,"Clermon");

        carte.ajouterSite(grenoble);
        carte.ajouterSite(lyon);
        carte.ajouterSite(clermon);


        assertEquals(true,new VoisinDe(false,carte).start("Lyon",1).getSites().contains(grenoble));
        assertEquals(true,new VoisinDe(false,carte).start("Lyon",1).getSites().contains(clermon));



    }





}
