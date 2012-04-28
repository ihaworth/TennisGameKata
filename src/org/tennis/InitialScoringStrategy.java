package org.tennis;

public class InitialScoringStrategy implements ScoringStrategy
{
	private final static String[] scores = {"0", "15", "30", "40"};

//	private int aScoreIndex = 0;
//	private int bScoreIndex = 0;

	private final TennisGame tennisGame;

	public InitialScoringStrategy(TennisGame tennisGame)
	{
		this.tennisGame = tennisGame;
	}

	@Override
	public void aScores()
	{
		setaScoreIndex(getaScoreIndex() + 1);

		if (deuce())
			tennisGame.deuce();
	}

	@Override
	public void bScores()
	{
		setbScoreIndex(getbScoreIndex() + 1);

		if (deuce())
			tennisGame.deuce();
	}

	@Override
	public String getScore()
	{
		if (getaScoreIndex() == scores.length)
			return "A Wins";

		if (getbScoreIndex() == scores.length)
			return "B Wins";

		return scores[getaScoreIndex()] + "-" + scores[getbScoreIndex()];
	}

	private boolean deuce()
	{
		return getaScoreIndex() == scores.length - 1 && getbScoreIndex() == scores.length - 1;
	}

	private int getaScoreIndex()
	{
		return tennisGame.aScoreIndex;
	}

	private void setaScoreIndex(int aScoreIndex)
	{
		tennisGame.aScoreIndex = aScoreIndex;
	}

	private int getbScoreIndex()
	{
		return tennisGame.bScoreIndex;
	}

	private void setbScoreIndex(int bScoreIndex)
	{
		tennisGame.bScoreIndex = bScoreIndex;
	}
}
