package org.tennis;

public class InitialScoringStrategy implements ScoringStrategy
{
	private final static String[] scores = {"0", "15", "30", "40"};

	private int aScoreIndex = 0;
	private int bScoreIndex = 0;

	private final TennisGame tennisGame;

	public InitialScoringStrategy(TennisGame tennisGame)
	{
		this.tennisGame = tennisGame;
	}

	@Override
	public void aScores()
	{
		aScoreIndex = aScoreIndex + 1;

		if (deuce())
			tennisGame.deuce();
	}

	@Override
	public void bScores()
	{
		bScoreIndex = bScoreIndex + 1;

		if (deuce())
			tennisGame.deuce();
	}

	@Override
	public String getScore()
	{
		if (aScoreIndex == scores.length)
			return "A Wins";

		if (bScoreIndex == scores.length)
			return "B Wins";

		return scores[aScoreIndex] + "-" + scores[bScoreIndex];
	}

	private boolean deuce()
	{
		return aScoreIndex == scores.length - 1 && bScoreIndex == scores.length - 1;
	}
}
