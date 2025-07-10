package main

import (
	"os"
	"bufio"
	"fmt"
	"sort"
)

func main(){
	reader :=bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	var size int

	fmt.Fscanln(reader, &size)
	arr := make([]int, size)

	for i := 0; i < size; i++ {
		fmt.Fscan(reader, &arr[i])
	}

	sort.Ints(arr)
	time:=0
	sum := 0

	for i := 0; i < size; i++ {
		time = time + arr[i]
		sum += time
	}

	defer writer.Flush()
	fmt.Fprintln(writer, sum)
}