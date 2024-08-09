package LeetCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class isPalindrome {
	
	public static void main(String[] args) {
		generateParenthesis(3);
	}
	
	
    public static List<String> generateParenthesis(int n) {

            List<String> ans = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            genParanthesisHelper(ans, n, sb);

            return ans;

    }

    public static void genParanthesisHelper(List<String> ans, int n, StringBuilder s){

        if(s.toString().length() == 1 && s.toString().charAt(0) == ')' )
        {
            return;
        }

        if(s.toString().length() == (n * 2))
        {
            boolean check = isValid(s.toString());

            if(check)
            {
                ans.add(s.toString());
                
            }
            return;
        }
           
            for( int i = 0; i < 1  ; i++)
            {
                
                s.append('(');
                genParanthesisHelper(ans, n, s);
                s = s.deleteCharAt(s.toString().length() -1);
                s.append(')');
                genParanthesisHelper(ans, n, s);
                s = s.deleteCharAt(s.toString().length() -1);


            }


    }

    public static boolean isValid(String s) {

        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char temp = s.charAt(i);

            if (temp == '(') {
                st.push(temp);
            }

            else {
             

                if((st.size() == 0))
                {
                    
                    return false;
                }

                int temp2 = st.peek();

                if (temp == ')') {

                    if (temp2 == '(') {
                        st.pop();
                    }
                     else{
                        return false;
                    }
                }

                else {
                    return false;
                }
            }

        }

        if (st.size() > 0) {
            return false;
        }

            return true;
        

    }

}