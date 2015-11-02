package com.teamdev.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class OptimizationVisitor implements CommandVisitor {

    private final List<Command> optimizedCommands = new ArrayList();
    private Command lastCommand;
    private int counts;

    private void optimization(Command currentCommand) {
        if (counts == 0)
            lastCommand = currentCommand;
        if (currentCommand.getClass() == lastCommand.getClass()) {
            counts++;
        } else {
            optimizedCommands.add(new OptimizedCommand(lastCommand, counts));
            lastCommand = currentCommand;
            counts = 1;
        }
    }

    public List<Command> getOptimizedCommands() {
        return optimizedCommands;
    }

    public void visit(MoveForwardCommand command) {
        optimization(command);
    }

    public void visit(MoveBackwardCommand command) {
        optimization(command);
    }

    public void visit(IncrementCommand command) {
        optimization(command);
    }

    public void visit(DecrementCommand command) {
        optimization(command);
    }

    public void visit(PrintCommand command) {
        optimization(command);
    }

    public void visit(LoopCommand command) {
        /*optimization(command);
        final List<Command> innerCommands = command.getInnerCommands();
        counts=0;
        for (Command innerCommand:innerCommands) {
            optimization(innerCommand);
        }
        counts=1;
        optimization(command);*/
    }

    public void visit(OptimizedCommand command) {
        optimizedCommands.add(command);
    }
}
