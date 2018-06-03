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

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentStaticPieceFactory implements ICreate {

    public static void createItems(GameMode mode, IContain piecesContainer) {


        ExecutorService threadPool = Executors.newCachedThreadPool();
        ReentrantLock lock = new ReentrantLock();

        class ConcurrentPiecesCreator implements Runnable {

            private IContain        piecesContainer;
            private ReentrantLock   lock;

            private ConcurrentPiecesCreator(IContain piecesContainer, ReentrantLock lock) {
                this.lock               = lock;
                this.piecesContainer    = piecesContainer;
            }

            public void run(){

                setupStandardModePiecesCreation(piecesContainer, lock);
            }
        }

        if(mode.equals(GameMode.STANDARD)) {

            ConcurrentPiecesCreator piecesCreator = new ConcurrentPiecesCreator(piecesContainer, lock);

            threadPool.execute(piecesCreator);

            awaitThreadPoolCompletion(threadPool);
        } else if (mode.equals(GameMode.TESTSTANDARD)) {

            long startTime = System.currentTimeMillis();

            for(int timesTested = 0; timesTested < 1000; timesTested++) {
                ConcurrentPiecesCreator piecesCreator = new ConcurrentPiecesCreator(piecesContainer, lock);
                threadPool.execute(piecesCreator);
            }

            awaitThreadPoolCompletion(threadPool);

            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");
        } else {
            //            could try throwing a homemade exception for incorrect game mode?
        }

    }

    private static void awaitThreadPoolCompletion(ExecutorService threadPool) {

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static void setupStandardModePiecesCreation(IContain piecesContainer, ReentrantLock lock) {

        PieceFaction[] factions = {PieceFaction.RED, PieceFaction.BLUE};

        lock.lock();

        for(PieceFaction faction: factions) {

            for (int piecesCreated = 0; piecesCreated < 5; piecesCreated++) {

                if (piecesCreated != 2) {
                    createPiece(piecesContainer, faction, PieceType.STUDENT);
                } else {
                    createPiece(piecesContainer, faction, PieceType.SENSEI);
                }
            }
        }

        lock.unlock();
    }

    private static void createPiece(IContain piecesContainer, PieceFaction faction, PieceType type) {

        Piece piece;

        if(faction.equals(PieceFaction.RED)){
            switch(type){
                case STUDENT:
                    piece = new RedStudent();
                    piecesContainer.addItem(piece);
                    break;
                case SENSEI:
                    piece = new RedSensei();
                    piecesContainer.addItem(piece);
                    break;
                default:
                    System.out.println("Invalid type");
                    break;
            }
        } else if (faction.equals(PieceFaction.BLUE)) {
            switch (type) {
                case STUDENT:
                    piece = new BlueStudent();
                    piecesContainer.addItem(piece);
                    break;
                case SENSEI:
                    piece = new BlueSensei();
                    piecesContainer.addItem(piece);
                    break;
                default:
                    System.out.println("Invalid type");
                    break;
            }
        }
    }



}
