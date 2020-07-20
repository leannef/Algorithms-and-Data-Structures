import edu.princeton.cs.algs4.StdIn;

class TestAss1 { 
public static void main ( String[] args ) { 
for (int test=0; test<3; ++test) { 
int N = StdIn.readInt(); 
int M = 2*N+1; 
System.out.println( "N = "+N ); 
int za[] = new int[M]; 
int zb[]; 
int fa[] = new int[N+1]; 
int fb[]; 

for (int i=0; i<M; ++i) za[i] = StdIn.readInt(); 

long t0 = System.currentTimeMillis(); 
ZOrep zo1 = new ZOrep( M, za ); 
long t1 = System.currentTimeMillis(); 
ZOrep zo2 = new ZOrep( zo1.N, zo1.t ); 
long t2 = System.currentTimeMillis(); 
zb = zo2.a; 

// the arrays za zb should be the same. 
// for (int i=0; i<M; ++i) System.out.print( za[i] ); System.out.println(); 
// for (int i=0; i<M; ++i) System.out.print( zb[i] ); System.out.println(); 
boolean pass = true; 
for (int i=0; i<M; ++i) if (za[i] != zb[i]) pass = false; 
System.out.println( "ZO: " + (pass == true ? " PASSED " : "FAILED ")+(t1-t0)+" "+(t2-t1) ); 
for (int i=0; i<N; ++i) fa[i] = StdIn.readInt(); 

t0 = System.currentTimeMillis(); 
FLrep fl1 = new FLrep( N, fa ); 
t1 = System.currentTimeMillis(); 
FLrep fl2 = new FLrep( fl1.N, fl1.t ); 
t2 = System.currentTimeMillis(); 
fb = fl2.a; 

// the arrays fa fb should be the same. 
// for (int i=0; i<N; ++i) System.out.print( fa[i] ); System.out.println(); 
// for (int i=0; i<N; ++i) System.out.print( fb[i] ); System.out.println(); 
pass = true; 
for (int i=0; i<N; ++i) if (fa[i] != fb[i]) pass = false; 
System.out.println( "FL: " + (pass == true ? " PASSED " : "FAILED ")+(t1-t0)+" "+(t2-t1) ); 
} 
} 
}