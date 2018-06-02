package helpers.factories;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;

import helpers.IContain;
import helpers.ICreate;

import models.pieces.*;
import models.pieces.individualPieces.BlueSensei;
import models.pieces.individualPieces.BlueStudent;
import models.pieces.individualPieces.RedSensei;
import models.pieces.individualPieces.RedStudent;


public class StaticPieceFactory implements ICreate {

    public static void createItems(GameMode mode, IContain pieceBox) {

        if(mode.equals(GameMode.STANDARD)){
            setupStandardModePieceCreation(pieceBox);
        } else if (mode.equals(GameMode.TESTSTANDARD)){
            long startTime    = System.currentTimeMillis();

            for(int numberOfSetsMade = 0; numberOfSetsMade < 1000; numberOfSetsMade++){
                setupStandardModePieceCreation(pieceBox);
            }

            long endTime      = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
        } else {
            // throw exception here?
        }
    }

    private static void setupStandardModePieceCreation(IContain pieceBox) {

        Piece piece;

        for(int numberOfPiecesMade = 0; numberOfPiecesMade < 5; numberOfPiecesMade++) {
            if(numberOfPiecesMade == 2){
                piece = createPiece(PieceFaction.RED, PieceType.SENSEI);
            } else {
                piece = createPiece(PieceFaction.RED, PieceType.STUDENT);
            }

            pieceBox.addItem(piece);
        }

        for(int numberOfPiecesMade = 0; numberOfPiecesMade < 5; numberOfPiecesMade++) {
            if(numberOfPiecesMade == 2){
                piece = createPiece(PieceFaction.BLUE, PieceType.SENSEI);
            } else {
                piece = createPiece(PieceFaction.BLUE, PieceType.STUDENT);
            }

            pieceBox.addItem(piece);
        }
    }

    private static Piece createPiece(PieceFaction faction, PieceType type) {

        Piece piece;

        if(faction.equals(PieceFaction.RED)){
            switch(type){
                case STUDENT:
                    piece = new RedStudent();
                    break;
                default:
                    piece = new RedSensei();
                    break;
            }
        } else {
            switch (type) {
                case STUDENT:
                    piece = new BlueStudent();
                    break;
                default:
                    piece = new BlueSensei();
                    break;
            }
        }

        return piece;
    }



}
