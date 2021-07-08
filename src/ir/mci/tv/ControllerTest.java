package ir.mci.tv;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ControllerTest {

    Control control;

    @Before
    public void runBeforeTests() {
        control = new Control();
    }

    @Test
    public void testDefaultState() {
        assertEquals(0, control.getState().getVolume());
        assertEquals(0, State.DEFAULT_STATE.getVolume());
    }

    @Test
    public void testIncrement() {
        control.dispatch(new Action("inc_volume", null));
        assertEquals(1, control.getState().getVolume());

        control.dispatch(new Action("inc_volume", null));
        assertEquals(2, control.getState().getVolume());
    }

    @Test
    public void testDecrement() {
        control.dispatch(new Action("inc_volume", null));
        assertEquals(1, control.getState().getVolume());

        control.dispatch(new Action("dec_volume", null));
        assertEquals(0, control.getState().getVolume());
    }

    @Test
    public void testNormalSet() {
        control.dispatch(new Action("set_volume", 15));
        assertEquals(15, control.getState().getVolume());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialSet1() {
        control.dispatch(new Action("set_volume", -1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSpecialSet2() {
        control.dispatch(new Action("set_volume", 101));
    }

    @Test
    public void testStateRef() {
        State initial = control.getState();

        control.dispatch(new Action("inc_volume", null));
        assertNotSame(initial, control.getState());
        assertNotEquals(initial, control.getState());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalActionType() {
        control.dispatch(new Action("bad action", 0));
    }

    @Test
    public void testIncrementToHundred() {
        for (int i = 0; i < 101; i++) {
            assertEquals(i, control.getState().getVolume());
            control.dispatch(new Action("inc_volume", null));
        }
        assertEquals(100, control.getState().getVolume());
    }

    @Test
    public void testDecrementToZero() {
        control.dispatch(new Action("dec_volume", null));
        assertEquals(0, control.getState().getVolume());

        control.dispatch(new Action("set_volume", 40));
        for (int i = 0; i < 45; i++) {
            control.dispatch(new Action("dec_volume", null));
        }

        assertEquals(0, control.getState().getVolume());
    }

    @Test
    public void testNullAction(){
        control.dispatch(new Action("set_volume", 7));

        control.dispatch(null);
        assertEquals(0, control.getState().getVolume());
    }

    @Test
    public void testControlConstrcutor(){
        State state = new State(39);
        Control control = new Control(state);
        assertEquals(39, control.getState().getVolume());
    }


}
