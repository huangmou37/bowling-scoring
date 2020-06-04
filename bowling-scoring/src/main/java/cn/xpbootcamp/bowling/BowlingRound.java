package cn.xpbootcamp.bowling;

public class BowlingRound {

  public void blowOut(int i) {
    timesOfBlowing ++;
    score += i;
  }

  public boolean isFinished() {
    return timesOfBlowing != 1 || score >= 10;
  }

  private int timesOfBlowing = 0;

  private int score = 0;
}
