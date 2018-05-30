package factoriesTest;

import constants.GameMode;
import constants.PieceFaction;
import factories.NonConcurrentPieceFactory;
import models.pieces.Piece;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;

public class NonConcurrentPieceFactoryTest {

    private NonConcurrentPieceFactory factoryNC;
    private HashMap<PieceFaction, ArrayList<Piece>> piecesContainer;

    @Before
    public void before() {
        piecesContainer = new HashMap<>();
        piecesContainer.put(PieceFaction.BLUE, new ArrayList<>());
        piecesContainer.put(PieceFaction.RED, new ArrayList<>());

        factoryNC = new NonConcurrentPieceFactory();
    }

    @Test
    public void piecesContainerStartsEmpty(){
        assertEquals(0, piecesContainer.get(PieceFaction.BLUE).size());
    }

    @Test
    public void canFillPiecesContainerWithBluePieces(){

        factoryNC.setFactory(GameMode.STANDARD, piecesContainer);
        factoryNC.createPieces();

        assertEquals(5, piecesContainer.get(PieceFaction.BLUE).size());
    }

    @Test
    public void canFillPiecesContainerWithRedPieces(){

        factoryNC.setFactory(GameMode.STANDARD, piecesContainer);
        factoryNC.createPieces();

        assertEquals(5, piecesContainer.get(PieceFaction.RED).size());
    }

}
