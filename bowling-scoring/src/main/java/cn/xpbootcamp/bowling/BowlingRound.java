package cn.xpbootcamp.bowling;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.min;

public class BowlingRound {

  public BowlingRound(int roundNumber) {
    this.roundNumber = roundNumber;
    this.knockDowns = new ArrayList<>();
    this.totalKnockDown = 0;
  }

  public void knockDown(int i) {
    numOfRolls++;
    knockDowns.add(i);
    totalKnockDown += i;
  }

  public boolean isFinished() {
    if (roundNumber < 10) {
      return numOfRolls > 1 || totalKnockDown >= 10;
    } else {
      return (numOfRolls > 1 && totalKnockDown < 10) || (numOfRolls > 2);
    }
  }

  public int getScore() {
    int score = totalKnockDown;

    if (isStrike() && null != nextRound) {
      for (int i = 0; i < min(nextRound.knockDowns.size(), 2); i++) {
        score += nextRound.knockDowns.get(i);
      }
    }

    return score;
  }

  public void setNextRound(BowlingRound nextRound) {
    this.nextRound = nextRound;
  }

  private boolean isStrike() {
    return numOfRolls == 1 && totalKnockDown == 10;
  }

  private int numOfRolls = 0;

  private List<Integer> knockDowns;

  private int totalKnockDown;

  private int roundNumber;

  private BowlingRound nextRound;
}
