package main.java;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main
{
	public static void main(String[] args)
	{
		String baseUrl = "http://localhost:8080";
		String neptun = "NZ7PNG";
		try
		{
			BufferedReader br = new BufferedReader(new FileReader(new File("resources/tesztek")));
			String line = "";
			while ((line = br.readLine()) != null)
			{
				String[] commands = line.split(" ");
				String method = commands[0];
				String url = commands[1];
				String accept = br.readLine();
				String contentType = accept.split(" ")[1];
				String requestBody = br.readLine();
				if (requestBody == null)
					requestBody = "";
				requestBody = requestBody.replace("\"", "\"\"");
				String responseBody = br.readLine();
				ProcessBuilder pb;
				if (!requestBody.equals(""))
				{
					pb = new ProcessBuilder("curl", "--header", accept, "--header", "Content-Type: " + contentType,
							"--request", method, "--data", requestBody, baseUrl + url.replace("NEPTUN", neptun));
				} else
				{
					pb = new ProcessBuilder("curl", "--header", accept, "--header", "Content-Type: " + contentType,
							"--request", method, baseUrl + url.replace("NEPTUN", neptun));
				}
				Process p = pb.start();
				p.waitFor();
				BufferedReader br2 = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String output = br2.readLine();
				br2.close();
				p.destroy();
				if (output == null)	output = "";
				if(!responseBody.equals(output)) System.out.println(pb.command() + "\nElvárt: " + responseBody + "\nKapott: " + output + "\n\n");

			}
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{			
			e.printStackTrace();
		}
	}
}
