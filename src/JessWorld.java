/**
 * Created by lad on 25.04.2016.
 */
import jess.*;

public class JessWorld extends Thread{

    Rete engine = new Rete();

    public JessWorld() {
        try {
            engine.batch("/home/lad/IdeaProjects/is/src/jess_world.clp");

        }catch (Exception e){
            System.err.println("Jess World error - constructor");
        }
    }

    public void run(){
        try{

            engine.runUntilHalt();

        }catch(Exception e){
            System.err.println("Error execute file JessWorld");
        }
    }


}
