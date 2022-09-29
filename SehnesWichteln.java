import java.io.IOException;

public class SehnesWichteln
{
	public static void main(String[] args)
	{
		{
			Wichtel wichtel = new Wichtel(
				new String[] { "Philipp", "Julian", "Viviane", "Siegfried", "Veronika", "Andreas", "Mama", "Papa" });
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 3, 1, 2, 4, 5, 6, 7, 0 }, 1));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 3, 7, 2, 6, 1, 5, 4, 0 }, 1));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 5, 6, 2, 4, 1, 7, 3, 0 }, 2));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 2, 5, 3, 1, 7, 6, 4, 0 }, 3));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 4, 1, 6, 2, 7, 3, 5, 0 }, 5));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 1, 3, 2, 5, 7, 4, 6, 0 }, 8));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 4, 7, 5, 2, 3, 6, 1, 0 }, 13));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 6, 5, 1, 4, 3, 7, 2, 0 }, 21));
			wichtel.addAusnahme(new Ausnahme(new int[] { 0, 7, 1, 5, 4, 2, 6, 3, 0 }, 34)); //Wichtelkreis 2021
			wichtel.berechneReihenfolge();

			Wichtel wichtel2 = new Wichtel(
				new String[] { "Philipp", "Julian", "Viviane", "Siegfried", "Veronika", "Andreas", "Mama", "Papa" },
				new allRunThrough());
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 3, 1, 2, 4, 5, 6, 7, 0 }, 1));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 3, 7, 2, 6, 1, 5, 4, 0 }, 1));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 5, 6, 2, 4, 1, 7, 3, 0 }, 2));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 2, 5, 3, 1, 7, 6, 4, 0 }, 3));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 4, 1, 6, 2, 7, 3, 5, 0 }, 5));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 1, 3, 2, 5, 7, 4, 6, 0 }, 8));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 4, 7, 5, 2, 3, 6, 1, 0 }, 13));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 6, 5, 1, 4, 3, 7, 2, 0 }, 21));
			wichtel2.addAusnahme(new Ausnahme(new int[] { 0, 7, 1, 5, 4, 2, 6, 3, 0 }, 34));
			wichtel2.berechneReihenfolge();

			try
			{
				wichtel2.erstelleWichtelpartnerDateien();
				wichtel2.toAudio();
			}
			catch (IOException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
