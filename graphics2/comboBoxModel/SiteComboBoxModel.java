package SAE.graphics2.comboBoxModel;

import SAE.map.Site;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class SiteComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

ArrayList<String> sites = new ArrayList<>();
String selectionné;

    public ArrayList<String> getSites() {
        return sites;
    }

    public void addChoix(String name){
        System.out.println(name);
        sites.add(name);
        fireIntervalAdded(sites,sites.size()-1,sites.size()-1);
        setSelectedItem(sites.get(sites.size()-1));
    }
    public void resetChoix(){
        sites.clear();
        selectionné=null;
        fireIntervalRemoved(sites,0,sites.size()-1);
    }
    public void addChoix(ArrayList<Site> sites){
        for(Site s: sites)addChoix(s.getNom());
        //setSelectedItem(sites.get(0));
        //fireIntervalAdded(sites,0,sites.size()-1);
    }

    @Override
    protected void fireIntervalRemoved(Object source, int index0, int index1) {
        super.fireIntervalRemoved(source, index0, index1);
    }

    @Override
    protected void fireIntervalAdded(Object source, int index0, int index1) {
        super.fireIntervalAdded(source, index0, index1);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        selectionné =(String) anItem.toString();
    }

    @Override
    public Object getSelectedItem() {
        return selectionné;
    }

    @Override
    public int getSize() {
        return sites.size();
    }

    @Override
    public String getElementAt(int index) {
        return sites.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {

    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }
}
