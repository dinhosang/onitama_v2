package helpersTest;

import constants.GameMode;
import constants.PieceFaction;
import helpers.factories.ConcurrentPieceFactory;
import models.pieces.*;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class ConcurrentPieceFactoryTest {

    private ConcurrentPieceFactory factoryNC;
    private HashMap<PieceFaction, ArrayList<Piece>> piecesContainer;

    @Before
    public void before() {
        piecesContainer = new HashMap<>();
        piecesContainer.put(PieceFaction.BLUE, new ArrayList<>());
        piecesContainer.put(PieceFaction.RED, new ArrayList<>());

        factoryNC = new ConcurrentPieceFactory();
        factoryNC.setFactory(GameMode.STANDARD, piecesContainer);
    }

    @Test
    public void consoleLogTimeTakenToProcess10KRequestsOver10AttemptsOf1K(){
        factoryNC.setFactory(GameMode.TESTSTANDARD, piecesContainer);

        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();

        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();
        factoryNC.createPieces();

        assertEquals(50000, piecesContainer.get(PieceFaction.BLUE).size());
    }

    @Test
    public void piecesContainerStartsEmpty(){
        assertEquals(0, piecesContainer.get(PieceFaction.BLUE).size());
    }

    @Test
    public void canFillPiecesContainerWithBluePieces(){
        factoryNC.createPieces();

        assertEquals(5, piecesContainer.get(PieceFaction.BLUE).size());
    }

    @Test
    public void canFillPiecesContainerWithRedPieces(){
        factoryNC.createPieces();

        assertEquals(5, piecesContainer.get(PieceFaction.RED).size());
    }

    @Test
    public void createsFourBlueStudents(){
        factoryNC.createPieces();

        ArrayList<Piece> bluePieces = piecesContainer.get(PieceFaction.BLUE);
        int numberOfStudents = 0;

        for(Piece piece : bluePieces){
            if(piece instanceof BlueStudent){
                numberOfStudents += 1;
            }
        }

        assertEquals(4, numberOfStudents);
    }

    @Test
    public void createsOneBlueSensei(){
        factoryNC.createPieces();

        ArrayList<Piece> bluePieces = piecesContainer.get(PieceFaction.BLUE);
        int numberOfSensei = 0;

        for(Piece piece : bluePieces){
            if(piece instanceof BlueSensei){
                numberOfSensei += 1;
            }
        }

        assertEquals(1, numberOfSensei);
    }

    @Test
    public void createsFourRedStudents(){
        factoryNC.createPieces();

        ArrayList<Piece> redPieces = piecesContainer.get(PieceFaction.RED);
        int numberOfStudents = 0;

        for(Piece piece : redPieces){
            if(piece instanceof RedStudent){
                numberOfStudents += 1;
            }
        }

        assertEquals(4, numberOfStudents);
    }

    @Test
    public void createsOneRedSensei(){
        factoryNC.createPieces();

        ArrayList<Piece> redPieces = piecesContainer.get(PieceFaction.RED);
        int numberOfSensei = 0;

        for(Piece piece : redPieces){
            if(piece instanceof RedSensei){
                numberOfSensei += 1;
            }
        }

        assertEquals(1, numberOfSensei);
    }


}
