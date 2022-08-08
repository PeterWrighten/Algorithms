#include<iostream>

void swap(int*, int, int);

int partition(int* vec, int s, int e) {
    int l = s, r = e - 1, pivot = vec[e];
    while(l <= r) {
        while(vec[l] <= pivot && l < e)
            l++;

        while(vec[r] > pivot && r > s)
            r--;
        if(l > r) break;
        swap(vec, l, r);
    }
    swap(vec, l, e);
    return l;
}

void quicksort(int* vec, int s, int e) {
    if(s >=  e) return;
    int next = partition(vec, s, e);
    quicksort(vec, s, next-1);
    quicksort(vec, next+1, e);
}

void swap(int* vec, int l, int r) {
    int tmp = vec[l];
    vec[l] = vec[r];
    vec[r] = tmp;
}

int main() {
    int n;
    std::cout << "How many numbers would you like to input? ";
    std::cin >> n;
    int vec[n];
    std::cout << "input numbers: " << std::endl;
    for(int i = 0; i < n; i++)
        std::cin >> vec[i]; 
    quicksort(vec, 0, n-1);
    for(int i = 0; i < n; i++) {
        std::cout << vec[i] << std::endl;
    }
    return 0;
}
