import java.util.List;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Wichtel
{
	String[] namen;
	Reihenfolge reihenfolge;
	List<Ausnahme> ausnahmen = new ArrayList<>();

	public Wichtel(String[] namen, RunThroughAll iterator)
	{
		this.namen = namen;
		reihenfolge = new Reihenfolge(namen.length, iterator);
	}

	public Wichtel(String[] namen)
	{
		this.namen = namen;
		reihenfolge = new Reihenfolge(namen.length);
	}

	public void addAusnahme(Ausnahme ausnahme)
	{
		ausnahmen.add(ausnahme);
	}

	public void berechneReihenfolge()
	{
		reihenfolge.erstelleAlleReihenfolgen(ausnahmen);
	}

	public void erstelleWichtelpartnerDateien() throws IOException
	{

		int[] besteReihenfolge = reihenfolge.reihenfolge;
		int giftProvider = besteReihenfolge[besteReihenfolge.length - 1];

		for (int i = 0; i < namen.length; i++)
		{
			int giftReceiver = besteReihenfolge[i];
			String fileName = "partner/" + "Wichtelpartner von " + namen[giftProvider] + ".txt";
			File wichtelPartner = new File(fileName);

			try (BufferedWriter writer = new BufferedWriter(new FileWriter(wichtelPartner));)
			{
				writer.write(namen[giftReceiver]);
			}
			giftProvider = giftReceiver;
		}

	}

	public void toAudio()
	{

		int[] besteReihenfolge = reihenfolge.reihenfolge;
		int giftProvider = besteReihenfolge[besteReihenfolge.length - 1];

		for (int i = 0; i < namen.length; i++)
		{
			int giftReceiver = besteReihenfolge[i];

			String outputFileName = "Wichtelpartner von " + namen[giftProvider] + ".mp4";
			String inputFileName = "audio\\" + namen[giftReceiver] + ".mp4";

			File wichtelPartner = new File(outputFileName);

			try (FileOutputStream writer = new FileOutputStream(wichtelPartner);
				FileInputStream reader = new FileInputStream(inputFileName);)
			{
				int n = 0;
				while (n != -1)
				{
					byte[] b = new byte[4096];
					n = reader.read(b);
					if (n != -1)
					{
						writer.write(b, 0, n);
					}
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
				System.out.println("File not found, please make sure that the filePath is correct");
			}
			giftProvider = giftReceiver;
		}

	}

	public static void main(String[] args)
	{
		List<String> namen = new ArrayList<>();
		String eingabe = "";
		Scanner sca = new Scanner(System.in);

		int i = 1;
		while (true)
		{
			System.out.println(namen + "\ntype in your " + i + ". Wichtel\ntype 'end' to finish");
			eingabe = sca.nextLine();
			if (eingabe.equals("end"))
				break;
			namen.add(eingabe);
			i++;
		}
		String[] array = new String[namen.size()];
		namen.toArray(array);
		Wichtel wichtel2 = new Wichtel(array);
		System.out.println("your Wichtel each get a number");
		String output = "";
		i = 0;
		for (String string : namen)
		{
			output += string + " = " + i + ", ";
			i++;
		}
		System.out.println(output
			+ "\nuse this number to give exceptions of combinations you dont want\neg: 0,5 if you dont want 0 to get a gift for 5");
		int weight = 1;
		while (true)
		{
			System.out.println(output + "\nrepeat this process until all the restrictions are applied");
			eingabe = sca.nextLine();
			if (eingabe.equals("end"))
				break;
			String[] avoidance = eingabe.split(",");
			int[] avoidanceInt = new int[avoidance.length];
			try
			{
				for (int j = 0; j < avoidance.length; j++)
				{
					avoidanceInt[j] = Integer.valueOf(avoidance[j]);
				}
				System.out.println(
					"now enter how important this is. The higher the integer the less likely it's gonna happen");
				weight = Integer.valueOf(sca.nextLine());
				wichtel2.addAusnahme(new Ausnahme(avoidanceInt, weight));
			}
			catch (java.lang.NumberFormatException e)
			{
				e.printStackTrace();
				System.out.println("try again. 0,0,0,3,5 allowed 05,,2.5 not");
			}
		}
		wichtel2.berechneReihenfolge();
		try
		{
			wichtel2.erstelleWichtelpartnerDateien();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sca.close();

	}
}
