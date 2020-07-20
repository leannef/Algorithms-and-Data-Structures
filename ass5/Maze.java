/*============================================================*/
//      8
//    1 * 4    <-- encodings of various directions around a cell
//      2
//
//      +--+--+    +--+--+
//      |     |    |11 12|    11  12   a maze and its representation
//      +--+  +    +--+  +
//      |     |    |11 06|    11  06
//      +--+--+    +--+--+
//
//     16 16 16 16   initial maze contents returned by constructor
//     16 15 15 16
//     16 15 15 16
//     16 16 16 16
//
/*============================================================*/
import java.util.Random;

public class Maze {
   
	private int[][] m;   // maze representation
	private int rows;    // number of rows in the maze
	private int cols;    // number of columns in the maze
	private final static byte[] TWO = { 1, 2, 4, 8, 16};
	private final static byte[] DX  = { 0,+1, 0,-1};
	private final static byte[] DY  = {-1, 0,+1, 0};
	private boolean done;  // used in finding a single solution.
	private long   count;  // used in finding the number of solutions.
	private Random r;      // for generating random integers.
	private int[] path = new int[9999];
	private int[] mypath = new int[9999];
    private int pathSize =0;
	
	
	public int getRows() { 
		return( rows ); 
	}
	public int getCols() { 
		return( cols ); 
	}
	
	//initial maze
	public Maze ( int nr, int nc, int seed ) {
		r = new Random( seed );
    	rows = nr;  
    	cols = nc;
    	m = new int[nr+2][nc+2];
    	for (int r=1; r<=nr; ++r )
        	for (int c=1; c<=nc; ++c )
            	m[r][c] = 15;
      	for (int r=0; r<nr+2; ++r )
        	m[r][0] = m[r][nc+1] = 16;
      	for (int c=0; c<nc+2; ++c )
        	m[0][c] = m[nr+1][c] = 16;
      	Create( nr/2+1, nc/2+1, 0 );
   }

   // Wall in direction p?  
   //current number = TWO[p], always return true;
	public boolean ok ( int x, int y, int p ) {
		return( (m[x][y] & TWO[p]) == TWO[p] );
   	}

	private boolean downWall( int x, int y, int p ) {
    	if (ok(x,y,p) && m[x+DX[p]][y+DY[p]] != 16) {
    		m[x][y] ^= TWO[p];  //current number-TWO[P]
    		m[x+DX[p]][y+DY[p]] ^= TWO[p^2];
        	return true;
      	}
    	return false;
   }
   
	private void knockDown( int count ) {
      // Caution: make sure there are at least count walls!
    for (int i=0; i<count; ++i) {
	    int x = 1+r.nextInt(rows);
        int y = 1+r.nextInt(cols);
        if (!downWall( x, y, r.nextInt(4))) 
        	--i;
      	}
   	}
   
	private void Create ( int x, int y, int val ) {
	int[] perm = randPerm( 4 );
	m[x][y] ^= val;  
	for (int i=0; i<4; ++i) {
    	int p = perm[i];
        if (m[x+DX[p]][y+DY[p]] == 15) {
        	m[x][y] ^= TWO[p];  
            Create( x+DX[p], y+DY[p], TWO[p^2] );
        }
    }
   	}

	private int[] randPerm( int n ) {
      // This algorithm should look familiar!
    	int[] perm = new int[n];
    	for (int k=0; k<n; ++k) 
    		perm[k] = k;
    	for (int k=n; k>0; --k) {
        	int rand = r.nextInt(k);
        	int t = perm[rand];  
        	perm[rand] = perm[k-1];  
        	perm[k-1] = t;
      	}
      	return( perm );
   }
   
	public String toString() {
    	String result = "\n";
    	for(int i =1;i<rows+1;i++){
    		for(int j =1;j<cols+1;j++){
    			if(m[i][j+1]>=10){
    				result +=  m[i][j]+ " "+""; 
    			}else{
    				result +=  m[i][j]+ "  "+"";
    			}			
    		}
    		result +="\n";
    	}
      	return result;
   	}


	public void solveMaze() {
		path[0] = 9;
		mypath[0] = 9;
		if(explore(1,1)){
			for(int i =0; i<rows+1;i++){
				for(int j =0; j<cols+1;j++){
					for(int k=0; k<mypath.length;k++){
						if(m[i][j] == mypath[k]){
							m[i][j] +=16;						
						}
					}		
				}
			}
		}
		
	}
	

	public boolean explore(int x,int y){    
	
		//path[pathSize++] = m[x][y];
		if(x==0 || y==0 || x==rows+1 || y==cols+1){
			return false;
		}
		if(x==rows && y==cols){
			return true;
		}	
		if(!ok(x,y,0)){  
			pathSize += 1;
			path[pathSize] = m[x][y-1];
			y = y-1;
			//System.out.println("left "+path[pathSize]);			
			if(ok(x,y-1,1) && ok(x,y-1,2) &&ok(x,y-1,3)){
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println(mypath[0]);					
				}
				*/
				return false;
			}
			//explore(x,y);	
			return true;		
		}
		
		if(!ok(x,y,1)){
			pathSize += 1;
			path[pathSize] = m[x+1][y];
			x=x+1;
			//System.out.println("down "+path[pathSize]);	
			if(ok(x+1,y,1) && ok(x+1,y,2) &&ok(x+1,y,3)){
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println(mypath[0]);					
				}
				*/
				return false;
			}
			//explore(x,y);
			return true;
			
		}
		
		
		if(!ok(x,y,2)){
			pathSize += 1;
			path[pathSize] = m[x][y+1];
			y=y+1;
			//System.out.println("right"+path[pathSize]);
			if(ok(x,y+1,1) &&ok(x,y+1,2) &&ok(x,y+1,3)){
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println(mypath[0]);					
				}
				*/
				return false;				
			}
			//explore(x,y);
			return true;
		}
		if(!ok(x,y,3)){
			pathSize += 1;
			path[pathSize] = m[x-1][y];
			x=x-1;
			//System.out.println("up"+path[pathSize]);
			if(ok(x-1,y,1) && ok(x-1,y,2)&&ok(x-1,y,3)){
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println(mypath[0]);					
				}
				*/
				return false;
				
			}
			//explore(x,y);
			return true;
		}
		return false;
					
   	}
      
   	public long numSolutions() {
   		int result = 1;
    	return result;
   	}
   
	public static void main ( String[] args ) {
    	int row = Integer.parseInt( args[0] );
    	int col = Integer.parseInt( args[1] );
    	Maze maz = new Maze( row, col, 9999 );
    	System.out.print( maz );
    	System.out.println( "Solutions = "+maz.numSolutions() );
    	maz.knockDown( (row+col)/4 );
      	System.out.print( maz );
      	System.out.println( "Solutions = "+maz.numSolutions() );
      	maz = new Maze( row, col, 9999 );  // creates the same maze anew.
      	maz.solveMaze();
      	System.out.print(maz);
   	}
}
