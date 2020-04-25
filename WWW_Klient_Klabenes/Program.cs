using System;

namespace WWW_Klient_Klabenes
{
	public class Program
	{
		public static void Main()
		{
			Klient();
			Console.ReadKey();

		}

		public static void Klient()
		{
			Stag.GeneratedNg_predmetyServiceClient client = new Stag.GeneratedNg_predmetyServiceClient();
			var resp = client.searchSimplePredmetyAsync("", "", "", "", "NNPI", "", "", "", "", "", "", "", "", "","");

			foreach (var predmet in resp.Result.ws_stag_predmety_SearchSimplePredmety)
			{
				Console.WriteLine(predmet.zkrPredm + " "+predmet.nazev+" "+predmet.rokVarianty);
			}
		}
	}
}
