package org.tennis;

public class InitialScoringStrategy implements ScoringStrategy
{
	private final static String[] scores = {"0", "15", "30", "40"};

	private int aScoreIndex = 0;
	public int getaScoreIndex()
	{
		return aScoreIndex;
	}

	public int getbScoreIndex()
	{
		return bScoreIndex;
	}

	private int bScoreIndex = 0;

	private final TennisGame tennisGame;


	public InitialScoringStrategy(TennisGame tennisGame)
	{
		this.tennisGame = tennisGame;
	}

	@Override
	public String getScore(TennisGame tennisGame)
	{
		if (advantageA())
			return "Advantage A";

		if (advantageB())
			return "Advantage B";

		if (deuce())
			return "Deuce";

		if (aScoreIndex >= scores.length)
			return "A Wins";

		if (bScoreIndex >= scores.length)
			return "B Wins";

		return scores[aScoreIndex] + "-" + scores[bScoreIndex];
	}

	boolean advantageA()
	{
		return aScoreIndex == scores.length && bScoreIndex == scores.length - 1;
	}

	boolean advantageB()
	{
		return aScoreIndex == scores.length - 1 && bScoreIndex == scores.length;
	}

	boolean deuce()
	{
		return aScoreIndex == scores.length - 1 && bScoreIndex == scores.length - 1;
	}

	@Override
	public void aScores()
	{
		if (advantageB())
			bScoreIndex--;
		else
			aScoreIndex++;

//		if (deuce())
//			tennisGame.deuce();
	}

	@Override
	public void bScores()
	{
		if (advantageA())
			aScoreIndex--;
		else
			bScoreIndex++;

//		if (deuce())
//			tennisGame.deuce();
	}
}
