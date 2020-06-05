package cn.xpbootcamp.bowling;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class BowlingRoundTest {

  // test cases of isFinished()
  @Test
  public void should_return_false_when_is_finished_given_1st_round_with_4_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(4);

    assertFalse(firstRound.isFinished());
  }

  @Test
  public void should_return_true_when_is_finished_given_1st_round_with_10_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(10);

    assertTrue(firstRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_1st_round_with_4_and_5_knock_down_in_two_rolls() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(4);
    firstRound.knockDown(5);

    assertTrue(firstRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_1st_round_with_4_and_6_knock_down_in_two_rolls() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(4);
    firstRound.knockDown(6);

    assertTrue(firstRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_10th_round_with_10_knock_down_in_1st_roll() {
    BowlingRound finalRound = new BowlingRound(10);
    finalRound.knockDown(10);

    assertFalse(finalRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_10th_round_with_10_and_9_knock_down_in_two_rolls() {
    BowlingRound finalRound = new BowlingRound(10);
    finalRound.knockDown(10);
    finalRound.knockDown(9);

    assertFalse(finalRound.isFinished());
  }

  @Test
  public void should_return_false_when_is_finished_given_10th_round_with_1_and_9_knock_down_in_two_rolls() {
    BowlingRound finalRound = new BowlingRound(10);
    finalRound.knockDown(1);
    finalRound.knockDown(9);

    assertFalse(finalRound.isFinished());
  }

  @Test
  public void should_return_true_when_is_finished_given_10th_round_with_1_and_8_knock_down_in_two_rolls() {
    BowlingRound finalRound = new BowlingRound(10);
    finalRound.knockDown(1);
    finalRound.knockDown(8);

    assertTrue(finalRound.isFinished());
  }

  // test cases of getScore()

  @Test
  public void should_return_4_when_get_score_given_1st_round_with_4_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(4);

    assertEquals(4, firstRound.getScore());
  }

  @Test
  public void should_return_10_when_get_score_given_1st_round_with_10_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(10);

    assertEquals(10, firstRound.getScore());
  }

  @Test
  public void should_return_9_when_get_score_given_1st_round_with_4_and_5_knock_down_in_two_rolls() {
    BowlingRound firstRound = new BowlingRound(1);
    firstRound.knockDown(4);
    firstRound.knockDown(5);

    assertEquals(9, firstRound.getScore());
  }

  @Test
  public void should_return_15_when_get_score_given_1st_round_with_10_knock_down_in_1st_roll_and_2nd_round_with_5_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    BowlingRound secondRound = new BowlingRound(2);
    firstRound.setNextRound(secondRound);
    firstRound.knockDown(10);
    secondRound.knockDown(5);

    assertEquals(15, firstRound.getScore());
  }

  @Test
  public void should_return_18_when_get_score_given_1st_round_with_10_knock_down_in_1st_roll_and_2nd_round_with_5_and_3_knock_down_in_two_rolls() {
    BowlingRound firstRound = new BowlingRound(1);
    BowlingRound secondRound = new BowlingRound(2);
    firstRound.setNextRound(secondRound);
    firstRound.knockDown(10);
    secondRound.knockDown(5);
    secondRound.knockDown(3);

    assertEquals(18, firstRound.getScore());
  }

  @Test
  public void should_return_15_when_get_score_given_1st_round_with_4_and_6_knock_down_in_two_rolls_and_2nd_round_with_5_and_3_knock_down_in_two_rolls() {
    BowlingRound firstRound = new BowlingRound(1);
    BowlingRound secondRound = new BowlingRound(2);
    firstRound.setNextRound(secondRound);
    firstRound.knockDown(4);
    firstRound.knockDown(6);
    secondRound.knockDown(5);
    secondRound.knockDown(3);

    assertEquals(15, firstRound.getScore());
  }

  @Test
  public void should_return_25_when_get_score_given_1st_round_with_10_knock_down_in_1st_roll_and_2nd_round_with_10_knock_down_in_1st_roll_and_3rd_round_with_5_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    BowlingRound secondRound = new BowlingRound(2);
    BowlingRound thirdRound = new BowlingRound(3);
    firstRound.setNextRound(secondRound);
    secondRound.setNextRound(thirdRound);
    firstRound.knockDown(10);
    secondRound.knockDown(10);
    thirdRound.knockDown(5);

    assertEquals(25, firstRound.getScore());
  }

  @Test
  public void should_return_30_when_get_score_given_1st_round_with_10_knock_down_in_1st_roll_and_2nd_round_with_10_knock_down_in_1st_roll_and_3rd_round_with_10_knock_down_in_1st_roll() {
    BowlingRound firstRound = new BowlingRound(1);
    BowlingRound secondRound = new BowlingRound(2);
    BowlingRound thirdRound = new BowlingRound(3);
    firstRound.setNextRound(secondRound);
    secondRound.setNextRound(thirdRound);
    firstRound.knockDown(10);
    secondRound.knockDown(10);
    thirdRound.knockDown(10);

    assertEquals(30, firstRound.getScore());
  }

  @Test
  public void should_return_9_when_get_score_given_10th_round_with_5_and_4_knock_down_in_two_rolls() {
    BowlingRound tenthRound = new BowlingRound(10);
    tenthRound.knockDown(5);
    tenthRound.knockDown(4);

    assertEquals(9, tenthRound.getScore());
  }

  @Test
  public void should_return_15_when_get_score_given_10th_round_with_5_and_5_and_5_knock_down_in_three_rolls() {
    BowlingRound tenthRound = new BowlingRound(10);
    tenthRound.knockDown(5);
    tenthRound.knockDown(5);
    tenthRound.knockDown(5);

    assertEquals(15, tenthRound.getScore());
  }

  @Test
  public void should_return_15_when_get_score_given_10th_round_with_5_and_5_and_10_knock_down_in_three_rolls() {
    BowlingRound tenthRound = new BowlingRound(10);
    tenthRound.knockDown(5);
    tenthRound.knockDown(5);
    tenthRound.knockDown(10);

    assertEquals(20, tenthRound.getScore());
  }

  @Test
  public void should_return_18_when_get_score_given_10th_round_with_10_and_5_and_3_knock_down_in_three_rolls() {
    BowlingRound tenthRound = new BowlingRound(10);
    tenthRound.knockDown(10);
    tenthRound.knockDown(5);
    tenthRound.knockDown(3);

    assertEquals(18, tenthRound.getScore());
  }

  @Test
  public void should_return_25_when_get_score_given_10th_round_with_10_and_10_and_5_knock_down_in_three_rolls() {
    BowlingRound tenthRound = new BowlingRound(10);
    tenthRound.knockDown(10);
    tenthRound.knockDown(10);
    tenthRound.knockDown(5);

    assertEquals(25, tenthRound.getScore());
  }
}
