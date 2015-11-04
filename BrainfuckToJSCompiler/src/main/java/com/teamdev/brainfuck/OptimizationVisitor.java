package com.teamdev.brainfuck;

import java.util.ArrayList;
import java.util.List;

public class OptimizationVisitor implements CommandVisitor {

    private final List<Command> optimizedCommands = new ArrayList();

    private void optimization(Command currentCommand) {
        if (optimizedCommands.isEmpty())
            optimizedCommands.add(currentCommand);
        else if (optimizedCommands.get(optimizedCommands.size() - 1).getClass() == currentCommand.getClass())
            optimizedCommands.get(optimizedCommands.size() - 1).addRepeat();
        else optimizedCommands.add(currentCommand);
    }

    private void optimizationLoop(Command currentCommand, List<Command> temp) {
        if (temp.isEmpty())
            temp.add(currentCommand);
        else if (temp.get(temp.size() - 1).getClass() == currentCommand.getClass())
            temp.get(temp.size() - 1).addRepeat();
        else temp.add(currentCommand);
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
        List<Command> temp = new ArrayList<Command>();
        for (Command innerCommand : command.getInnerCommands()) {
            if (innerCommand.getClass() == LoopCommand.class)
                optimizationLoop(loopOptimization((LoopCommand) innerCommand), temp);
            else
                optimizationLoop(innerCommand, temp);
        }
        command = new LoopCommand(temp);
        optimizedCommands.add(command);
    }

    private LoopCommand loopOptimization(LoopCommand loopCommand) {
        List<Command> temp = new ArrayList<Command>();
        for (Command innerCommand : loopCommand.getInnerCommands()) {
            optimizationLoop(innerCommand, temp);
        }
        loopCommand = new LoopCommand(temp);
        return loopCommand;
    }
}
