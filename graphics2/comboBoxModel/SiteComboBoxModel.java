package SAE.graphics2.comboBoxModel;

import SAE.map.Site;

import javax.swing.*;
import javax.swing.event.ListDataListener;
import java.util.ArrayList;

public class SiteComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

ArrayList<String> sites = new ArrayList<>();
String selectionné;

    public void addChoix(String name){
        sites.add(name);
        fireIntervalAdded(sites,sites.size()-1,sites.size()-1);
        setSelectedItem(sites.get(sites.size()-1));
    }
    public void resetChoix(){
        sites.clear();
        fireIntervalRemoved(sites,0,sites.size()-1);
        setSelectedItem(null);
    }
    public void addChoix(ArrayList<Site> sites){
        for(Site s: sites)this.sites.add(s.getNom());
        fireIntervalAdded(sites,0,sites.size()-1);
        setSelectedItem(this.sites.get(0));
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
        selectionné = anItem.toString();
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
