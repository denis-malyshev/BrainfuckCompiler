package com.teamdev.brainfuck;

public class ExecutionVisitor implements CommandVisitor {


    final private ExecutionContext context = new ExecutionContext();

    public void visit(MoveForwardCommand command) {
        context.movePointerForward();
    }

    public void visit(MoveBackwardCommand command) {
        context.movePointerBackward();
    }

    public void visit(IncrementCommand command) {
        context.incrementCurrentValue();
    }

    public void visit(DecrementCommand command) {
        context.decrementCurrentValue();
    }

    public void visit(PrintCommand command) {
        System.out.print((char) context.getCurrentValue());
    }

    public void visit(LoopCommand command) {
        while (context.getCurrentValue() != 0) {
            for (Command innerCommand : command.getInnerCommands()) {
                innerCommand.accept(this);
            }
        }
    }

    public void visit(OptimizedCommand command) {
        for (int i = 0; i < command.getCounts(); i++) {
            command.getOptimizedCommand().accept(this);
        }
    }

}
