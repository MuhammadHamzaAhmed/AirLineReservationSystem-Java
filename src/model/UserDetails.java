package model;

import java.util.ArrayList;
import java.util.Collections;

import model.Interface.Strategy;
// Strategy pattern for displaying all user in ascending and descending order
public class UserDetails implements Strategy{
	ArrayList<User> lis;

	@SuppressWarnings("unchecked")
	@Override
	public String[][] getAscending() {
		lis=UserQuery.getAllUser();
		Collections.sort(lis);
		String[][] arr=new String[lis.size()][3];
		for(int i=0;i<lis.size();i++) {
			arr[i][0]=""+lis.get(i).getUserID();
			arr[i][1]=""+lis.get(i).getName();
			arr[i][2]=""+lis.get(i).getPassword();
		}
		return arr;
	}

	@Override
	public String[][] getDescending() {
		lis=UserQuery.getAllUser();
		Collections.sort(lis,Collections.reverseOrder());
		String[][] arr=new String[lis.size()][3];
		for(int i=0;i<lis.size();i++) {
			arr[i][0]=""+lis.get(i).getUserID();
			arr[i][1]=""+lis.get(i).getName();
			arr[i][2]=""+lis.get(i).getPassword();
		}
		return arr;
	}
	
}
