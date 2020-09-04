```java
static int N;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++) {
            N = sc.nextInt();
            arr = new int[N];
            used = new boolean[N];
            memo = new int[1<<N][1<<N];
            for(int i = 0; i < N; i++)
                arr[i] = sc.nextInt();
             
            System.out.println("#"+tc+" "+perm(0,0,0,0,0));
        }
        sc.close();
    }
     
    static boolean[] used;
    static int[][] memo;
    static int perm(int idx, int lv, int rv, int l, int r) {
        if(idx == N) return 1;
        if(memo[l][r] != 0) return memo[l][r];
         
        int ret = 0;
        for(int i = 0; i < N; i++) {
            if(used[i]) continue;
            used[i] = true;
            ret += perm(idx+1,lv+arr[i],rv,l | 1<<i,r);
            if(lv >= rv+arr[i]) {
                ret += perm(idx+1,lv,rv+arr[i],l,r | 1<<i);
            }
            used[i] = false;
        }
        memo[l][r] = ret;
        return ret;
    }
```