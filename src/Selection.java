package com.example.shockdotjava.selecthelper;


import java.util.ArrayList;


public class Selection implements Comparable<Selection>
{
	private String name;
	private ArrayList<String> Answers;
	private int selectedTimes;
	private int score;

	public Selection(String name)
	{
		this.name = name;
		Answers = new ArrayList<>();
		this.selectedTimes = 0;
	}

	public void beenSelected()
	{
		this.selectedTimes++;
	}

	public int getSelectedTimes()
	{
		return this.selectedTimes;
	}

	public String SelectionName()
	{
		return this.name;
	}

	public String getAnswerOf(int index)
	{
		return this.Answers.get(index);
	}

	public void setAnswerOf(int index, String answer)
	{
		this.Answers.set(index, answer);
	}

	public void addAnswerToSelection(String answer)
	{
		this.Answers.add(answer);
	}

	public ArrayList<String> getAnswers()
	{
		return this.Answers;
	}

	public int getScore()
	{
		return this.score;
	}

	@Override
	public int compareTo(Selection other) {
		return this.score - other.score;
	}

	public void clacScore(Selection setting)
	{
		switch(setting.SelectionName())
		{
			case "Food" :
				this.score = FoodTypeScore(setting);
				break;
			case "Drink" :
				this.score = DrinkTypeScore(setting);
				break;
			case "Other" :
				this.score = OtherTypeScore(setting);
				break;
		}
	}
	//-----------------unfinished-------------------------------
	private int FoodTypeScore(Setting setting)
	{
		int score = 0;
		int i;
		for(i=0;i<7;i++)
		{
		    if(setting.setting[0][i].indexOf(Answers[0])!=-1)
		    {
		    	score+=setting.getWeight(0,i);
		    }
		}
		for(i=0;i<1;i++)
		{
		    if(setting.setting[1][i].indexOf(Answers[1])!=-1)
		    {
		    	score+=setting.getWeight(1,i);
		    }
		}
		for(i=0;i<1;i++)
		{
		    if(setting.setting[2][i].indexOf(Answers[2])!=-1)
		    {
		    	score+=setting.getWeight(2,i);
		    }
		}
		for(i=0;i<2;i++)
		{
		    if(setting.setting[3][i].indexOf(Answers[3])!=-1)
		    {
		    	score+=setting.getWeight(3,i);
		    }
		}
		for(i=0;i<4;i++)
		{
		    if(setting.setting[4][i].indexOf(Answers[4])!=-1)
		    {
		    	score+=setting.getWeight(4,i);
		    }
		}
		return score;
	}

	private int DrinkTypeScore(Setting setting)
	{
		int score = 0;
		int i;
		return score;
	}

	private int OtherTypeScore(Setting setting)
	{
		int score = 0;
		int i;
		return score;
	}

}
