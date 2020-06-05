package cn.xpbootcamp.bowling;

import cn.xpbootcamp.bowling.exception.MatchIsFinishedException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingMatchTest {

  @Test
  public void should_return_150_when_get_score_given_10_rounds_with_21_rolls_and_5_knock_down_respectively()
      throws MatchIsFinishedException {
    BowlingMatch bowlingMatch = new BowlingMatch();

    for (int i = 0; i < 21; i++) {
      bowlingMatch.knowDown(5);
    }

    assertEquals(150, bowlingMatch.getScore());
  }
}
