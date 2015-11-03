package com.teamdev.brainfuck;


import java.util.List;

public class LoopCommand implements Command {

    public void addRepeat() {

    }

    private final List<Command> innerCommands;

    public LoopCommand(List<Command> innerCommands) {
        this.innerCommands = innerCommands;
    }

    public List<Command> getInnerCommands() {
        return innerCommands;
    }

    public void accept(CommandVisitor visitor) {
        visitor.visit(this);
    }

}
