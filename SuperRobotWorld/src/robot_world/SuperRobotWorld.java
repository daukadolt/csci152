
package robot_world;

import java.io.IOException;

public class SuperRobotWorld extends RobotWorld {

	// TODO: Add some fields to keep track of commands
	
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    public void undoCommand() {
        // TODO: Fix me 
    }
    
    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
    	// TODO:  Three lines of code, if you use undoCommand
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
        // TODO: Fix me!!!
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
    	// TODO:  Also three lines of code
    }
}
