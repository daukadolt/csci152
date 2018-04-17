
package robot_world;

import java.io.IOException;
import java.util.Stack;

public class SuperRobotWorld extends RobotWorld {

	// TODO: Add some fields to keep track of commands
    private Stack<String> logs;
	
    public SuperRobotWorld(String mapFile) throws IOException {
        super(mapFile);
        logs = new Stack<>();
    }
    
    /**
     * Undo the last move or rotation command that put the robot
     * in its current state.  If no commands have been issued yet,
     * do nothing.
     */
    @Override
    public void rotateClockwise() {
        super.rotateClockwise();
        logs.push("RClockwise");
    }

    @Override
    public void rotateCounterClockwise() {
        super.rotateCounterClockwise();
        logs.push("RCounterClockwise");
    }

    @Override
    public void moveForward() throws Exception {
        super.moveForward();
        logs.push("MoveForward");
    }

    public void undoCommand() {
        // TODO: Fix me
        char robot = getWorldMap()[getRobotRow()][getRobotColumn()];
        String lastMove = "";
//        lastMove = logs.pop();
        while(!(lastMove = logs.pop()).split(":")[0].equals(lastMove)) {};
        if(lastMove.equals("MoveForward")) {
            if(robot == NORTH) {
                getWorldMap()[getRobotRow()+1][getRobotColumn()] = robot;
                getWorldMap()[getRobotRow()][getRobotColumn()] = SPACE;
                setRobotRow(getRobotRow()+1);
            } else if (robot == SOUTH) {
                getWorldMap()[getRobotRow()-1][getRobotColumn()] = robot;
                getWorldMap()[getRobotRow()][getRobotColumn()] = SPACE;
                setRobotRow(getRobotRow()-1);
            } else if(robot == WEST) {
                getWorldMap()[getRobotRow()][getRobotColumn()+1] = robot;
                getWorldMap()[getRobotRow()][getRobotColumn()] = SPACE;
                setRobotRow(getRobotRow()+1);
            } else if(robot == EAST) {
                getWorldMap()[getRobotRow()][getRobotColumn()-1] = robot;
                getWorldMap()[getRobotRow()][getRobotColumn()] = SPACE;
                setRobotRow(getRobotRow()-1);
            }
            logs.push("Undone:MoveForward");
        } else if(lastMove.equals("RClockwise")) {
            if(robot == NORTH) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = WEST;
            } else if(robot == WEST) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = SOUTH;
            } else if(robot == SOUTH) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = EAST;
            } else if(robot == EAST) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = NORTH;
            }
            logs.push("Undone:RClockwise");
        } else if(lastMove.equals("RCounterClockwise")) {
            if(robot == NORTH) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = EAST;
            } else if(robot == EAST) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = SOUTH;
            } else if(robot == SOUTH) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = WEST;
            } else if(robot == WEST) {
                getWorldMap()[getRobotRow()][getRobotColumn()] = NORTH;
            }
            logs.push("Undone:RCounterClockwise");
        }
    }

    /**
     * Undo the last n commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to undo
     */
    public void undoCommands(int n) {
        if(n <= 0) return;
    	// TODO:  Three lines of code, if you use undoCommand
        if(logs.size() < n) n = logs.size();
        for(int i = 0; i<n; i++) {
            undoCommand();
        }
    }
    
    /**
     * For previously undone commands, redo the last command that was
     * undone
     */
    public void redoUndoneCommand() {
//        System.out.println("REDO");
        if(logs.size() == 0) return;
        // TODO: Fix me!!!
        String lastMove = logs.pop();
        System.out.println(lastMove);
        if(lastMove.split(":")[0].equals(lastMove)) {
            logs.push(lastMove);
            return;
        }
        lastMove = lastMove.split(":")[1];
        if(lastMove.equals("MoveForward")) {
//            System.out.println("MoveForward");
            try {
                moveForward();
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        } else if(lastMove.equals("RClockwise")) {
            rotateClockwise();
        } else if(lastMove.equals("RCounterClockwise")) {
            rotateCounterClockwise();
        }
    }
    
    /**
     * Redo the last n undone commands.  Do nothing if n is zero or negative.
     * 
     * @param n the number of commands to redo
     */
    public void redoUndoneCommands(int n) {
        if(n <= 0) return;
    	// TODO:  Also three lines of code
        if(logs.size() < n) n = logs.size();
        for(int i = 0; i<n; i++) {
            redoUndoneCommand();
        }
    }

    public String showLogs() {
        String contents = "";
        int size = logs.size();
        for(int i = 0; i<size; i++) {
            contents += logs.pop() + "\n";
        }

        return contents;
    }
}
