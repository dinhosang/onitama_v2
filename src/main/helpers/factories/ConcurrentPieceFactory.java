package helpers.factories;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;
import models.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ConcurrentPieceFactory {

    private GameMode        mode;
    private ReentrantLock   lock;
    private HashMap<PieceFaction,ArrayList<Piece>> piecesContainer;

    public ConcurrentPieceFactory(){}

    public void setFactory(GameMode mode, HashMap<PieceFaction,ArrayList<Piece>> piecesContainer) {
        this.mode               = mode;
        this.piecesContainer    = piecesContainer;
        this.lock               = new ReentrantLock();
    }

    public void createPieces() {

        if(this.mode.equals(GameMode.STANDARD)) {
            setupStandardModePieceCreation();
        } else if (this.mode.equals(GameMode.TESTSTANDARD)) {
            long startTime = System.currentTimeMillis();

            for(int timesTested = 0; timesTested < 1000; timesTested++) {
                setupStandardModePieceCreation();
            }

            long endTime = System.currentTimeMillis();
            System.out.println(endTime - startTime + "ms");

        } else {
            //            could try throwing a homemade exception for incorrect game mode?
        }
    }

    private void setupStandardModePieceCreation() {
        Set<PieceFaction> keys          = this.piecesContainer.keySet();
        // CachedThreadPool has similar logged times to FixedThreadPool(3)
        // far superior to making individual threads, but still far slower than single-threaded factory
        ExecutorService   threadPool    = Executors.newCachedThreadPool();

        for(PieceFaction faction : keys){

            for(int piecesCreated = 0; piecesCreated < 5; piecesCreated++){

                Runnable pieceCreator;

                if(piecesCreated != 2) {
                    pieceCreator = new ConcurrentPieceCreator(faction, PieceType.STUDENT);
                } else {
                    pieceCreator = new ConcurrentPieceCreator(faction, PieceType.SENSEI);
                }

                threadPool.execute(pieceCreator);
            }
        }

        threadPool.shutdown();
        try {
            threadPool.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private class ConcurrentPieceCreator implements Runnable {

        private PieceFaction    faction;
        private PieceType       type;

        private ConcurrentPieceCreator(PieceFaction faction, PieceType type) {
            this.faction    = faction;
            this.type       = type;
        }

        public void run(){

            Piece piece;

            lock.lock();

            if(faction.equals(PieceFaction.RED)){
                switch(type){
                    case STUDENT:
                        piece = new RedStudent();
                        piecesContainer.get(faction).add(piece);
                        break;
                    case SENSEI:
                        piece = new RedSensei();
                        piecesContainer.get(faction).add(piece);
                        break;
                    default:
                        System.out.println("Invalid type");
                        break;
                }
            } else if (faction.equals(PieceFaction.BLUE)) {
                switch (type) {
                    case STUDENT:
                        piece = new BlueStudent();
                        piecesContainer.get(faction).add(piece);
                        break;
                    case SENSEI:
                        piece = new BlueSensei();
                        piecesContainer.get(faction).add(piece);
                        break;
                    default:
                        System.out.println("Invalid type");
                        break;
                }
            }

            lock.unlock();
        }


    }




}
