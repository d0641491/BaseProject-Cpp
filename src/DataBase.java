//package DataBase;
/*
 * If The Program Cant Work, Please Contect Me at Line ID: Kuteng_F.
 * Or read comments, See if it helps.
 *
 * Written at 21/12/2018, 08:46 PM
 */

public class DataBase
{
	public class Food
	{
		int Max_Price;
		boolean Hot;
		boolean Rice;
		int Full;// 飽足感 0-5 小至大
		int Max_Waiting_Time;// Counting in Mins
	}
	public class Drink
	{
		int Max_Price;
		boolean Hot;
		String Addon;
		int Quantity;// 份量 0-5 小至大
		int Max_Waiting_Time;// Counting in Mins
	}
	public class Other
	{
		int Max_Price;
		int Max_Waiting_Time;// Counting in Mins
	}

	public class Node
	{
		Node next;

		Food Food_Choosen;
		Drink Drink_Choosen;
		Other Other_Choosen;

		int Order_Number;// 訂單編號
		int Type;
	}
	private Node First;

	// Type will define as 0 = Food, 1 = Drink, 2 = Others
	// Questions // Food Example
	/*
	 *  {
	 *     int Max_Price = 500;
	 *	   boolean Hot = false;
	 *	   boolean Rice = true;
	 *	   int Full = 3;
	 *	   int Max_Waiting_Time = 20;
	 * }
	 */
	public void add(int Type, Questions Ans, int Order_Number)
	{
		System.out.print("Inserting.\n");
		Node temp = new Node();

		switch(Type)
		{
			case 0://Food
			{
				//temp.Food_Choosen = Ans;
				temp.Food_Choosen.Max_Price = Ans.Max_Price;
				temp.Food_Choosen.Hot = Ans.Hot;
				temp.Food_Choosen.Rice = Ans.Rice;
				temp.Food_Choosen.Full = Ans.Full;
				temp.Food_Choosen.Max_Waiting_Time = Ans.Max_Waiting_Time;

				temp.Drink_Choosen = null;
				temp.Other_Choosen = null;

				break;
			}

			case 1://Drink
			{
				temp.Food_Choosen = null;

				//temp.Drink_Choosen = Ans;
				temp.Drink_Choosen.Max_Price = Ans.Max_Price;
				temp.Drink_Choosen.Hot = Ans.Hot;
				temp.Drink_Choosen.Addon = Ans.Addon;
				temp.Drink_Choosen.Quantity = Ans.Quantity;
				temp.Drink_Choosen.Max_Waiting_Time = Ans.Max_Waiting_Time;

				temp.Other_Choosen = null;

				break;
			}

			case 2://Others
			{
				temp.Food_Choosen = null;
				temp.Drink_Choosen = null;

				//temp.Other_Choosen = Ans;
				temp.Other_Choosen.Max_Price = Ans.Max_Price;
				temp.Other_Choosen.Max_Waiting_Time = Ans.Max_Waiting_Time;

				break;
			}

			default://If there a Problem
			{
				System.out.print("Type Wrong, Please Check.\n");
				break;
			}
		}
		temp.Type = Type;
		temp.Order_Number = Order_Number;

		if (First == null)
			First = temp;

		else
		{
			Node Last = First;

			while (Last.next != null)
				Last = Last.next;

			Last.next = temp;
		}
		System.out.print("Done.\n");
	}

	public void delete(int Order_Number)
	{
		System.out.print("Deleting.\n");
		boolean Found_Flag = false;

		Node Last = First;
		Node Prev = First;

		while (Last.next != null)
		{
			if (Last.Order_Number == Order_Number)
			{
				Prev.next = Last.next;
				Last = null;
				Found_Flag = true;
				break;
			}

			Prev = Last;
			Last = Last.next;
		}

		if (Found_Flag == false)
			System.out.print("Object Can't Found!\n");

		else
			System.out.print("Done.\n");
	}
	// Please Put the Value you want to Change IN the Class Questions
	// Check the Class Format above
	/*
	 * The Program in this file expect it had done.
	 */
	public void change(Questions Ans, int Order_Number)
	{
		System.out.print("Changing.\n");
		boolean Found_Flag = false;

		Node Last = First;

		while (Last.next != null)
		{
			if (Last.Order_Number == Order_Number)
			{
				switch (Last.Type)
				{
					case 0:// Food
					{
						//Last.Food_Choosen = Ans;

						Last.Food_Choosen.Max_Price = Ans.Max_Price;
						Last.Food_Choosen.Hot = Ans.Hot;
						Last.Food_Choosen.Rice = Ans.Rice;
						Last.Food_Choosen.Full = Ans.Full;
						Last.Food_Choosen.Max_Waiting_Time = Ans.Max_Waiting_Time;

						break;
					}

					case 1:
					{
						//Last.Drink_Choosen = Ans;

						Last.Drink_Choosen.Max_Price = Ans.Max_Price;
						Last.Drink_Choosen.Hot = Ans.Hot;
						Last.Drink_Choosen.Addon = Ans.Addon;
						Last.Drink_Choosen.Quantity = Ans.Quantity;
						Last.Drink_Choosen.Max_Waiting_Time = Ans.Max_Waiting.Time;

						break;
					}

					case 2:
					{
						//Last.Other_Choosen = Ans;

						Last.Other_Choosen.Max_Price = Ans.Max_Price;
						Last.Other_Choosen.Max_Waiting_Time = Ans.Max_Price;

						break;
					}

					default:
					{
						System.out.print("Type Wrong, Please Check.\n");
						break;
					}
				}
				Found_Flag = true;
				break;
			}

			Last = Last.next;
		}

		if (Found_Flag == false)
			System.out.print("Object Can't Found!\n");

		else
			System.out.print("Done.\n");
	}

