import sys

N = int(sys.stdin.readline())
nums = list(map(int, sys.stdin.readline().strip().split(" ")))

dp = [1] * N

for node_index in range(N):
    for index in range(node_index):
        if nums[node_index] > nums[index]:
            dp[node_index] = max(dp[node_index], dp[index]+1)

print(max(dp))
