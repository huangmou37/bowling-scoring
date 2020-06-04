package cn.xpbootcamp.bowling;

import org.junit.Test;

import static org.junit.Assert.assertFalse;

public class BowlingRoundTest {

  @Test
  public void should_return_false_when_is_finished_given_1st_4_blow_out() {
    BowlingRound firstRound = new BowlingRound();
    firstRound.blowOut(4);

    assertFalse(firstRound.isFinished());
  }
}
