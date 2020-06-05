package cn.xpbootcamp.bowling;

import cn.xpbootcamp.bowling.exception.MatchIsFinishedException;

import java.util.ArrayList;
import java.util.List;

public class BowlingMatch {

  public BowlingMatch() {
    bowlingRounds = new ArrayList<>(10);

    for (int i = 0; i < 10; i++) {
      bowlingRounds.add(new BowlingRound((i + 1)));
    }

    for (int i = 0; i < 9; i++) {
      bowlingRounds.get(i).setNextRound(bowlingRounds.get(i + 1));
    }
  }

  public void knowDown(int numberOfKnowDown) throws MatchIsFinishedException {
    if (isFinished()) {
      throw new MatchIsFinishedException();
    }

    getCurrentRound().knockDown(numberOfKnowDown);
  }

  public int getScore() {
    return bowlingRounds.stream()
        .reduce(
            0, (tmpTotalScore, round) -> tmpTotalScore + round.getScore(), Integer::sum);
  }

  private BowlingRound getCurrentRound() {
    BowlingRound currRound = null;
    for (int i = 0; i < 10; i++) {
      if (!bowlingRounds.get(i).isFinished()) {
        currRound = bowlingRounds.get(i);
        break;
      }
    }

    return currRound;
  }

  private boolean isFinished() {
    BowlingRound currRound = getCurrentRound();
    return currRound == null;
  }

  private List<BowlingRound> bowlingRounds;
}
