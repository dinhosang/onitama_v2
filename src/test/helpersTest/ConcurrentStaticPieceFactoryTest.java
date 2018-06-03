package helpersTest;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;

import helpers.IContain;
import helpers.IHeld;
import helpers.factories.ConcurrentStaticPieceFactory;

import models.pieces.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


import static org.junit.Assert.assertEquals;

public class ConcurrentStaticPieceFactoryTest {

    private IContain secondMockPieceContainer;
    private ArrayList<Piece> allPieces;

    @Before
    public void before() {

        class MockPieceContainer implements IContain {

            private ArrayList<IHeld> pieces;

            private MockPieceContainer(){
                this.pieces = new ArrayList<>();
            }

            @Override
            public void addItem(IHeld item) {
                pieces.add(item);
            }

            public int getSize() {
                return pieces.size();
            }

            public IHeld getItem() throws IndexOutOfBoundsException {
                try {
                    return this.pieces.remove(0);
                } catch (IndexOutOfBoundsException e) {
                    throw e;
                }

            }
        }

        IContain mockPieceContainer     = new MockPieceContainer();
        this.secondMockPieceContainer   = new MockPieceContainer();

        ConcurrentStaticPieceFactory.createItems(GameMode.STANDARD, mockPieceContainer);

        this.allPieces = new ArrayList<>();
        int numberOfPiecesGrabbed = 0;

        while(numberOfPiecesGrabbed < 10) {
            allPieces.add((Piece) mockPieceContainer.getItem());
            numberOfPiecesGrabbed++;
        }
    }

    @Test
    public void willFillPiecesContainerWith10PiecesInStandardMode() {
        ConcurrentStaticPieceFactory.createItems(GameMode.STANDARD, this.secondMockPieceContainer);
        assertEquals(10, this.secondMockPieceContainer.getSize());
    }


    @Test
    public void willFillPiecesContainerWith5BluePiecesInStandardMode(){
        int numberOfBluePieces = 0;

        for(Piece piece : this.allPieces) {
            if(piece.getFaction().equals(PieceFaction.BLUE)) {
                numberOfBluePieces++;
            }
        }

        assertEquals(5, numberOfBluePieces);
    }

    @Test
    public void willFillPiecesContainerWith5RedPiecesInStandardMode(){
        int numberOfRedPieces = 0;

        for(Piece piece : allPieces) {
            if(piece.getFaction().equals(PieceFaction.RED)) {
                numberOfRedPieces++;
            }
        }

        assertEquals(5, numberOfRedPieces);
    }

    @Test
    public void willCreateFourBlueStudents(){
        int numberOfBlueStudents = 0;

        for(Piece piece : allPieces) {
            if(piece.getFaction().equals(PieceFaction.BLUE) && piece.getType().equals(PieceType.STUDENT)) {
                numberOfBlueStudents++;
            }
        }

        assertEquals(4, numberOfBlueStudents);
    }

    @Test
    public void willCreateOneBlueSensei(){
        int numberOfBlueSensei = 0;

        for(Piece piece : allPieces) {
            if(piece.getFaction().equals(PieceFaction.BLUE) && piece.getType().equals(PieceType.SENSEI)) {
                numberOfBlueSensei++;
            }
        }

        assertEquals(1, numberOfBlueSensei);
    }

    @Test
    public void willCreateFourRedStudents(){
        int numberOfRedStudents = 0;

        for(Piece piece : allPieces) {
            if(piece.getFaction().equals(PieceFaction.RED) && piece.getType().equals(PieceType.STUDENT)) {
                numberOfRedStudents++;
            }
        }

        assertEquals(4, numberOfRedStudents);
    }

    @Test
    public void willCreateOneRedSensei(){
        int numberOfRedSensei = 0;

        for(Piece piece : allPieces) {
            if(piece.getFaction().equals(PieceFaction.RED) && piece.getType().equals(PieceType.SENSEI)) {
                numberOfRedSensei++;
            }
        }

        assertEquals(1, numberOfRedSensei);
    }

    @Test
    public void consoleLogTimeTakenToProcess12KRequestsOver12AttemptsOf1K(){

        System.out.println("--- Concurrent Static Piece Factory - 120K Pieces");

        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);

        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);

        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        ConcurrentStaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);


        assertEquals(120000, this.secondMockPieceContainer.getSize());
    }


}
