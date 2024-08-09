package LeetCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

public class WordSearch2 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'}};
		String[] words = {"oath","pea","eat","rain"};
//		char[][] board = {{'a', 'b'}, {'c','d'}};
//		String[] words = {"abcd"};
		
		   int max = words[0].length();
	        for(String w : words){
	            max = Math.max(max, w.length());
	        }
	        HashSet<String> hs_words = new HashSet<>();
			HashMap<Character, Integer> hs_chars = new HashMap<>();
			for(String i: words) 
	        {       
	            if(hs_chars.containsKey(i.charAt(0)))
	            {
	                	hs_chars.put(i.charAt(0), hs_chars.get(i.charAt(0)) + 1 );
	            }
	            else{
	                hs_chars.put(i.charAt(0), 1);
	            }
				
				hs_words.add(i);
			}
			
			List<String> ans = new ArrayList<>();
			StringBuffer sb = new StringBuffer();
			
	        for(int i = 0; i < board.length; i++) {
				for(int j = 0; j < board[0].length; j++) {
					
					if(hs_chars.containsKey(board[i][j])  ){
						sb.append(board[i][j]);
	                    char restore_val = board[i][j]; 
	                    board[i][j] = 'A';
						getWords(board,ans, hs_words, sb, i , j, max);
	                    board[i][j] = restore_val;
	                    sb.deleteCharAt(sb.length() -1);
						
	                    }
					}
				
			}

	        //return ans;
	        int x = 0;
	}

	
	 private static void getWords(char[][] board, List<String> ans, 
				HashSet<String> hs_words, StringBuffer sb, int i , int j, int max) {
			
	        // if(sb.toString().length() > max){
	        //     return;
	        // }

			if(sb.length() > 0 && hs_words.contains(sb.toString())){
				String temp = sb.toString() ;
	       //     ans.add("String");
				ans.add(temp);
				hs_words.remove(temp);

			}

	        
			
			if( i -1 >= 0 && board[i - 1][j] != 'A')
			{	
			
	            char restore_val = board[i - 1][j]; 
	            board[i - 1][j] = 'A';
	            sb.append(restore_val);
				getWords(board,ans, hs_words, sb, i -1, j,max);
				sb.deleteCharAt(sb.length() -1);
	            board[i - 1][j] = restore_val;
			}
			
			if( j + 1 < board[0].length && board[i][j + 1] != 'A' )
			{	
				
	            char restore_val = board[i][j + 1]; 
	            board[i][j + 1] = 'A';
	            sb.append(restore_val);
				getWords(board,ans, hs_words, sb, i, j +1, max);
				sb.deleteCharAt(sb.length() -1);
	            board[i][j + 1] = restore_val;
	        }
			
			if( i + 1 < board.length &&  board[i+1][j] != 'A'  )
			{	
	            char restore_val = board[i+1][j]; 
	            board[i+1][j] = 'A';
				sb.append(restore_val);
				getWords(board,ans, hs_words, sb, i +1, j, max);
				sb.deleteCharAt(sb.length() -1);
	             board[i+1][j] = restore_val;
			}
			
			if( j-1>=0 &&  board[i][j-1] != 'A')
			{	
				char restore_val = board[i][j-1]; 
	            board[i][j-1] = 'A';
	            sb.append(restore_val);
				getWords(board, ans, hs_words, sb, i, j-1, max);
				sb.deleteCharAt(sb.length() -1);
	            board[i][j-1] =  restore_val;
			}
			
		}
	
	
//	private static void getWords(char[][] board, String[] words, List<String> ans, HashSet<String> hs,
//			HashSet<String> hs_words, StringBuffer sb, int i , int j) {
//		
//		if(sb.length() > 0 && hs_words.contains(sb.toString())){
//			String temp = sb.toString() ;
//			ans.add(temp);
//			hs_words.remove(temp);
//		}
//		
//		if( i -1 >= 0 && !(hs.contains((i-1)+","+(j))))
//		{	
//			
//			hs.add((i-1)+","+(j));
//			sb.append(board[i-1][j]);
//			getWords(board, words, ans, hs, hs_words, sb, i -1, j);
//			sb.deleteCharAt(sb.length() -1);
//			hs.remove((i-1)+","+(j));
//		}
//		
//		if( j + 1 < board[0].length && !hs.contains((i)+","+(j+1)))
//		{	
//			
//			hs.add((i)+","+(j+1));
//			sb.append(board[i][j+1]);
//			getWords(board, words, ans, hs, hs_words, sb, i, j +1);
//			sb.deleteCharAt(sb.length() -1);
//			hs.remove((i)+","+(j+1));
//		}
//		
//		if( i + 1 < board.length && !hs.contains((i+1)+","+(j)))
//		{	
//			
//			hs.add((i+1)+","+(j));
//			sb.append(board[i+1][j]);
//			getWords(board, words, ans, hs, hs_words, sb, i +1, j);
//			sb.deleteCharAt(sb.length() -1);
//			hs.remove((i+1)+","+(j));
//		}
//		
//		if( j-1>=0 && !hs.contains((i)+","+(j-1)))
//		{	
//			
//			hs.add((i)+","+(j-1));
//			sb.append(board[i][j-1]);
//			getWords(board, words, ans, hs, hs_words, sb, i, j-1);
//			sb.deleteCharAt(sb.length() -1);
//			hs.remove((i)+","+(j-1));
//		}
//		
//	}

}


