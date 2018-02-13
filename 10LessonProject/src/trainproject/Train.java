package trainproject;


public class Train {
    
    private Engine engine;
    
    public Train(String ename, String carg, int cabID) {
        // TODO: Create the cars, and link 'em up!
        engine = new Engine(ename);
        engine.setBoxcar(new Boxcar(ename));
        engine.getBoxcar().setCaboose(new Caboose(cabID));
    }
    
    public String toString() {
        // TODO: Fix this so that the information for all three cars are shown
        return "Train:\n"+
                engine + "\n" +
                engine.getBoxcar() + "\n" +
                engine.getBoxcar().getCaboose();
    }
}
