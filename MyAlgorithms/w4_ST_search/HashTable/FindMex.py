n = int(input())
arr = map(int, input().split())

close = 0

sml = {}

ans = []

for i in arr:
    sml[i] = 1
    while close in sml:
        close += 1
    ans.append(close)

print(*ans)
