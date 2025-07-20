package main

import (
	"bufio"
	"fmt"
	"os"
)

var reader = bufio.NewReader(os.Stdin)

func getPeople(size int) []int {

	count := 0
	result := make([]int, size)

	for count < size {
		var index int
		fmt.Fscan(reader, &index)
		fmt.Fscan(reader, &result[index-1])

		count += 1
	}

	return result
}

func solution(arr []int) int {
	result := 0
	size := len(arr)
	compare := 0
	var min = size +1

	for compare < size {
		if arr[compare] < min {
			min = arr[compare]
			result++
		}
		compare++
	}
	
	return result
}

func main(){
	var tryN int
	var writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	
	fmt.Fscan(reader, &tryN)

	var try = 0

	for try < tryN {
		var peopleN int
		fmt.Fscan(reader, &peopleN)
		var arr []int

		arr = getPeople(peopleN)
		fmt.Fprintln(writer, solution(arr))
		
		try++
	}
}