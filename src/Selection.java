package Selection;

import java.util.ArrayList;

public class Selection
{
	private String name;
	private ArrayList<String> Answers;
	private int selectedTimes;
	
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
	
}
