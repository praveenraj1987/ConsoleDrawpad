package com.company.drawpad.command.builder;

import com.company.drawpad.command.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class CommandBuilderTest {


    @Test
    public void buildShouldReturnCreateCommandForCreateTypeWithCorrectParams() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('C');
        cb.addParams(new String[]{"4","4"});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), Create.class);
    }

    @Test
    public void build_should_return_Line_command_for_L_type_with_4_params() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('L');
        cb.addParams(new String[]{"4","4", "3", "10"});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), Line.class);
    }

    @Test
    public void build_should_return_Rectangle_command_for_R_type_with_4_params() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('R');
        cb.addParams(new String[]{"4","4", "3", "10"});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), Rectangle.class);
    }

    @Test
    public void build_should_return_BucketFill_command_for_B_type_with_3_params() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('B');
        cb.addParams(new String[]{"4","4", "k"});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), BucketFill.class);
    }

    @Test
    public void build_should_return_Quit_command_for_Q_type_with_0_params() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('Q');
        cb.addParams(new String[]{});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), Quit.class);
    }

    @Test
    public void build_should_return_NotSupported_command_for_invalid_types() {
        CommandBuilder cb = new CommandBuilder();
        cb.addCommandType('z');
        cb.addParams(new String[]{"4","4"});

        final Command commandTest = cb.build();

        assertEquals(commandTest.getClass(), NotSupported.class);
    }

}