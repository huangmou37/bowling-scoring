package cn.xpbootcamp.bowling;

public class BowlingRound {

  public BowlingRound(int roundNumber) {
    this.roundNumber = roundNumber;
  }

  public void blowOut(int i) {
    timesOfBlowing ++;
    score += i;
  }

  public boolean isFinished() {
    if(roundNumber < 10) {
      return timesOfBlowing != 1 || score >= 10;
    } else {
      return false;
    }
  }

  private int timesOfBlowing = 0;

  private int score = 0;

  private int roundNumber;
}
