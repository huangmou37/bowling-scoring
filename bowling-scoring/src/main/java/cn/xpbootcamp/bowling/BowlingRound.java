package cn.xpbootcamp.bowling;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.min;

public class BowlingRound {

  public BowlingRound(int roundNumber) {
    this.roundNumber = roundNumber;
    this.blowOuts = new ArrayList<>();
    this.totalBlowOut = 0;
  }

  public void blowOut(int i) {
    timesOfBlowing++;
    blowOuts.add(i);
    totalBlowOut += i;
  }

  public boolean isFinished() {
    if (roundNumber < 10) {
      return timesOfBlowing > 1 || totalBlowOut >= 10;
    } else {
      return (timesOfBlowing > 1 && totalBlowOut < 10) || (timesOfBlowing > 2);
    }
  }

  public int getScore() {
    int score = totalBlowOut;

    if (isStrike() && null != nextRound) {
      for (int i = 0; i < min(nextRound.blowOuts.size(), 2); i++) {
        score += nextRound.blowOuts.get(i);
      }
    }

    return score;
  }

  public void setNextRound(BowlingRound nextRound) {
    this.nextRound = nextRound;
  }

  private boolean isStrike() {
    return timesOfBlowing == 1 && totalBlowOut == 10;
  }

  private int timesOfBlowing = 0;

  private List<Integer> blowOuts;

  private int totalBlowOut;

  private int roundNumber;

  private BowlingRound nextRound;
}
