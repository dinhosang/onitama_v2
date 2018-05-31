package modelsTest.piecesTest;

import constants.PieceFaction;
import constants.PieceType;
import models.pieces.BlueSensei;
import models.pieces.BlueStudent;
import models.pieces.RedSensei;
import models.pieces.RedStudent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PieceSubClassesTest {

    RedSensei   rSensei;
    RedStudent  rStudent;
    BlueSensei  bSensei;
    BlueStudent bStudent;

    @Before
    public void before() {

        rSensei     = new RedSensei();
        rStudent    = new RedStudent();
        bSensei     = new BlueSensei();
        bStudent    = new BlueStudent();
    }

    @Test
    public void redSenseiIsMemberOfRedFaction() {
        assertEquals(PieceFaction.RED, rSensei.getFaction());
    }

    @Test
    public void redSenseiIsTypeSensei() {
        assertEquals(PieceType.SENSEI, rSensei.getType());
    }

    @Test
    public void redSenseiIsNotBlueAndNotStudent() {
        assertNotEquals(PieceFaction.BLUE, rSensei.getFaction());
        assertNotEquals(PieceType.STUDENT, rSensei.getType());
    }

    @Test
    public void redStudentIsMemberOfRedFaction() {
        assertEquals(PieceFaction.RED, rStudent.getFaction());
    }

    @Test
    public void redStudentIsTypeStudent() {
        assertEquals(PieceType.STUDENT, rStudent.getType());
    }

    @Test
    public void redStudentIsNotBlueAndNotSensei() {
        assertNotEquals(PieceFaction.BLUE, rStudent.getFaction());
        assertNotEquals(PieceType.SENSEI, rStudent.getType());
    }

    @Test
    public void blueSenseiIsMemberOfBlueFaction() {
        assertEquals(PieceFaction.BLUE, bSensei.getFaction());
    }

    @Test
    public void blueSenseiIsTypeSensei() {
        assertEquals(PieceType.SENSEI, bSensei.getType());
    }

    @Test
    public void blueSenseiIsNotRedAndNotStudent() {
        assertNotEquals(PieceFaction.RED, bSensei.getFaction());
        assertNotEquals(PieceType.STUDENT, bSensei.getType());
    }

    @Test
    public void blueStudentIsMemberOfBlueFaction() {
        assertEquals(PieceFaction.BLUE, bStudent.getFaction());
    }

    @Test
    public void blueStudentIsTypeStudent() {
        assertEquals(PieceType.STUDENT, bStudent.getType());
    }

    @Test
    public void blueStudentIsNotRedAndNotSensei() {
        assertNotEquals(PieceFaction.RED, bStudent.getFaction());
        assertNotEquals(PieceType.SENSEI, bStudent.getType());
    }


}