	public void view(int Order_Number)
	{
		System.out.print("Searching.\n");
		boolean Found_Flag = false;

		Node Last = First;

		while (Last.next != null)
		{
			if (Last.Order_Number == Order_Number)
			{
				switch (Last.Type)
				{
					case 0:// Food
					{
						System.out.print("Food:\n");

						System.out.print("Max Price: ");
						System.out.print(Last.Food_Choosen.Max_Price);
						System.out.print("\n");

						System.out.print("Hot: ");
						System.out.print(Last.Food_Choosen.Hot);
						System.out.print("\n");

						System.out.print("Rice: ");
						System.out.print(Last.Food_Choosen.Rice);
						System.out.print("\n");

						System.out.print("Full: ");
						System.out.print(Last.Food_Choosen.Full);
						System.out.print("\n");

						System.out.print("Max Waiting Time: ");
						System.out.print(Last.Food_Choosen.Max_Waiting_Time);
						System.out.print("\n");

						break;
					}

					case 1:
					{
						System.out.print("Drink:\n");

						System.out.print("Max Price: ");
						System.out.print(Last.Drink_Choosen.Max_Price);
						System.out.print("\n");

						System.out.print("Hot: ");
						System.out.print(Last.Drink_Choosen.Hot);
						System.out.print("\n");

						System.out.print("Addon: ");
						System.out.print(Last.Drink_Choosen.Addon);
						System.out.print("\n");

						System.out.print("Quantity: ");
						System.out.print(Last.Drink_Choosen.Quantity);
						System.out.print("\n");

						System.out.print("Max Waiting Time: ");
						System.out.print(Last.Drink_Choosen.Max_Waiting_Time);
						System.out.print("\n");

						break;
					}

					case 2:
					{
						System.out.print("Others:\n");

						System.out.print("Max Price: ");
						System.out.print(Last.Other_Choosen.Max_Price);
						System.out.print("\n");

						System.out.print("Max Waiting Time: ");
						System.out.print(Last.Other_Choosen.Max_Waiting_Time);
						System.out.print("\n");

						break;
					}

					default:
					{
						System.out.print("Type Wrong, Please Check.\n");
						break;
					}
				}
				Found_Flag = true;
				break;
			}

			Last = Last.next;
		}

		if (Found_Flag == false)
			System.out.print("Object Can't Found!\n");

		else
			System.out.print("Done.\n");
	}

	public void view_all()
	{
		System.out.print("Printing.\n");

		Node Last = First;

		while (Last.next != null)
		{
			switch (Last.Type)
			{
				case 0:// Food
				{
					System.out.print("Food:\n");

					System.out.print("Max Price: ");
					System.out.print(Last.Food_Choosen.Max_Price);
					System.out.print("\n");

					System.out.print("Hot: ");
					System.out.print(Last.Food_Choosen.Hot);
					System.out.print("\n");

					System.out.print("Rice: ");
					System.out.print(Last.Food_Choosen.Rice);
					System.out.print("\n");

					System.out.print("Full: ");
					System.out.print(Last.Food_Choosen.Full);
					System.out.print("\n");

					System.out.print("Max Waiting Time: ");
					System.out.print(Last.Food_Choosen.Max_Waiting_Time);
					System.out.print("\n");

					break;
				}

				case 1:
				{
					System.out.print("Drink:\n");

					System.out.print("Max Price: ");
					System.out.print(Last.Drink_Choosen.Max_Price);
					System.out.print("\n");

					System.out.print("Hot: ");
					System.out.print(Last.Drink_Choosen.Hot);
					System.out.print("\n");

					System.out.print("Addon: ");
					System.out.print(Last.Drink_Choosen.Addon);
					System.out.print("\n");

					System.out.print("Quantity: ");
					System.out.print(Last.Drink_Choosen.Quantity);
					System.out.print("\n");

					System.out.print("Max Waiting Time: ");
					System.out.print(Last.Drink_Choosen.Max_Waiting_Time);
					System.out.print("\n");

					break;
				}

				case 2:
				{
					System.out.print("Others:\n");

					System.out.print("Max Price: ");
					System.out.print(Last.Other_Choosen.Max_Price);
					System.out.print("\n");

					System.out.print("Max Waiting Time: ");
					System.out.print(Last.Other_Choosen.Max_Waiting_Time);
					System.out.print("\n");

					break;
				}

				default:
				{
					System.out.print("Type Wrong, Please Check.\n");
					break;
				}
			}

			Last = Last.next;
		}
		System.out.print("Done.\n");
	}
}
