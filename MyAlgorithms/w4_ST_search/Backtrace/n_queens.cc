#include <vector>
#include <cmath>
#include <iostream>
typedef long long ll;

std::vector<ll> x;

ll n;

bool canPlace(ll k) {
    for(ll i = 0; i < k; i++) {
        if(x[k] == x[i] || std::abs(x[i] - x[k]) == std::abs(i - k)) {
            return false;
        }
    }

    return true;
}

ll recursive_backtrace(ll k, ll n) {
    ll sum = 0;

    if(k == n) {
        return 1;
    }

    for(ll j = 0; j < n; j++) {
        x[k] = j;
        if(canPlace(k)) {
            sum += recursive_backtrace(k+1, n);
        }
    }

    return sum;
}

ll iter_backtrace(ll n) {
    ll sum = 0;
    ll k = 0;
    std::vector<ll> x(n);    
    while(k > -1) {
        if(k == n) {
            sum++;
            k--;
            continue;
        }

        if(x[k] < n) {
            if(canPlace(k)) {
                k++;
            }
        } else {
            x[k] = 0;
            k--;
        }
        x[k]++;
    }

    return sum;
}

int main() {
    std::cin >> n;
    x.resize(n);

    std::cout << "Recursive: " << recursive_backtrace(0, n) << std::endl;

    std::cout << "Iterate: " << iter_backtrace(n) << std::endl;
    
    return 0;
}
