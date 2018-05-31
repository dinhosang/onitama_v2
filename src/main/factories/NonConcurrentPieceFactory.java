package factories;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;
import models.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class NonConcurrentPieceFactory {

    private GameMode mode;
    private HashMap<PieceFaction,ArrayList<Piece>> piecesContainer;

    public NonConcurrentPieceFactory(){}

    public void setFactory(GameMode mode, HashMap<PieceFaction,ArrayList<Piece>> piecesContainer) {
        this.mode           = mode;
        this.piecesContainer = piecesContainer;
    }

    public void createPieces() {

        if(this.mode == GameMode.STANDARD) {
            setupStandardModePieceCreation();
        } else if (this.mode == GameMode.TESTSTANDARD) {
            long startTime = System.currentTimeMillis();
//            long startTime = System.nanoTime();

            for(int timesTested = 0; timesTested < 1000; timesTested++) {
                setupStandardModePieceCreation();

//                Set<PieceFaction> keys = this.piecesContainer.keySet();
//                for(PieceFaction faction : keys) {
//                    this.piecesContainer.get(faction).clear();
//                }
            }

            long endTime = System.currentTimeMillis();
//            long endTime = System.nanoTime();

            System.out.println(endTime - startTime + "ms");

        } else {
            //            could try throwing a homemade exception for incorrect game mode?
        }
    }

    private void setupStandardModePieceCreation() {
        Set<PieceFaction> keys = this.piecesContainer.keySet();

        for(PieceFaction faction : keys){
            HashMap<PieceType, Integer> piecesRequired = new HashMap<>();
            piecesRequired.put(PieceType.STUDENT, 4);
            piecesRequired.put(PieceType.SENSEI, 1);

            beginCreateProcess(faction, piecesRequired);
        }
    }

    private void beginCreateProcess(PieceFaction faction, HashMap<PieceType, Integer> piecesRequired) {
        Set<PieceType> keys = piecesRequired.keySet();

        for(PieceType type : keys) {
            int numberRequired = piecesRequired.get(type);
//            Could have a try statement in case the number is a great deal larger, in case of a memory error etc.
//            Currently only standard mode so not required.
            for(int numberMade = 0; numberMade < numberRequired; numberMade++){
                createSinglePiece(faction, type);
            }
        }
    }

    private void createSinglePiece(PieceFaction faction, PieceType type) {

        Piece piece;

        if(faction == PieceFaction.RED){
            switch(type){
                case STUDENT:
                    piece = new RedStudent();
                    this.piecesContainer.get(faction).add(piece);
                    break;
                case SENSEI:
                    piece = new RedSensei();
                    this.piecesContainer.get(faction).add(piece);
                    break;
                default:
                    System.out.println("Invalid type");
                    break;
            }
        } else if (faction == PieceFaction.BLUE) {
            switch (type) {
                case STUDENT:
                    piece = new BlueStudent();
                    this.piecesContainer.get(faction).add(piece);
                    break;
                case SENSEI:
                    piece = new BlueSensei();
                    this.piecesContainer.get(faction).add(piece);
                    break;
                default:
                    System.out.println("Invalid type");
                    break;
            }
        }
    }



}
