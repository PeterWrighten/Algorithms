#include <cmath>

typedef long long ll;

template <typename T, typename F>
T bisection(F f, T lef, T righ) {

    auto cond = f(lef) * f(righ);

    if(cond == 0) {
        return lef;       
    } else if(cond < 0) {
        auto inter = lef + (righ - lef) / 2;
        return f(lef) * f(inter) < 0 ? bisection(f, lef, inter) : bisection(f, inter, righ);
    } else {
        return NULL;
    }
}



int main() {
  return 0;  
}
