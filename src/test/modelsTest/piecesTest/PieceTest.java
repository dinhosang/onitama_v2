package modelsTest.piecesTest;

import constants.PieceFaction;
import constants.PieceType;
import models.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PieceTest {

    private Piece redStudent;

    @Before
    public void before(){

        class mockRedStudent extends Piece {
            private mockRedStudent(){
                super(PieceFaction.RED, PieceType.STUDENT);
            }
        }

        redStudent = new mockRedStudent();
    }

    @Test
    public void canGetPieceFactionValue(){
        assertEquals(PieceFaction.RED, redStudent.getFaction());
    }

    @Test
    public void canGetPieceTypeValue(){
        assertEquals(PieceType.STUDENT, redStudent.getType());
    }



}
