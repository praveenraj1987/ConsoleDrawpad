package com.company.drawpad.command.executor;

import com.company.drawpad.Canvas;
import com.company.drawpad.command.Command;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class CommandExecutorTest {

    @Test
    public void execute_should_call_ececuteOn_command_with_canvas_as_param() {
        CommandExecutor ce = new CommandExecutor();
        final Command mockCommand = Mockito.mock(Command.class);
        final Canvas mockCanvas = Mockito.mock(Canvas.class);

        ce.execute(mockCommand, mockCanvas);

        verify(mockCommand, times(1)).executeOn(mockCanvas);
    }
}