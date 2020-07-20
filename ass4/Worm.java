package ass4;
import edu.princeton.cs.algs4.*;

public class Worm {
	private final int x;
    private final int y;
    private final int z;
    
    public int x() { 
    	return x; 
    }
    
    public int y() { 
    	return y; 
    }
    
    public int z() { 
    	return z; 
    }
    
	public Worm( In in ) { 
		x = in.readInt();
	    y = in.readInt();
	    z = in.readInt();
	}
	        
	      // Create a new problem instance.
	public double dist( String origP, String destP ) {
		double x1 = origP.x - destP.x;
		double
		return d1;
	      // return the distance from origP to destP
	}
	
	public int   worms( String origP, String destP ) { 
		int p = 0;
		return p;
	      // least number of wormholes in any shortest path from origP to destP
	}
	
	public String query( String origP, String destP ) {
		  
		return "The distance from"+ origP+"to"+destP+"is"+ 89894 +"parsecs using"
				   + 0 + "wormholes.";
	      // Output the "The distance from ... wormholes." string.
	   }
	  
	public static void main(String[] args) {
	      // You can test your program with something like this.
		In in = new In( args[0] );
	    int T = in.readInt();
	    for (int t=1; t<=T; t++) {
	    	System.out.println("Case " + t + ":") ;
	        Worm w = new Worm( in );
	        int Q = in.readInt() ;
	        for (int i=0; i<Q; i++) {
	        	String p1s = in.readString() ;
	            String p2s = in.readString() ;
	            System.out.println( w.query( p1s, p2s ) ) ;
	         }
	      }
	   }
	}
