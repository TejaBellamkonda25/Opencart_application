package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
@DataProvider(name = "username_passwords")
 public String[][] getData() throws IOException{
	String path = ".\\testdata\\username_passwords.xlsx";
	Excelutility utility = new Excelutility(path);
	
	int totalrows = utility.getRowCount("Sheet1");
	int totalcols = utility.getCellCount("Sheet1",1);
	
	String username_passwords[][]= new String[totalrows][totalcols];
	
	for(int i=1;i<=totalrows;i++) {
		for(int j=0; j<totalcols;j++)
		{
			username_passwords[i-1][j]=utility.getCellData("Sheet1", i, j);
		}
	}
	return username_passwords;

}
}
