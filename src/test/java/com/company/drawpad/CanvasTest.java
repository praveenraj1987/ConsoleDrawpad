package com.company.drawpad;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class CanvasTest {

    @Test
    public void quitting_should_return_true_if_canvas_quit_is_called() {
        Canvas cv = new Canvas();
        cv.quit();

        final boolean quitting = cv.quitting();

        assertEquals(quitting, true);
    }

    @Test
    public void quitting_should_return_false_if_canvas_quit_is_not_called() {
        Canvas cv = new Canvas();

        final boolean quitting = cv.quitting();

        assertEquals(quitting, false);
    }


    @Test
    public void create_should_initialize_the_canvasArea_and_draw_boundaries_as_transpose_of_matrix_to_have_xy_input_map_memory() {
        Canvas c = new Canvas();

        c.create(1, 1);

        assertEquals(c.width, 1);
        assertEquals(c.height, 1);
        assertNotNull(c.canvasArea);
        assertEquals(Arrays.equals(c.canvasArea[0], new int[]{'-', '|', '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[1], new int[]{'-', 0, '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[2], new int[]{'-', '|', '-'}), true);
    }
//
//    @Test
//    void clear() {
//    }

    @Test
    public void line_should_draw_horizontal_line_on_canvasarea_with_x_char_if_y_coordinates_are_same() {
        Canvas c = new Canvas();
        c.create(4, 3);

        c.line(1, 1, 3, 1);
        c.display();

        assertEquals(c.canvasArea[1][1], 'x');
        assertEquals(c.canvasArea[2][1], 'x');
        assertEquals(c.canvasArea[3][1], 'x');
    }

    @Test
    public void line_should_draw_vertical_line_on_canvasarea_with_x_char_if_x_coordinates_are_same() {
        Canvas c = new Canvas();
        c.create(4, 3);

        c.line(1, 1, 1, 3);
        c.display();

        assertEquals(Arrays.equals(c.canvasArea[1], new int[]{'-', 'x', 'x', 'x', '-'}), true);

    }

    @Test
    public void rectangle() {
        Canvas c = new Canvas();
        c.create(4, 3);

        c.rectangle(1, 1, 2, 2);
        c.display();

        assertEquals(Arrays.equals(c.canvasArea[1], new int[]{'-', 'x', 'x', 0, '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[2], new int[]{'-', 'x', 'x', 0, '-'}), true);
    }

    @Test
    public void bucketFill() {
        Canvas c = new Canvas();
        c.create(4, 4);

        c.rectangle(1, 1, 4, 4);
        c.bucketFill(3,3, 'o');
        c.display();

        assertEquals(Arrays.equals(c.canvasArea[1], new int[]{'-', 'x', 'x', 'x', 'x', '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[2], new int[]{'-', 'x', 'o', 'o', 'x', '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[3], new int[]{'-', 'x', 'o', 'o', 'x', '-'}), true);
        assertEquals(Arrays.equals(c.canvasArea[4], new int[]{'-', 'x', 'x', 'x', 'x', '-'}), true);
    }

    @Test
    public void print_should_print_the_message_to_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        Canvas c = new Canvas(mockConsole);

        final String some_msg = "Some msg";
        c.print(some_msg);

        verify(mockConsole, times(1)).println(some_msg);
    }

    @Test
    public void display_should_print_canvasarea_content_to_console() {
        final Console mockConsole = Mockito.mock(Console.class);
        Canvas c = new Canvas(mockConsole);
        c.create(2, 2);
        c.display();

        verify(mockConsole, times(16)).print(anyChar());
        verify(mockConsole, times(4)).println(anyString());
    }
}