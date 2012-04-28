package org.tennis;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class TennisGameTest
{
	private TennisGame tennisGame = new TennisGame();

	@Test
	public void newGameStartsAtLoveAll()
	{
		assertThat(score(), equalTo("0-0"));
	}

	@Test
	public void aScoresGives15Love()
	{
		aScores();
		assertThat(score(), equalTo("15-0"));
	}

	@Test
	public void bScoresGivesLove15()
	{
		bScores();
		assertThat(score(), equalTo("0-15"));
	}

	@Test
	public void aScoresAndBScoresGives15All()
	{
		aScores();
		bScores();
		assertThat(score(), equalTo("15-15"));
	}

	@Test
	public void aScoresTwiceGives30Love()
	{
		aScores();
		aScores();
		assertThat(score(), equalTo("30-0"));
	}

	@Test
	public void aMakeStraightWin()
	{
		aScores40();
		aScores();
		assertThat(score(), equalTo("A Wins"));
	}

	@Test
	public void bMakeStraightWin()
	{
		bScores40();
		bScores();
		assertThat(score(), equalTo("B Wins"));
	}

	@Test
	public void bothScore40GivesDeuce()
	{
		deuce();
		assertThat(score(), equalTo("Deuce"));
	}

	@Test
	public void advantageA()
	{
		deuce();
		aScores();
		assertThat(score(), equalTo("Advantage A"));
	}

	@Test
	public void advantageB()
	{
		deuce();
		bScores();
		assertThat(score(), equalTo("Advantage B"));
	}

	@Test
	public void aWinsFromAdvantage()
	{
		deuce();
		aScores();
		aScores();
		assertThat(score(), equalTo("A Wins"));
	}

	@Test
	public void bWinsFromAdvantage()
	{
		deuce();
		bScores();
		bScores();
		assertThat(score(), equalTo("B Wins"));
	}

	@Test
	public void returnToDeuceFromAdvantageA()
	{
		deuce();
		aScores();
		bScores();
		assertThat(score(), equalTo("Deuce"));
	}

	@Test
	public void returnToDeuceFromAdvantageB()
	{
		deuce();
		bScores();
		aScores();
		assertThat(score(), equalTo("Deuce"));
	}

	@Test
	public void returnToDeuceFromAdvantageAThenAWins()
	{
		deuce();
		aScores();
		bScores();
		aScores();
		aScores();
		assertThat(score(), equalTo("A Wins"));
	}

	@Test
	public void returnToDeuceFromAdvantageAThenBWins()
	{
		deuce();
		aScores();
		bScores();
		bScores();
		bScores();
		assertThat(score(), equalTo("B Wins"));
	}

	@Test
	public void returnToDeuceFromAdvantageBThenBWins()
	{
		deuce();
		bScores();
		aScores();
		bScores();
		bScores();
		assertThat(score(), equalTo("B Wins"));
	}

	@Test
	public void returnToDeuceFromAdvantageBThenAWins()
	{
		deuce();
		bScores();
		aScores();
		aScores();
		aScores();
		assertThat(score(), equalTo("A Wins"));
	}

	private void deuce()
	{
		aScores40();
		bScores40();
	}

	private void aScores40()
	{
		aScores();
		aScores();
		aScores();
	}

	private void bScores40()
	{
		bScores();
		bScores();
		bScores();
	}

	private void aScores()
	{
		tennisGame.aScores();
	}

	private void bScores()
	{
		tennisGame.bScores();
	}

	private String score()
	{
		return tennisGame.getScore();
	}
}
