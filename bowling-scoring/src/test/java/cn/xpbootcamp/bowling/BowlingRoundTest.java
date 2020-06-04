package cn.xpbootcamp.bowling;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingRoundTest {

  @Test
  public void should_return_false_when_is_finished_given_a_round_with_1st_4_blow_out() {
    BowlingRound firstRound = new BowlingRound();
    firstRound.blowOut(4);

    assertFalse(firstRound.isFinished());
  }

  @Test
  public void should_return_true_when_is_finished_given_a_round_with_1st_10_blow_out() {
    BowlingRound firstRound = new BowlingRound();
    firstRound.blowOut(10);

    assertTrue(firstRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_a_round_with_1st_4_and_2nd_5_blow_out() {
    BowlingRound firstRound = new BowlingRound();
    firstRound.blowOut(4);
    firstRound.blowOut(5);

    assertTrue(firstRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_a_round_with_1st_4_and_2nd_6_blow_out() {
    BowlingRound firstRound = new BowlingRound();
    firstRound.blowOut(4);
    firstRound.blowOut(6);

    assertTrue(firstRound.isFinished());
  }
}
