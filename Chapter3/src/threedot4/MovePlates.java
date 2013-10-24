package threedot4;

/*        CareerCup 3.4
 * 
 * In the classic problem of the Towers of Hanoi, you have 3 towers and N disks of different 
 * sizes which can slide onto any tower. The puzzle starts with disks sorted in ascending order
 *  of size from top to bottom (i.e., each disk sits on top of an even larger one). You have the following constraints:
 *  (1) Only one disk can be moved at a time.
 *  (2) A disk is slid off the top of one tower onto the next tower.
 *  (3) A disk can only be placed on top of a larger disk.
 *  Write a program to move the disks from the first tower to the last using stacks.
 *  
 *  f(n) = 2 f(n-1) + 1
 *  f(N) = O(2^N)
 *  
 *  useful link : http://blog.csdn.net/xujinsmile/article/details/8091738
 *  此人代码写的有点混乱。。。。
 *  
 *  对递归的认识还不够。。。别人写的代码能看懂，自己想就跪了。。。。。。。
 * */

public class MovePlates {
	public static void main(String[]args) throws Exception{
        int n =3;
        String a = "TowerA";
        String b = "TowerB";
        String c = "TowerC";
        hanoi(n,a,c,b);
        
}
//move n plates form a to c with the help of b
	public static void hanoi(int n, String origin, String destination , String buffer ){
		if(n > 0){
			hanoi(n - 1, origin,buffer,destination);
			move(origin,destination);
            hanoi(n - 1 , buffer, destination, origin);
		}
	}
	
	public static void move(String origin, String desination){
		System.out.println(origin +"----->"+ desination);
	}
}
