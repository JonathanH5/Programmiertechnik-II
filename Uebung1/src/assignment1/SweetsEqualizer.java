package assignment1;

public class SweetsEqualizer {
    public static int minOperationCount(int[] s) {
//    	Parametercheck
    	testing(s);
    	int counter = 0;
        int max;
//        	solange nicht gleichverteilt
        	while(!equalS(s)){
        	max=findMaximum(s);
//        	verteile S�ssigkeiten
        	s=erraseS(s,max);
//        	z�hle Schritte
        	counter++;
        }
        return counter; 
    }
    
//  findet Index eines Maximums
    public static int findMaximum(int[] s){
    	int max=0; 
    	for (int snumber=0;snumber<s.length;snumber++){
         	if(s[snumber]>s[max]){
         		max=snumber;
         	}
         }
    	return max;
    }
    
//  verteilt S�ssigkeiten an alle au�er max
    public static int[] erraseS(int[] s,int max){
    	for(int snumber=0;snumber<s.length;snumber++){
    		if(snumber!=max){
    			s[snumber]++;
    		}
    	}    		
    	return s;
    }
    
//  Test f�r Gleichverteilung von S�ssigkeiten (Abbruchbedingung)
    public static boolean equalS(int[] s){
    	for(int sweetsnumber:s){
    		if(sweetsnumber!=s[1]){
    			return false;
    		}
    	}
    	return true;  
    }
    
//  Parametercheck f�r �bergebenes Array
    public static void testing(int[] s){
    	if(s.length<1||s.length>=200)throw new IllegalArgumentException("Wrong count of kids!(1-199)");
    	for(int snumber:s){
    		if(snumber<0||snumber>50000) throw new IllegalArgumentException("Wrong count of sweets!(0-50000)");
    	}
    }
}
