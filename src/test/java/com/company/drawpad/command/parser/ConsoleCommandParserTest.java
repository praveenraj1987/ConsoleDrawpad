package com.company.drawpad.command.parser;


import com.company.drawpad.Console;
import com.company.drawpad.command.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ConsoleCommandParserTest {

    @Test
    public void readCommand_should_return_Create_command_after_reading_create_command_string_from_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        ConsoleCommandParser csp = new ConsoleCommandParser(mockConsole);
        when(mockConsole.readLine()).thenReturn("C 4 5");

        final Command command = csp.ReadCommand();

        assertEquals(command.getClass(), Create.class);
    }

    @Test
    public void readCommand_should_return_Line_command_after_reading_line_command_string_from_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        ConsoleCommandParser csp = new ConsoleCommandParser(mockConsole);
        when(mockConsole.readLine()).thenReturn("L 4 5 5 7");

        final Command command = csp.ReadCommand();

        assertEquals(command.getClass(), Line.class);
    }

    @Test
    public void readCommand_should_return_Rectanlge_command_after_reading_rectangle_command_string_from_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        ConsoleCommandParser csp = new ConsoleCommandParser(mockConsole);
        when(mockConsole.readLine()).thenReturn("R 4 5 5 7");

        final Command command = csp.ReadCommand();

        assertEquals(command.getClass(), Rectangle.class);
    }

    @Test
    public void readCommand_should_return_Quit_command_after_reading_quit_command_string_from_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        ConsoleCommandParser csp = new ConsoleCommandParser(mockConsole);
        when(mockConsole.readLine()).thenReturn("Q");

        final Command command = csp.ReadCommand();

        assertEquals(command.getClass(), Quit.class);
    }


    @Test
    public void readCommand_should_return_NotSupported_command_after_reading_NotSupported_command_string_from_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        ConsoleCommandParser csp = new ConsoleCommandParser(mockConsole);
        when(mockConsole.readLine()).thenReturn("NotSUpported");

        final Command command = csp.ReadCommand();

        assertEquals(command.getClass(), NotSupported.class);
    }
}