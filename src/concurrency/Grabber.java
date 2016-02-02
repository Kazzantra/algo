package concurrency;

import tools.io;

public class Grabber implements Runnable {
	public Turn turn;
	public final Turn ownTurn;
	public Grabber(Turn ownTurn, Turn initTurn) {
		this.ownTurn = ownTurn;
		this.turn = initTurn;
	}
	public void takeTurns() throws InterruptedException {
		synchronized(turn) {
			if(turn != this.ownTurn) {
				turn.wait();
				Thread.sleep(50);
			}
			io.pl(this.ownTurn.toString());
			next(turn);
			turn.notifyAll();
		}
	}
	private void next(Turn turn) {
		switch(turn) {
		case A:
			turn = Turn.B;
			break;
		case B:
			turn = Turn.C;
			break;
		default:
			turn = Turn.A;
		}
	}
	public void run() {
		while(true) {
			try {
				takeTurns();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		Turn turn = Turn.A;
		Thread grabberA = new Thread(new Grabber(Turn.A, turn));
		Thread grabberB = new Thread(new Grabber(Turn.B, turn));
		Thread grabberC = new Thread(new Grabber(Turn.C, turn));
		grabberA.start();
		grabberB.start();
		grabberC.start();
	}
}
