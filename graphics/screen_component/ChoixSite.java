package SAE.graphics.screen_component;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChoixSite extends JPanel implements ActionListener {



    int choix;
    ButtonGroup buttons=new ButtonGroup();
    JScrollPane view=new JScrollPane(this);

    public ChoixSite(){
        init();
    }

    void init(){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        addChoix("first");
        addChoix("second");
        view.revalidate();
    }

    public void addChoix(String name){
        //fixme affichage a refaire
        JRadioButton b=new JRadioButton(name);
        buttons.add(b);
        add(b);
        b.addActionListener(this);
        b.setActionCommand(""+getComponentCount());
        view.revalidate();
    }

    public int getChoix(){
        return choix;
    }


    public JScrollPane getView() {
        return view;
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd=e.getActionCommand();
        choix=Integer.parseInt(cmd)-1;


        System.out.println(choix);
    }



}
