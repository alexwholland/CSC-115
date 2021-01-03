/*
 *
 */

import java.util.Random;

public class Performance {
    public static final int LINKED =0;
    public static final int BST =1;
    public static final int HASH =2;


    static int	adtType;
    static int	iterations;

    static int count = 0;

    public static void doPut (int n, Random r, Map<Integer,Integer> m) {
        for (int i = 0; i < n; i++) {
            m.put(r.nextInt(), r.nextInt());
        }
    }

    public static void doGet (int n, Random r, Map<Integer, Integer> m ) {
        for (int i = 0; i < n; i++) {
            try {
                // Note that it is extremely likely that this value isn't in the Map
                // so this search is probably the worst case, and results in a
                // KeyNotFoundException being thrown.
                int search = r.nextInt();

                m.get(search);
            }
            catch (KeyNotFoundException e) {
                count ++;
//                System.out.println("key not found" + count);


            }
        }
    }

    public static void printStats (int iterations, long seed, Map<Integer, Integer> m, int type) {
        System.out.println ("[" + seed +
                (type==LINKED ? " linked" : type==BST ? " bst" : " hash") +
                "] put loop count: " + m.getPutLoopCount());
        System.out.println ("[" + seed + (type==LINKED ? " linked" : type==BST ? " bst" : " hash") +
                "] get loop count: " + m.getGetLoopCount());
    }

    public static void doTests() {
        System.out.println("Doing initial tests:");
        Map<Integer, Integer>	bstMap    = new BSTMap<Integer, Integer>();
        Map<Integer, Integer>	linkedMap = new LinkedMap<Integer, Integer>();
        Map<Integer, Integer>   hashMap   = new HashMap<Integer, Integer>();

        Random	r = new Random(128);	// by hardcoding the seed, we get the same numbers every time
        count=0;
        doPut(1000, r, linkedMap);
        System.out.println("****: " + count);

        count = 0;
        doGet(1000, r, linkedMap);
        System.out.println("****: " + count);

        count = 0;
        doPut(1000, r, bstMap);
        System.out.println("****: " + count);

        count = 0;
        doGet(1000, r, bstMap);
        System.out.println("****: " + count);

        count = 0;
        doPut(1000, r, hashMap);
        System.out.println("**** after put: " + hashMap.entryList() +":"+ count);


        //r = new Random(128);
        count = 0;
        doGet(1000, r, hashMap);
        System.out.println("**** after get: " + hashMap.entryList() +":"+ count);

        System.out.println ("Your solution should match exactly for linked and be comparable for BST and Hash.");
        System.out.println ("-- Instructor's solution: ");
        System.out.println ("[128 linked] put loop count: 499500");
        System.out.println ("[128 linked] get loop count: 1000000");
        System.out.println ("[128 bst   ] put loop count: 11079");
        System.out.println ("[128 bst   ] get loop count: 12952");
        System.out.println ("[128 hash  ] put loop count: 1");
        System.out.println ("[128 hash  ] get loop count: 0");

        System.out.println ("--\n");
        System.out.println ("--Your solution: ");
        printStats(1000, 128, linkedMap, LINKED);
        printStats(1000, 128, bstMap, BST);
        printStats(1000, 128, hashMap, HASH);
        System.out.println ("--");
    }

    public static void main (String[] args) {
        if (args.length != 2) {
            System.out.println ("Usage: java Performance {linked | tree } iterations.");
            System.out.println ("  if iterations == 0, simple tests will be run.");
            return;
        }
        iterations = Integer.parseInt(args[1]);
        if (args[0].equals("linked"))
            adtType=LINKED;
        else if (args[0].equals("bst"))
            adtType=BST;
        else
            adtType=HASH;

        if (iterations == 0) {
            doTests();
        }
        else {
            long seed = System.currentTimeMillis();
            Random r = new Random(seed);
            System.out.println ((adtType==LINKED ? " linked" :
                    (adtType==BST ? " bst   ": " hash ")) + "map over " + iterations + " iterations.");
            Map<Integer, Integer> m;

            if (adtType == LINKED)
                m = new LinkedMap<Integer, Integer>();
            else if (adtType == BST)
                m = new BSTMap<Integer, Integer>();
            else
                m = new HashMap<Integer, Integer>();

            doPut(iterations, r, m);
            doGet(iterations, r, m);
            printStats(iterations, seed, m, adtType);
        }
    }
}
