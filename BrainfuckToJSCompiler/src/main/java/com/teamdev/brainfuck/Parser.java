package com.teamdev.brainfuck;

import java.util.*;

public class Parser {

    public List<Command> parse(String program) {

        final Deque<List<Command>> stack = new ArrayDeque();
        stack.push(new ArrayList());

        for (char c : program.toCharArray()) {

            switch (c) {
                case '>': {
                    stack.peek().add(new MoveForwardCommand());
                    break;
                }
                case '<': {
                    stack.peek().add(new MoveBackwardCommand());
                    break;
                }
                case '+': {
                    stack.peek().add(new IncrementCommand());
                    break;
                }
                case '-': {
                    stack.peek().add(new DecrementCommand());
                    break;
                }
                case '.': {
                    stack.peek().add(new PrintCommand());
                    break;
                }
                case '[': {
                    stack.push(new ArrayList());
                    break;
                }
                case ']': {

                    if (stack.size() < 2) {
                        throw new IllegalStateException("Unexpected right parenthesis.");
                    }

                    final LoopCommand loop = new LoopCommand(stack.pop());
                    stack.peek().add(loop);
                    break;
                }
                case ' ': {
                    break;
                }
                default:
                    throw new IllegalArgumentException("Unknown command: " + c);

            }

        }

        if (stack.size() > 1) {
            throw new IllegalStateException("There are loops that are not closed.");
        }

        return stack.pop();
    }

}
