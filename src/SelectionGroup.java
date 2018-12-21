package com.example.shockdotjava.selecthelper;

import java.util.ArrayList;
import java.util.Collections;


public class SelectionGroup
{
	private String name;
	private String type;
	private ArrayList<Selection> selections;

	public SelectionGroup(String name, String type)
	{
		this.name = name;
		this.type = type;
		selections = new ArrayList<>();
	}

	public String GroupName()
	{
		return this.name;
	}

	public ArrayList<String> getSelectionsNames()
	{
		ArrayList<String> names = new ArrayList<String>();
		for (Selection s: selections)
		{
			names.add(s.SelectionName());
		}

		return names;
	}

	public String GroupType()
	{
		return this.type;
	}

	public Selection getSelectionOf(int index)
	{
		return this.selections.get(index);
	}

	public void setSelectionOf(int index, Selection selection)
	{
		this.selections.set(index, selection);
	}

	public void addSelectionToGroup(Selection selection)
	{
		this.selections.add(selection);
	}

	public void deleteSelectionAt(int index)
	{
		this.selections.remove(index);
	}

	public ArrayList<Selection> getSelections() {
		return selections;
	}

	public void sortSelections()
	{
		Collections.sort(this.selections);
	}
}
