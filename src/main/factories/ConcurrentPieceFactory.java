package factories;

import constants.GameMode;
import constants.PieceFaction;
import constants.PieceType;
import models.pieces.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
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

            System.out.println(endTime - startTime + " Nano-Seconds");

        } else {
            //            could try throwing a homemade exception for incorrect game mode?
        }
    }

    private void setupStandardModePieceCreation() {
        Set<PieceFaction> keys      = this.piecesContainer.keySet();
        ArrayList<Thread> threads = new ArrayList<>();

        for(PieceFaction faction : keys){

            for(int piecesCreated = 0; piecesCreated < 5; piecesCreated++){

                Runnable pieceCreator;

                if(piecesCreated != 2) {
                    pieceCreator = new ConcurrentPieceCreator(faction, PieceType.STUDENT);
                } else {
                    pieceCreator = new ConcurrentPieceCreator(faction, PieceType.SENSEI);
                }

                Thread thread = new Thread(pieceCreator);
                threads.add(thread);
                thread.start();
            }
        }

        for(Thread thread : threads){
            try {
                thread.join();
            } catch (InterruptedException e) {
                thread.interrupt();
                e.printStackTrace();
            }
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

            if(faction == PieceFaction.RED){
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
            } else if (faction == PieceFaction.BLUE) {
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
