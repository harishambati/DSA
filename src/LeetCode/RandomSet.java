package LeetCode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class RandomSet {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		RandomizedSet rs = new RandomizedSet();
//		System.out.println(rs.insert(0));
//		System.out.println(rs.insert(1));
//		System.out.println(rs.remove(0));
//		System.out.println(rs.insert(2));
//		System.out.println(rs.remove(0));
//		System.out.println(rs.getRandom());
//	
		
		RandomizedSet randomizedSet = new RandomizedSet();
		
		
		System.out.println(       randomizedSet.insert(1)                 );
		System.out.println( 	randomizedSet.remove(2)	);
		System.out.println( 	randomizedSet.insert(2) );
		System.out.println(      randomizedSet.getRandom()       );
		System.out.println(		randomizedSet.remove(1)			);
		System.out.println(     randomizedSet.insert(2)                );
		System.out.println(   randomizedSet.getRandom()         );
		
	
	
	}

}



class RandomizedSet 
{
    HashMap<Integer, Integer> hmn ;
    HashMap<Integer, Integer> hmi ;
    Random random ;
    ArrayList<Integer> list;

    public RandomizedSet() {
        hmn = new HashMap<>();
        hmi = new HashMap<>();
        random = new Random();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) 
    {
        if(hmn.containsKey(val))
        {
            return false;
        }

        int index = list.size();

        hmn.put(val, index);
        hmi.put(index, val);
        list.add(val);

        return true;
    }
    
    public boolean remove(int val) 
    {
        if(!(hmn.containsKey(val)))
        {
            return false;
        }

        int index = hmn.get(val);
        int last_index = list.size() -1;
        
        int temp = list.get(last_index);
        
      //  list.add(last_index, val);
        list.add(index, temp);
        list.remove(last_index);
        hmn.remove(val);
        hmn.put(temp, index);
       

        return true;

    }
    
    public int getRandom() 
    {
        
        int min = 0;
        int max = list.size();
        int index = random.nextInt(max - min) + min;
        
       return list.get(index);
    }

    public void balance(int index)
    {
        for(int i = index; i <= list.size(); i++ )  {
            int temp = hmi.get(i);
            hmi.remove(i);
            hmn.remove(temp);
        
        }  

        for(int i = index; i < list.size(); i++ )  {
          //  insert(list.get(i));
              hmn.put(list.get(i), i);
              hmi.put(i ,  list.get(i));
        }
    }  

}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */