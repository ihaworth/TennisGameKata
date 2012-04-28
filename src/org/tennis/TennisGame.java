package org.tennis;

public class TennisGame
{
	private ScoringStrategy scoringStrategy = new InitialScoringStrategy(this);
	public int aScoreIndex;
	public int bScoreIndex;

	public String getScore()
	{
		return scoringStrategy.getScore();
	}

	public void aScores()
	{
		scoringStrategy.aScores();
	}

	public void bScores()
	{
		scoringStrategy.bScores();
	}

	public void deuce()
	{
		scoringStrategy = new DeuceScoringStrategy(this);
	}
}
