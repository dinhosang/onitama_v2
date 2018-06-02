package helpersTest;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;

import helpers.IContain;
import helpers.IHeld;
import helpers.factories.StaticPieceFactory;

import models.pieces.*;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class StaticPieceFactoryTest {


    private IContain mockPieceContainer;
    private IContain secondMockPieceContainer;
    private ArrayList<Piece> allPieces;

    @Before
    public void before() {

        class MockPieceContainer implements IContain {

            private ArrayList<IHeld> items;

            private MockPieceContainer(){
                this.items = new ArrayList<>();
            }

            @Override
            public void addItem(IHeld item) {
                items.add(item);
            }

            public int getSize() {
                return items.size();
            }

            public IHeld getItem() throws IndexOutOfBoundsException {
                try {
                    return this.items.remove(0);
                } catch (IndexOutOfBoundsException e) {
                    throw e;
                }

            }
        }

        this.mockPieceContainer         = new MockPieceContainer();
        this.secondMockPieceContainer   = new MockPieceContainer();

        StaticPieceFactory.createItems(GameMode.STANDARD, this.mockPieceContainer);

        this.allPieces = new ArrayList<>();
        int numberOfPiecesGrabbed = 0;

        while(numberOfPiecesGrabbed < 10) {
            allPieces.add((Piece) this.mockPieceContainer.getItem());
            numberOfPiecesGrabbed++;
        }
    }

    @Test
    public void willFillPiecesContainerWith10PiecesInStandardMode() {
        StaticPieceFactory.createItems(GameMode.STANDARD, this.secondMockPieceContainer);
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
    public void consoleLogTimeTakenToProcess10KRequestsOver10AttemptsOf1K(){
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);

        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);
        StaticPieceFactory.createItems(GameMode.TESTSTANDARD, this.secondMockPieceContainer);


        assertEquals(100000, this.secondMockPieceContainer.getSize());
    }
}
