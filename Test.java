
package SAE;

import SAE.graphics2.threadedMotors.ChargementParallele;

public class Test {
    private int test;
    private int bg;

    public Test(int test, int bg) {
        this.test = test;
        this.bg = bg;
    }

    public int getTest() {
        return test;
    }

    public void setTest(int test) {
        this.test = test;
    }

  /*test lancement parallel utile pour la methode load
    public static void main(String[] args) {
        JProgressBar jb = new JProgressBar();
        Thread t= new Thread(){
            @Override
            public void run() {
                for(int i = 0 ; i<100 ; i++) {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        };
        t.start();
        System.out.println("here");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.stop();
    }
   */

    /**
     * test l'utilisation des Thread de maniere répeté
     * @param args
     * @see Thread
     * @see Runnable
     */
    public static void main(String[] args) {
        ChargementParallele chargement = new ChargementParallele(null,null);
        chargement.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chargement.arreter();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(chargement.isAlive());
        chargement.start();
    }

}