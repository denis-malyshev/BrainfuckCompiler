package com.teamdev.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class OptimizationVisitor implements CommandVisitor {

    private final List<OptimizedCommand> optimizedCommands = new ArrayList();
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

    public List<OptimizedCommand> getOptimizedCommands() {
        return optimizedCommands;
    }

    @Override
    public void visit(MoveForwardCommand command) {
        optimization(command);
    }

    @Override
    public void visit(MoveBackwardCommand command) {
        optimization(command);
    }

    @Override
    public void visit(IncrementCommand command) {
        optimization(command);
    }

    @Override
    public void visit(DecrementCommand command) {
        optimization(command);
    }

    @Override
    public void visit(PrintCommand command) {
        optimization(command);
    }

    @Override
    public void visit(LoopCommand command) {
        for (Command innerCommand : command.getInnerCommands()) {
            optimization(innerCommand);
        }
        optimization(command);
    }
}
