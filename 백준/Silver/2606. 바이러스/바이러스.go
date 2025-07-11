package main

import (
	"bufio"
	"fmt"
	"os"
)

func dfs(node int, graph map[int][]int, visited map[int]bool) int {
	if visited[node] {
		return 0
	}
	visited[node] = true

	count := 1 // 자기 자신 포함
	for _, neighbor := range graph[node] {
		if !visited[neighbor]{
			count += dfs(neighbor, graph, visited)
		}
	}

	return count
}

func main(){
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var computer_count, connected_count int

	fmt.Fscan(reader, &computer_count)
	fmt.Fscan(reader, &connected_count)

	graph := make(map[int][]int)

	for i:=0; i< connected_count; i++ {
		var num1, num2 int
		fmt.Fscan(reader, &num1, &num2) 
		graph[num1] = append(graph[num1], num2)
		graph[num2] = append(graph[num2], num1)
	}

	visited := make(map[int]bool)
	totalConnected := dfs(1, graph, visited)

	fmt.Fprintln(writer, totalConnected-1) // 1번 컴퓨터 제외
}