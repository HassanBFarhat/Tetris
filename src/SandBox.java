import model.*;

import java.sql.SQLOutput;

import static model.Rotation.NONE;
import static model.Rotation.QUARTER;

public final class SandBox {

    /** Private default constructor. */
    private SandBox() {

    }

    public static void main(final String[] theArgs) {
        final Board b = new Board();
//        b.newGame();
//        System.out.println(b);
//
//        b.step();
//        System.out.println(b);
//        b.rotateCW();
//        System.out.println(b);
//        b.rotateCW();
//        System.out.println(b);
//        b.rotateCW();
//        System.out.println(b);
//        b.rotateCW();
//        System.out.println(b);
//        b.drop();
//        System.out.println(b);

        final MovableTetrisPiece mTP = new MovableTetrisPiece(TetrisPiece.I, new Point(0,0), NONE);
        System.out.println(mTP.toString());

        int[][] x = TetrisPiece.getRandomPiece().getPointsByRotation(Rotation.random());




        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length; j++) {
                System.out.print(x[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();
    }

}
