package w1_quickunion.quick_find;


class binarysearch{
	public int search(int[] a, int key){
		int l0 = 0, r0 = a.length - 1;
		while(l0 <= r0){
			int mid = l0 + (r0 - l0) / 2;
			if(key < a[mid]){
				r0 = mid - 1;
			}else if(key > a[mid]){
				l0 = mid + 1;
			}else{
				return mid;
			}
		}
		return -1;

	}
}
