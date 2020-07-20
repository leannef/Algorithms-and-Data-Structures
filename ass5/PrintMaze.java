public class PrintMaze {
   
   private static void renderTop( boolean b, boolean s ) {
      System.out.print( s?" *":"  " );  System.out.print( b?" |":"  " );
   }

   private static void renderBot(boolean b) {System.out.print( b?"---+":"   +" );}

   public static void displayMaze( Maze m ) {
      renderBot( false );
      for (int c=1; c<=m.getCols(); ++c) renderBot( true );
      System.out.println();
      for (int r=1; r<=m.getRows(); ++r) {
         renderTop( true, false );
         for (int c=1; c<=m.getCols(); ++c) renderTop( m.ok(r,c,2), m.ok(r,c,4) );
         System.out.println();
         renderBot( false );
         for (int c=1; c<=m.getCols(); ++c) renderBot( m.ok(r,c,1) );
         System.out.println();
      }
      
   }
   
}


	if(m[x+1][y]==false || m[x-1][y]==false || m[x][y-1]==false|| m[x][y+1]==false){
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];					
				}
			}

if(ok(x-1,y,2) || ok(x+1,y,0) || ok(x,y-1,1)||ok(x,y+1,3)){
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println("heoll");					
				}
			}
			
			
	public boolean explore(int x,int y){    
		int pathSize = 0;
		int[] path = new int[9999];
		path[0] = m[x][y];
		mypath[0] = m[x][y];
		int temp;
		
		//path[pathSize++] = m[x][y];
		if(x==0 || y==0 || x==rows+1 || y==cols+1){
			return false;
		}
		if(x==rows && y==cols){
			return true;
		}
		while(!visited[x][y+1] || !visited[x+1][y] || !visited[x][y-1] || !visited[x-1][y]){
		
		if(!ok(x,y,0)){  
			pathSize += 1;
			path[pathSize] = m[x][y-1];
			System.out.println("1111");			
			if(ok(x-1,y,2) || ok(x+1,y,3) || ok(x,y-1,0)||ok(x,y+1,2)){
				return false;
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println("heoll");					
				}
				*/
			}
			if(explore(x,y-1)){				
				return true;		
			}
			else{
				return false;			
			}
		}
		
		if(!ok(x,y,1)){
			pathSize += 1;
			path[pathSize] = m[x+1][y];
			System.out.println(path[pathSize]);	
			if(ok(x-1,y,2) || ok(x+1,y,3) || ok(x,y-1,0)||ok(x,y+1,2)){
				return false;
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println("heoll");					
				}
				*/
			}
			
			if(explore(x+1,y)){				
				return true;		
			}else{
			
				return false;			
			}
		}
		
		
		if(!ok(x,y,2)){
			pathSize += 1;
			path[pathSize] = m[x][y+1];
			System.out.println("333");
			if(ok(x-1,y,2) || ok(x+1,y,3) || ok(x,y-1,0)||ok(x,y+1,2)){
				return false;
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println("heoll");					
				}
				*/
			}
			if(explore(x,y+1)){				
				return true;		
			}
			else{
			
				return false;			
			}	
			
		}
		if(!ok(x,y,3)){
			pathSize += 1;
			path[pathSize] = m[x-1][y];
			System.out.println("444");
			if(ok(x-1,y,2) || ok(x+1,y,3) || ok(x,y-1,0)||ok(x,y+1,2)){
				return false;
				/*
				for(int i=0;i<pathSize-1;i++){
					mypath[i] = path[i];
					System.out.println("heoll");					
				}
				*/
			}
			if(explore(x-1,y)){				
				return true;		
			}else{
			
				return false;			
			}
		}
		return false;
		
					
   	}
   	
   	
   	
   	if(explore(x+1,y)){	
				return true;		
			}else if(!explore(x+1,y)&&(explore(x,y+1)||explore(x,y-1)||explore(x-1,y))&&(explore(x,y))){
					return true;
				}else{
				return false;
			}
