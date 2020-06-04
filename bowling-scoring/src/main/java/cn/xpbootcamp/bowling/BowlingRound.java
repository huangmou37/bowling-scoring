package cn.xpbootcamp.bowling;

import java.util.ArrayList;
import java.util.List;

public class BowlingRound {

  public BowlingRound(int roundNumber) {
    this.roundNumber = roundNumber;
    this.knockDowns = new ArrayList<>();
    this.totalKnockDown = 0;
  }

  public void knockDown(int i) {
    knockDowns.add(i);
    totalKnockDown += i;
  }

  public boolean isFinished() {
    if (roundNumber < 10) {
      return knockDowns.size() > 1 || totalKnockDown >= 10;
    }

    return (knockDowns.size() > 1 && totalKnockDown < 10) || (knockDowns.size() > 2);
  }

  public int getScore() {
    return totalKnockDown + getBonus();
  }

  private int getBonus() {
    int result = 0;

    if (isStrike()) {
      result = getKnowDownOfNextTwoRolls();
    } else if (isSpare()) {
      result = getKnowDownOfNextOneRoll();
    }

    return result;
  }

  private int getKnowDownOfNextOneRoll() {
    int result = 0;

    if (nextRound != null && nextRound.knockDowns.size() > 0) {
      result = nextRound.knockDowns.get(0);
    }

    return result;
  }

  private int getKnowDownOfNextTwoRolls() {
    int result = 0;

    if (nextRound != null && nextRound.knockDowns.size() > 0) {
      if (nextRound.isStrike()) {
        result = 10 + nextRound.getKnowDownOfNextOneRoll();
      } else if (nextRound.knockDowns.size() == 1) {
        result = nextRound.knockDowns.get(0);
      } else {
        result = nextRound.knockDowns.get(0) + nextRound.knockDowns.get(1);
      }
    }

    return result;
  }

  public void setNextRound(BowlingRound nextRound) {
    this.nextRound = nextRound;
  }

  private boolean isStrike() {
    return knockDowns.size() == 1 && totalKnockDown == 10;
  }

  private boolean isSpare() {
    return knockDowns.size() == 2 && totalKnockDown == 10;
  }

  private List<Integer> knockDowns;

  private int totalKnockDown;

  private int roundNumber;

  private BowlingRound nextRound;
}
