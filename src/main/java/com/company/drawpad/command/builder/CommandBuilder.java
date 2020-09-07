package com.company.drawpad.command.builder;

import com.company.drawpad.command.*;

import java.util.ArrayList;
import java.util.List;

public class CommandBuilder {
    Command command = new NotSupported();
    char type;
    List<Integer> params;

    public CommandBuilder() {
        params = new ArrayList<>();
    }

    public void addCommandType(char type) {
        this.type = type;
    }

    public void addParams(String[] commandArguments) {
        params.clear();
        switch (type) {
            case 'C':
                if (commandArguments.length != 2) return;
                params.add(Integer.parseInt(commandArguments[0]));
                params.add(Integer.parseInt(commandArguments[1]));
                break;
            case 'L':
            case 'R':
                if (commandArguments.length != 4) return;
                params.add(Integer.parseInt(commandArguments[0]));
                params.add(Integer.parseInt(commandArguments[1]));
                params.add(Integer.parseInt(commandArguments[2]));
                params.add(Integer.parseInt(commandArguments[3]));
                break;
            case 'B':
                if (commandArguments.length != 3) return;
                params.add(Integer.parseInt(commandArguments[0]));
                params.add(Integer.parseInt(commandArguments[1]));
                params.add((int)commandArguments[2].toCharArray()[0]);
                break;
            default:
                break;
        }
    }

    public Command build() {
        command = new NotSupported();
        switch (type) {
            case 'C':
                if (params.size() == 2) command = new Create(params.get(0), params.get(1));
                break;
            case 'L':
                if (params.size() == 4) command = new Line(params.get(0), params.get(1), params.get(2), params.get(3));
                break;
            case 'R':
                if (params.size() == 4)
                    command = new Rectangle(params.get(0), params.get(1), params.get(2), params.get(3));
                break;
            case 'B':
                if (params.size() == 3) command = new BucketFill(params.get(0), params.get(1), params.get(2));
                break;
            case 'Q':
                if (params.size() == 0) command = new Quit();
                break;
            default:
                command = new NotSupported();
                break;
        }
        return command;

    }
}
