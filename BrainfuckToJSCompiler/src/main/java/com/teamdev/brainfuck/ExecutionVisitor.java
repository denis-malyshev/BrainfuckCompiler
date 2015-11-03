package com.teamdev.brainfuck;

public class ExecutionVisitor implements CommandVisitor {


    final private ExecutionContext context = new ExecutionContext();


    public void visit(MoveForwardCommand command) {
        context.movePointerForward(command.getRepeatCounts());
    }


    public void visit(MoveBackwardCommand command) {
        context.movePointerBackward(command.getRepeatCounts());
    }


    public void visit(IncrementCommand command) {
        context.incrementCurrentValue(command.getRepeatCounts());
    }


    public void visit(DecrementCommand command) {
        context.decrementCurrentValue(command.getRepeatCounts());
    }


    public void visit(PrintCommand command) {
        for (int i = 0; i < command.getRepeatCounts(); i++) {
            System.out.print((char) context.getCurrentValue());
        }
    }


    public void visit(LoopCommand command) {
        while (context.getCurrentValue() != 0) {
            for (Command innerCommand : command.getInnerCommands()) {
                innerCommand.accept(this);
            }
        }
    }
}
