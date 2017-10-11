package lecture10;

import java.util.ArrayList;

public class mazepaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(mazepaths1(0, 0, 5, 5).size());
		//printperm("abc","");
		printbpath(0,20,"");
		//pkp("123","");
		//mazepath(0,0,2,2,"");

	}
	
	public static void printbpath(int cur,int end,String ans)
	{
		if(cur==end)
		{
			System.out.println(ans);
			return;
		}
		if(cur>end)
		{
			return;
		}
		
		for(int i=1;i<=6;i++)
		{
			printbpath(cur+i,end,ans+i);
		}
	}
	
	public static void pkp(String q,String a)
	{
		if(q.length()==0)
		{
			System.out.println(a);
			return;
		}
		char ch=q.charAt(0);
		String roq=q.substring(1);
		String str=getcode(ch);
		for(int i=0;i<str.length();i++)
		{
			pkp(roq,a+str.charAt(i));
			
		}
		
		
	}
	
	public static void mazepath(int cr,int cc,int er,int ec,String ans)
	{
		if((cr==er)&&(cc==ec))
		{
			System.out.println(ans);
		}
		if((cr>er)||(cc>ec))
		{
			return;
		}
		
		mazepath(cr+1,cc,er,ec,ans+"V");
		mazepath(cr,cc+1,er,ec,ans+"H");
		mazepath(cr+1,cc+1,er,ec,ans+"D");
	}
	
	public static String getcode(char key) {
		if (key == '1') {
			return "abc";
		}
		if (key == '2') {
			return "def";
		}
		if (key == '3') {
			return "ghi";
		}
		if (key == '4') {
			return "jkl";
		}
		if (key == '5') {
			return "mno";
		}
		if (key == '6') {
			return "pqrs";
		}
		if (key == '7') {
			return "tuv";
		}
		if (key == '8') {
			return "wx";
		}
		if (key == '9') {
			return "yz";
		}
		if (key == '0') {
			return ".;";
		}
		return null;
	}
	
	public static void printperm(String q,String a){
		if(q.length()==0)
		{
			System.out.println(a);
			return;
		}

		for(int i=0;i<q.length();i++)
		{
			String roq=q.substring(0,i)+q.substring(i+1);
			printperm(roq,a+q.charAt(i));
		}
		
		
		
	}
	
	public static void printsswascii(String q,String a){
		if(q.length()==0)
		{
			System.out.println(a);
			return;
		}
		
		char ch=q.charAt(0);
		String roq=q.substring(1);
		printsswascii(roq,a);
		printsswascii(roq,a+ch);
		printsswascii(roq,a+(int)ch );
	}

	public static ArrayList<String> mazepaths1(int cr, int cc, int er, int ec) {

		if ((cr == er) && (cc == ec)) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if ((cr > er) || (cc > ec)) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int i = 1; i <= ec; i++) {

			ArrayList<String> rrh = mazepaths1(cr, cc + i, er, ec);
			for (String rs : rrh) {
				mr.add("H" + i + rs);
			}
		}
		for (int j = 1; j <= er; j++) {

			ArrayList<String> rrv = mazepaths1(cr + j, cc, er, ec);
			for (String rs : rrv) {
				mr.add("V" + j + rs);
			}
		}

		
		 for (int k = 1; k<=er; k++) {
		 ArrayList<String> rrd = mazepaths1(cr + k, cc + k, er, ec);
		 for (String rrx : rrd) {
		 mr.add("D" +k+ rrx);
		 }
		 }
		 
		return mr;
	}

	public static ArrayList<String> mazepaths(int cr, int cc, int er, int ec) {

		if ((cr == er) && (cc == ec)) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}
		if ((cr > er) || (cc > ec)) {
			ArrayList<String> br = new ArrayList<>();
			// br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rrh = mazepaths(cr, cc + 1, er, ec);
		for (String rs : rrh) {
			mr.add("H" + rs);
		}

		ArrayList<String> rrv = mazepaths(cr + 1, cc, er, ec);
		for (String rs : rrv) {
			mr.add("V" + rs);
		}

		if ((cr == cc) || (cr + cc == ec)) {
			ArrayList<String> rrd = mazepaths(cr + 1, cc + 1, er, ec);
			for (String rrx : rrd) {
				mr.add("D" + rrx);
			}
		}
		return mr;
	}

}
